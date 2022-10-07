# ReactiveStream

#JAVApPOJ
=================== POM =====================
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>fit.se</groupId>
  <artifactId>Exercise4Chapter3Reactive</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <dependencies>
    <dependency>
        <groupId>org.mongodb</groupId>
        <artifactId>mongodb-driver-reactivestreams</artifactId>
        <version>4.6.0</version>
    </dependency>
    <dependency>
			<groupId>org.apache.logging.log4j</groupId>
			<artifactId>log4j-slf4j-impl</artifactId>
			<version>2.17.1</version>
		</dependency>
</dependencies>
</project>
================= ENTITY =========================
package entity;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.util.List;

public class Product {
    @BsonId
    private long productId;
    @BsonProperty("brand_name")
    private String brand;
    @BsonProperty("category_name")
    private String category;
    @BsonProperty("product_name")
    private  String name;
    private List<String> colors;
    @BsonProperty("model_year")
    private int modelYear;
    private double price;


    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", brand='" + brand + '\'' +
                ", category='" + category + '\'' +
                ", name='" + name + '\'' +
                ", colors=" + colors +
                ", modelYear=" + modelYear +
                ", price=" + price +
                '}';
    }
}
=========================================== Staff ====================
public class Staff {
    private Long staffId;
    private String firstName;
    private String lastName;
    private String email;
    private Phone phone;
    private Staff staff;

    public Staff(){}

    public Staff(Long staffId) {
        this.staffId = staffId;
    }

    public Staff(Long staffId, String firstName, String lastName, String email, Phone phone, Staff staff) {
        this.staffId = staffId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.staff = staff;
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staffId=" + staffId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", staff=" + staff +
                '}';
    }
}
=============================== OrderDetail ===================================
public class OrderDetail {
	private int quantity;
	private String color;
	private double price;
	private double discount;
	private double lineTotal;
	private Product product;

	public OrderDetail() {
	}

	/**
	 * @param quantity
	 * @param color
	 * @param productID
	 * @param price
	 * @param discount
	 */
	public OrderDetail(int quantity, String color, Product product, double price, double discount) {
		this.quantity = quantity;
		this.color = color;
		this.product = product;
		this.price = price;
		this.discount = discount;
		this.lineTotal = quantity * price * (1 - discount);
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * @return the lineTotal
	 */
	public double getLineTotal() {
		return lineTotal;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the discount
	 */
	public double getDiscount() {
		return discount;
	}

	/**
	 * @param discount the discount to set
	 */
	public void setDiscount(double discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "OrderDetail [quantity=" + quantity + ", color=" + color + ", product=" + product + ", lineTotal="
				+ lineTotal + ", price=" + price + ", discount=" + discount + "]";
	}

}

===================================  Order ====================================
public class Order {
	
	private String orderId;
	private Date orderDate;
	private Date shippedDate;
	private double orderTotal;
	
	private OrderStatus orderStatus;
	private Address shippingAddress;
	private Customer customer;
	private Staff staff;
	private List<OrderDetail> orderDetails;

	public Order() {
	}

	public Order(Date shippedDate, OrderStatus orderStatus) {
		super();
		this.shippedDate = shippedDate;
		this.orderStatus = orderStatus;
	}

	/**
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the orderDate
	 */
	public Date getOrderDate() {
		return orderDate;
	}

	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * @return the shippedDate
	 */
	public Date getShippedDate() {
		return shippedDate;
	}

	/**
	 * @param shippedDate the shippedDate to set
	 */
	public void setShippedDate(Date shippedDate) {
		this.shippedDate = shippedDate;
	}

	/**
	 * @return the orderTotal
	 */
	public double getOrderTotal() {
		return orderTotal;
	}

	/**
	 * @param orderTotal the orderTotal to set
	 */
	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}

	/**
	 * @return the orderStatus
	 */
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	/**
	 * @param orderStatus the orderStatus to set
	 */
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	/**
	 * @return the shippingAddress
	 */
	public Address getShippingAddress() {
		return shippingAddress;
	}

	/**
	 * @param shippingAddress the shippingAddress to set
	 */
	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the staff
	 */
	public Staff getStaff() {
		return staff;
	}

	/**
	 * @param staff the staff to set
	 */
	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	/**
	 * @return the orderDetails
	 */
	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	/**
	 * @param orderDetails the orderDetails to set
	 */
	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", shippedDate=" + shippedDate
				+ ", orderTotal=" + orderTotal + ", orderStatus=" + orderStatus + ", shippingAddress=" + shippingAddress
				+ ", customer=" + customer + ", staff=" + staff + ", orderDetails=" + orderDetails + "]";
	}
	
	
	
}

