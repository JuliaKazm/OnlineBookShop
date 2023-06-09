package jaxb;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import models.Customers;
import models.Orders;
import models.Payments;

@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class DataWrapper {
    @XmlElement(name = "payment")
    private Payments payment;
    @XmlElement(name = "customer")
    private Customers customer;
    @XmlElement(name = "order")
    private Orders order;

    public DataWrapper() {
    }

    public DataWrapper(Payments payment, Customers customer, Orders order) {
        this.payment = payment;
        this.customer = customer;
        this.order = order;
    }

    public Payments getPayment() {
        return payment;
    }

    public void setPayment(Payments payment) {
        this.payment = payment;
    }

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }
}
