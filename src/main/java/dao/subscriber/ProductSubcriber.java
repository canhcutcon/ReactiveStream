package dao.subscriber;

import entity.Product;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class ProductSubcriber implements Subscriber<Product> {
    private CountDownLatch latch;
    private List<Product> products;
    private Subscription subscription;

    public ProductSubcriber() {
        latch = new CountDownLatch(1);
        products = new ArrayList<>();
    }

    @Override
    public void onSubscribe(Subscription s) {
        this.subscription = s;
        this.subscription.request(1);
    }

    @Override
    public void onNext(Product product) {
        products.add(product);
        this.subscription.request(1);
    }

    @Override
    public void onError(Throwable t) {
        t.printStackTrace();
    }

    @Override
    public void onComplete() {
        latch.countDown();
    }

    public List<Product> getProducts(){
        try {
            latch.await();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return products;
    }
}
