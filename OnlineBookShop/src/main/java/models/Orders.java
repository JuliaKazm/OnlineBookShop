package models;

import java.sql.Date;

public class Orders {
    private int orders_id;
    private Integer customer_id;
    private Date order_date;
    private String order_status;

    public Orders() {
    }

    public Orders(int orders_id, Integer customer_id, Date order_date, String order_status) {
        this.orders_id = orders_id;
        this.customer_id = customer_id;
        this.order_date = order_date;
        this.order_status = order_status;
    }

    public int getOrders_id() {
        return orders_id;
    }

    public void setOrders_id(int orders_id) {
        this.orders_id = orders_id;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orders_id=" + orders_id +
                ", customer_id=" + customer_id +
                ", order_date=" + order_date +
                ", order_status='" + order_status + '\'' +
                '}';
    }
}

