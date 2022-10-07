package app;

import com.mongodb.reactivestreams.client.MongoClient;
import dao.ProductDao;
import dao.subscriber.StaffDao;
import entity.Product;
import entity.Staff;
import utils.DbConnection;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final String DB_NAME = "BikeStores";

    public static void main(String[] args){
        MongoClient mongoClient = DbConnection.getInstance().getMongoClient();

        ProductDao productDao = new ProductDao(mongoClient, DB_NAME);
//        ================== WITH JAVAPOJO =====================
        System.out.println(productDao.getProductByID(15).toString());
//        List<Product> products = new ArrayList<>();
//        List<String> colors = new ArrayList<>();
//        colors.add("gray");
//        colors.add("pink");
//        products.add(new Product(2030,"Electra","Cruisers Bicycles", "Vo Thi Tra Giang",colors,2022,10000));
//        productDao.addProduct(products);
        System.out.println(productDao.getProductByID(2030).toString());
//        productDao.getProductsMax().forEach(e -> System.out.println(e));
//        productDao.update();
//        System.out.println(productDao.getProductByID(2030).toString());

        productDao.delete();
        System.out.println(productDao.getProductByID(2030).toString());
////         With Document
//        StaffDao staffDao = new StaffDao(mongoClient,DB_NAME);
//        Staff staff = staffDao.getStaffById(8);
//        System.out.println(staff.toString());
    }

}
