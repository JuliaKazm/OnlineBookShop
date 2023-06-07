package models;

import java.math.BigDecimal;

public class OrderItems {
    private int item_id;
    private Integer order_id;
    private Integer book_id;
    private Integer quantity;
    private BigDecimal price;

    public OrderItems() {
    }

    public OrderItems(int item_id, Integer order_id, Integer book_id, Integer quantity, BigDecimal price) {
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
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
