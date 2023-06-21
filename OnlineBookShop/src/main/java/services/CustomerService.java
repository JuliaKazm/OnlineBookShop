package services;

import dao.CustomersDAO;
import models.Customers;

import java.util.List;

public class CustomerService {
    private CustomersDAO customersDAO;

    public CustomerService() {
        customersDAO = new CustomersDAO();
    }

    public void insertCustomer(Customers customer) {
        customersDAO.create(customer);
    }

    public Customers selectCustomer(int customerId) {
        return customersDAO.findById(customerId).orElse(null);
    }

    public List<Customers> selectAllCustomers() {
        return customersDAO.findAll();
    }

    public void updateCustomer(Customers customer) {
        customersDAO.update(customer);
    }

    public void deleteCustomer(int customerId) {
        customersDAO.delete(customerId);
    }
}

