package dao;
import interfaces.ICustomersDAO;
import models.Customers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomersDAO implements ICustomersDAO {
    private final static String INSERT = "INSERT INTO Customers(customer_id, first_name, last_name, address, contact_details) VALUES (?, ?, ?, ?, ?)";
    private final static String UPDATE = "UPDATE Customers SET first_name = ?, last_name = ?, address = ?, contact_details = ? WHERE customer_id = ?";
    private final static String DELETE = "DELETE FROM Customers WHERE customer_id = ?";
    private final static String SELECT_ALL = "SELECT * FROM Customers";
    private final static String SELECT_BY_ID = "SELECT * FROM Customers WHERE customer_id = ?";

    private Connection connection;

    public CustomersDAO(Connection connection) {
        this.connection = connection;
    }

    public CustomersDAO() {

    }

    public void create(Customers customer) {
        try (PreparedStatement statement = connection.prepareStatement(INSERT)) {
            statement.setInt(1, customer.getCustomer_id());
            statement.setString(2, customer.getFirst_name());
            statement.setString(3, customer.getLast_name());
            statement.setString(4, customer.getAddress());
            statement.setString(5, customer.getContact_details());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Customers> getAll() throws SQLException {
        return null;
    }

    @Override
    public Optional<Customers> getById(int id) throws SQLException {
        return Optional.empty();
    }

    public Optional<Customers> findById(int customerId) {
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)) {
            statement.setInt(1, customerId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Customers customer = new Customers();
                customer.setCustomer_id(resultSet.getInt("customer_id"));
                customer.setFirst_name(resultSet.getString("first_name"));
                customer.setLast_name(resultSet.getString("last_name"));
                customer.setAddress(resultSet.getString("address"));
                customer.setContact_details(resultSet.getString("contact_details"));
                return Optional.of(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public List<Customers> findAll() {
        List<Customers> customers = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Customers customer = new Customers();
                customer.setCustomer_id(resultSet.getInt("customer_id"));
                customer.setFirst_name(resultSet.getString("first_name"));
                customer.setLast_name(resultSet.getString("last_name"));
                customer.setAddress(resultSet.getString("address"));
                customer.setContact_details(resultSet.getString("contact_details"));
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public void update(Customers customer) {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            statement.setString(1, customer.getFirst_name());
            statement.setString(2, customer.getLast_name());
            statement.setString(3, customer.getAddress());
            statement.setString(4, customer.getContact_details());
            statement.setInt(5, customer.getCustomer_id());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int customerId) {
        try (PreparedStatement statement = connection.prepareStatement(DELETE)) {
            statement.setInt(1, customerId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
