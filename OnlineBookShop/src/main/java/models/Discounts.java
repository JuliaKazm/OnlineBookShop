package models;

import java.math.BigDecimal;

public class Discounts {
    private int discount_id;
    private String code;
    private BigDecimal percentage;
    private int orders_orders_id;

    public Discounts() {
    }

    public Discounts(int discount_id, String code, BigDecimal percentage, int orders_orders_id) {
        this.discount_id = discount_id;
        this.code = code;
        this.percentage = percentage;
        this.orders_orders_id = orders_orders_id;
    }

    public int getDiscount_id() {
        return discount_id;
    }

    public void setDiscount_id(int discount_id) {
        this.discount_id = discount_id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }

    public int getOrders_orders_id() {
        return orders_orders_id;
    }

    public void setOrders_orders_id(int orders_orders_id) {
        this.orders_orders_id = orders_orders_id;
    }

    @Override
    public String toString() {
        return "Discounts{" +
                "discount_id=" + discount_id +
                ", code='" + code + '\'' +
                ", percentage=" + percentage +
                ", orders_orders_id=" + orders_orders_id +
                '}';
    }
}
