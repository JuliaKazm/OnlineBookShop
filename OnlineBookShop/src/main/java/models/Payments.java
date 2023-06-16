package models;

import java.sql.Date;
import jakarta.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;

@XmlRootElement(name = "payment")
@XmlAccessorType(XmlAccessType.FIELD)
public class Payments {
    @XmlElement(name = "payment_id")
    @JsonProperty("payment_id")
    private int payment_id;

    @XmlElement(name = "customer_id")
    @JsonProperty("customer_id")
    private Integer customer_id;

    @XmlElement(name = "order_id")
    @JsonProperty("order_id")
    private Integer order_id;

    @XmlElement(name = "payment_amount")
    @JsonProperty("payment_amount")
    private double payment_amount;

    @XmlElement(name = "payment_date")
    @JsonProperty("payment_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date payment_date;

    public Payments() {
    }

    public Payments(int payment_id, Integer customer_id, Integer order_id, double payment_amount, Date payment_date) {
        this.payment_id = payment_id;
        this.customer_id = customer_id;
        this.order_id = order_id;
        this.payment_amount = payment_amount;
        this.payment_date = payment_date;
    }

    public Payments(int paymentId, int customerId, int orderId, double paymentAmount, String date) {
    }

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public double getPayment_amount() {
        return payment_amount;
    }

    public void setPayment_amount(double payment_amount) {
        this.payment_amount = payment_amount;
    }

    public Date getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(Date payment_date) {
        this.payment_date = payment_date;
    }

    @Override
    public String toString() {
        return "Payments{" +
                "payment_id=" + payment_id +
                ", customer_id=" + customer_id +
                ", order_id=" + order_id +
                ", payment_amount=" + payment_amount +
                ", payment_date=" + payment_date +
                '}';
    }
}