===============================  DBConnection ======================================
public class DBConnection {
	
	private static DBConnection instance;
	private MongoClient mongoClient;
	
	private DBConnection() {
		mongoClient = MongoClients.create(); //localhost 27017
	}
	
	public synchronized static DBConnection getInstance() {
		if(instance == null)
			instance = new DBConnection();
		
		return instance;
	}
	
	public MongoClient getMongoClient() {
		return mongoClient;
	}
}

================================= DAO ==============================
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

============================== ProductSubcriber ========================
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

=================== Mapper =============
public class Mapper {
    public static Document tranferStaffToDocument(Staff staff){
        Document phone = new Document("type", staff.getPhone().getType()).append("number", staff.getPhone().getNumber());
        return new Document(new Document("_id", staff.getStaffId())
                                 .append("first_name", staff.getFirstName()))
                                 .append("last_name", staff.getLastName())
                                 .append("phone",phone)
                                 .append("email", staff.getEmail())
                                 .append("manager_id", staff.getStaff().getStaffId());
    }

    public static Staff tranferDocumentToStaff(Document document)
    {
        Document phone = (Document) document.get("phone");
        return new Staff(document.getLong("_id"),
                         document.getString("first_name"),
                         document.getString("last_name"),
                         document.getString("email"),
                         new Phone(phone.getString("number"), phone.getString("type")),
                         new Staff(document.getLong("manager_id")));
    }
}
==================================  STAFFDAO==================
public class StaffDao {
    MongoCollection<Document> staffCol;

    public StaffDao(MongoClient mongoClient, String dcName) {
        staffCol = mongoClient.getDatabase(dcName).getCollection("staffs");
    }

    public Staff getStaffById(long id){
        Publisher<Document> publisher = staffCol.find(Filters.eq("_id", id)).first();

        DocumentSubcrise subcrise= new DocumentSubcrise();
        publisher.subscribe(subcrise);

        List<Staff> staff = new ArrayList<>();

        subcrise.getDocs().forEach(e -> staff.add(Mapper.tranferDocumentToStaff(e)));
        return staff.size() > 0 ? staff.get(0) : null;
    }
}
=========================== OrderDao ===========================
public class OrderDao {
	private MongoCollection<Document> orderCol;

	public OrderDao(MongoClient mongoClient, String dbName) {
		orderCol = mongoClient.getDatabase("BikeStores").getCollection("orders");
	}

	//	db.orders.aggregate([{$group:{_id:'$customer.customer_id','number od orders':{$sum:1}}}])

	public Map<String, Integer> getOrdersByCustomerId() {

		Map<String, Integer> map = new HashMap<>();

		AggregatePublisher<Document> publisher = orderCol.aggregate(Arrays.asList(Document.parse("{$group:{_id:'$customer.customer_id','number od orders':{$sum:1}}}")));
		OrderSubscriber subscriber = new OrderSubscriber();

		publisher.subscribe(subscriber);

		List<Document> documents = subscriber.getDocuments();

		for(Document doc : documents) {
			map.put(doc.getString("_id"), doc.getInteger("number od orders"));
		}

		return map;
	}
	
//	> db.orders.aggregate([{$group:{_id:'$customer.customer_id','number od orders':{$sum:1}}}, 
//	{$lookup:{from:'customers', localField:'_id', foreignField:'_id', as:'customer'}},
//	{$unwind:'$customer'}]).pretty()
	
}

class OrderSubscriber implements Subscriber<Document>{

	private CountDownLatch latch;
	private List<Document> docs;
	private Subscription s;

	public OrderSubscriber() {
		latch = new CountDownLatch(1);
		docs = new ArrayList<>();
	}

	@Override
	public void onComplete() {
		latch.countDown();
	}

	@Override
	public void onError(Throwable t) {
		t.printStackTrace();
	}

	@Override
	public void onNext(Document doc) {
		docs.add(doc);
		this.s.request(1);
	}

	@Override
	public void onSubscribe(Subscription s) {
		this.s = s;
		this.s.request(1);
	}

	public List<Document> getDocuments() {

		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return docs;
	}

}
============================= Application =========================
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

