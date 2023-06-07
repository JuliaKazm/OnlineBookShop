package services;
import models.Customers;
import java.util.List;
import java.util.Optional;

public interface CustomersService {
    void createCustomer(Customers customer);
    Optional<Customers> getCustomerById(int customerId);
    void updateCustomer(Customers customer);
    void deleteCustomer(int customerId);
    List<Customers> getAllCustomers();
}
