package entity;

import java.time.LocalDate;
import java.util.List;

public class Order {
    private String orderId, orderStatus;
    private LocalDate orderDate, shippedDate;
    private Customer customer;
    private Staff staff;
    private double orderTotal;
    private Address address;
    private List<OrderDetail> orderDetails;

    public Order(){}

    public Order(String orderId, String orderStatus, LocalDate orderDate, LocalDate shippedDate, Customer customer, Staff staff, double orderTotal, Address address, List<OrderDetail> orderDetails) {
        this.orderId = orderId;
        this.orderStatus = orderStatus;
        this.orderDate = orderDate;
        this.shippedDate = shippedDate;
        this.customer = customer;
        this.staff = staff;
        this.orderTotal = orderTotal;
        this.address = address;
        this.orderDetails = orderDetails;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(LocalDate shippedDate) {
        this.shippedDate = shippedDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", orderDate=" + orderDate +
                ", shippedDate=" + shippedDate +
                ", customer=" + customer +
                ", staff=" + staff +
                ", orderTotal=" + orderTotal +
                ", address=" + address +
                ", orderDetails=" + orderDetails +
                '}';
    }
}
