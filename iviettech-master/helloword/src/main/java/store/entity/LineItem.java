package store.entity;

import javax.persistence.*;

@Entity
@Table(name = "line_item")
public class LineItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "orderId")
    private long orderId;

    @Column(name = "productId")
    private long productId;

    @Column(name = "price")
    private double price;

    @Column(name = "quantity")
    private int quantity;

    public LineItem() {
        this.orderId = 0;
        this.productId = 0;
        this.price = 0;
        this.quantity = 0;
    }

    public LineItem(long orderId, long productId, double price, int quantity) {
        this.orderId = orderId;
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "LineItem{" +
                "id=" + id +
                ", productId=" + productId +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

    public double getAmount(){
        return this.price * this.quantity;
    }
}
