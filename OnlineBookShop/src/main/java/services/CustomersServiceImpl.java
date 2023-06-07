package services;
import dao.CustomersDAO;
import models.Customers;
import java.util.List;
import java.util.Optional;

public class CustomersServiceImpl implements CustomersService {
    private final CustomersDAO customersDAO;

    public CustomersServiceImpl(CustomersDAO customersDAO) {
        this.customersDAO = customersDAO;
    }
    @Override
    public void createCustomer(Customers customer) {
        customersDAO.create(customer);
    }
    @Override
    public Optional<Customers> getCustomerById(int customerId) {
        return customersDAO.findById(customerId);
    }
    @Override
    public void updateCustomer(Customers customer) {
        customersDAO.update(customer);
    }
    @Override
    public void deleteCustomer(int customerId) {
        customersDAO.delete(customerId);
    }
    @Override
    public List<Customers> getAllCustomers() {
        return customersDAO.findAll();
    }
}

