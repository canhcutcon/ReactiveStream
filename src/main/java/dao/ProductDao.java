package dao;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.InsertManyResult;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.reactivestreams.client.AggregatePublisher;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoCollection;
import dao.subscriber.ProductSubcriber;
import entity.Product;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.Arrays;
import java.util.List;


public class ProductDao {
    MongoCollection<Product> proCol;

    public ProductDao(MongoClient mongoClient, String dbName) {
        PojoCodecProvider pojoCodecProvider = PojoCodecProvider.builder()
                                                                .automatic(true).build();
        CodecRegistry codecRegistry = CodecRegistries.fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), CodecRegistries.fromProviders(pojoCodecProvider));

        proCol = mongoClient.getDatabase(dbName)
                            .getCollection("products",Product.class)
                            .withCodecRegistry(codecRegistry);

    }

    public int addProduct(List<Product> products){
        Publisher<InsertManyResult> publisher = proCol.insertMany(products);
        publisher.subscribe(new Subscriber<InsertManyResult>() {
            @Override
            public void onSubscribe(Subscription subscription) {
                subscription.request(1);
            }

            @Override
            public void onNext(InsertManyResult insertManyResult) {
                System.out.println("Inserted " + insertManyResult);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("FAIL");
            }

            @Override
            public void onComplete() {
                System.out.println("SUCCESS");
            }
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public Product getProductByID(long productID){
        Publisher<Product> publisher =
                proCol.find(Filters.eq("_id",productID)).first();

        ProductSubcriber subcriber = new ProductSubcriber();
        publisher.subscribe(subcriber);

        List<Product> products = subcriber.getProducts();
        return products.size() > 0 ? products.get(0) : null;
    }

    public List<Product> getProductsMax() {

        AggregatePublisher<Product> publisher = proCol.aggregate(Arrays.asList(
                Document.parse("{$group:{_id:null, products:{$push:\"$$ROOT\"},max:{$max:'$price'}}}"),
                Document.parse("{$unwind:'$products'}"),
                Document.parse("{$match:{$expr:{$eq:[\"$max\",\"$products.price\"]}}}"),
                Document.parse("{$replaceWith:'$products'}")
        ));

        ProductSubcriber subcriber = new ProductSubcriber();
        publisher.subscribe(subcriber);

        List<Product> products = subcriber.getProducts();
        return products;
    }

    public int delete(){
        Publisher<Product> publisher = proCol.findOneAndDelete(Filters.eq("_id", 2030));

        ProductSubcriber subcriber = new ProductSubcriber();
        publisher.subscribe(subcriber);

        return 0;
    }

    public int update()
    {
//        Bson updates = Updates.combine(Updates.set("city", zip.getCity()), Updates.set("state", zip.getState()),
//                Updates.set("zips", zip.getState()), Updates.set("pop", zip.getState()), Updates.set("loc", loc),
//                Updates.currentTimestamp("lastUpdated"));
//        zipCol.updateOne(Filters.eq("_id", new ObjectId(id)), updates);
        Bson update = Updates.combine(Updates.set("product_name", "Zoe"));
        Publisher<UpdateResult> publisher = proCol.updateOne(Filters.eq("_id", 2030),update);
        ProductSubcriber subcriber = new ProductSubcriber();
        publisher.subscribe(new Subscriber<UpdateResult>() {
            @Override
            public void onSubscribe(Subscription s) {
                s.request(1);
            }

            @Override
            public void onNext(UpdateResult updateResult) {
                System.out.println("upate");
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onComplete() {
                System.out.println("Finish");
            }
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
