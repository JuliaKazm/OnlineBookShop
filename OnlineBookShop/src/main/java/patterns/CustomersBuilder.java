package patterns;
import models.Customers;

public class CustomersBuilder {
    private int customer_id;
    private String first_name;
    private String last_name;
    private String address;
    private String contact_details;

    public CustomersBuilder withCustomerId(int customer_id) {
        this.customer_id = customer_id;
        return this;
    }

    public CustomersBuilder withFirstName(String first_name) {
        this.first_name = first_name;
        return this;
    }

    public CustomersBuilder withLastName(String last_name) {
        this.last_name = last_name;
        return this;
    }

    public CustomersBuilder withAddress(String address) {
        this.address = address;
        return this;
    }

    public CustomersBuilder withContactDetails(String contact_details) {
        this.contact_details = contact_details;
        return this;
    }

    public Customers build() {
        Customers customers = new Customers();
        customers.setCustomer_id(customer_id);
        customers.setFirst_name(first_name);
        customers.setLast_name(last_name);
        customers.setAddress(address);
        customers.setContact_details(contact_details);
        return customers;
    }
}
