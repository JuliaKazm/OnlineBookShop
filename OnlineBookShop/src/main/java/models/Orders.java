package models;

import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import jaxb.DateAdapter;

@XmlRootElement(name = "order")
@XmlAccessorType(XmlAccessType.FIELD)
public class Orders {
    @XmlElement(name = "orders_id")
    @JsonProperty("orders_id")
    private int orders_id;

    @XmlElement(name = "customer_id")
    @JsonProperty("customer_id")
    private Integer customer_id;

    @XmlElement(name = "order_date")
    @XmlJavaTypeAdapter(DateAdapter.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date order_date;

    @XmlElement(name = "order_status")
    @JsonProperty("order_status")
    private String order_status;

    public Orders() {
    }

    public Orders(int orders_id, Integer customer_id, Date order_date, String order_status) {
        this.orders_id = orders_id;
        this.customer_id = customer_id;
        this.order_date = order_date;
        this.order_status = order_status;
    }

    public Orders(int ordersId, int customerId, String date, String pending) {
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
