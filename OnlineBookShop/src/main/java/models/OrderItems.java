package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;

public class OrderItems {
    @JsonProperty("item_id")
    private int item_id;

    @JsonProperty("order_id")
    private Integer order_id;

    @JsonProperty("book_id")
    private Integer book_id;

    @JsonProperty("quantity")
    private Integer quantity;

    @JsonProperty("price")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private double price;



    public OrderItems(int item_id, int order_id, int book_id, int quantity, double price) {
        this.item_id = item_id;
        this.order_id = order_id;
        this.book_id = book_id;
        this.quantity = quantity;
        this.price = price;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderItems{" +
                "item_id=" + item_id +
                ", order_id=" + order_id +
                ", book_id=" + book_id +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
