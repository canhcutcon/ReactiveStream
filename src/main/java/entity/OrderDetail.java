package entity;

public class OrderDetail {
    private int quality;
    private String color;
    private Product product;
    private double lineTotal, price, discount;

    public OrderDetail(){}

    public OrderDetail(int quality, String color, Product product, double lineTotal, double price, double discount) {
        this.quality = quality;
        this.color = color;
        this.product = product;
        this.lineTotal = lineTotal;
        this.price = price;
        this.discount = discount;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getLineTotal() {
        return lineTotal;
    }

    public void setLineTotal(double lineTotal) {
        this.lineTotal = lineTotal;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "quality=" + quality +
                ", color='" + color + '\'' +
                ", product=" + product +
                ", lineTotal=" + lineTotal +
                ", price=" + price +
                ", discount=" + discount +
                '}';
    }
}
