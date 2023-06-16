package models;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Discounts {
    @JsonProperty("discount_id")
    private int discount_id;

    @JsonProperty("code")
    private String code;

    @JsonProperty("percentage")
    private BigDecimal percentage;

    @JsonProperty("orders_orders_id")
    private int orders_orders_id;

    public Discounts() {
    }

    public Discounts(int discount_id, String code, double percentage, int orders_orders_id) {
        this.discount_id = discount_id;
        this.code = code;
        this.percentage = BigDecimal.valueOf(percentage);
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
