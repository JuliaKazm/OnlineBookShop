package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "customer")
@XmlAccessorType(XmlAccessType.FIELD)
public class Customers {
    @XmlElement(name = "customer_id")
    @JsonProperty("customer_id")
    private int customer_id;

    @XmlElement(name = "first_name")
    @JsonProperty("first_name")
    private String first_name;

    @XmlElement(name = "last_name")
    @JsonProperty("last_name")
    private String last_name;

    @XmlElement(name = "address")
    @JsonProperty("address")
    private String address;

    @XmlElement(name = "contact_details")
    @JsonProperty("contact_details")
    private String contact_details;

    public Customers() {
    }

    public Customers(int customer_id, String first_name, String last_name, String address, String contact_details) {
        this.customer_id = customer_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.contact_details = contact_details;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact_details() {
        return contact_details;
    }

    public void setContact_details(String contact_details) {
        this.contact_details = contact_details;
    }

    @Override
    public String toString() {
        return "Customers{" +
                "customer_id=" + customer_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", address='" + address + '\'' +
                ", contact_details='" + contact_details + '\'' +
                '}';
    }
}
