package models;
import java.math.BigDecimal;
import java.sql.Date;

public class Payments {
    private int payment_id;
    private Integer customer_id;
    private Integer order_id;
    private BigDecimal payment_amount;
    private Date payment_date;

    public Payments() {
    }

    public Payments(int payment_id, Integer customer_id, Integer order_id, BigDecimal payment_amount, Date payment_date) {
        this.payment_id = payment_id;
        this.customer_id = customer_id;
        this.order_id = order_id;
        this.payment_amount = payment_amount;
        this.payment_date = payment_date;
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

    public BigDecimal getPayment_amount() {
        return payment_amount;
    }

    public void setPayment_amount(BigDecimal payment_amount) {
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
