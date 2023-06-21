package dao;
import interfaces.IOrdersDAO;
import models.Orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrdersDAO implements IOrdersDAO {
    private final static String SELECT_BY_ID = "SELECT * FROM Orders WHERE orders_id = ?";
    private final static String SELECT_ALL = "SELECT * FROM Orders";
    private final static String INSERT = "INSERT INTO Orders (orders_id, customer_id, order_date, order_status) VALUES (?, ?, ?, ?)";
    private final static String UPDATE = "UPDATE Orders SET customer_id = ?, order_date = ?, order_status = ? WHERE orders_id = ?";
    private final static String DELETE = "DELETE FROM Orders WHERE orders_id = ?";

    private Connection connection;

    public OrdersDAO(Connection connection) {
        this.connection = connection;
    }

    public OrdersDAO() {

    }

    public Optional<Orders> findById(int ordersId) {
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)) {
            statement.setInt(1, ordersId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Orders orders = mapResultSetToOrders(resultSet);
                return Optional.of(orders);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public List<Orders> findAll() {
        List<Orders> ordersList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Orders orders = mapResultSetToOrders(resultSet);
                ordersList.add(orders);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ordersList;
    }

    public void create(Orders orders) {
        try (PreparedStatement statement = connection.prepareStatement(INSERT)) {
            statement.setInt(1, orders.getOrders_id());
            statement.setInt(2, orders.getCustomer_id());
            statement.setDate(3, orders.getOrder_date());
            statement.setString(4, orders.getOrder_status());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Orders> getAll() throws SQLException {
        List<Orders> ordersList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Orders orders = mapResultSetToOrders(resultSet);
                ordersList.add(orders);
            }
        }
        return ordersList;
    }

    @Override
    public Optional<Orders> getById(int id) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Orders orders = mapResultSetToOrders(resultSet);
                    return Optional.of(orders);
                }
            }
        }
        return Optional.empty();
    }

    public void update(Orders orders) {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            statement.setInt(1, orders.getCustomer_id());
            statement.setDate(2, orders.getOrder_date());
            statement.setString(3, orders.getOrder_status());
            statement.setInt(4, orders.getOrders_id());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int ordersId) {
        try (PreparedStatement statement = connection.prepareStatement(DELETE)) {
            statement.setInt(1, ordersId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Orders mapResultSetToOrders(ResultSet resultSet) throws SQLException {
        Orders orders = new Orders();
        orders.setOrders_id(resultSet.getInt("orders_id"));
        orders.setCustomer_id(resultSet.getInt("customer_id"));
        orders.setOrder_date(resultSet.getDate("order_date"));
        orders.setOrder_status(resultSet.getString("order_status"));
        return orders;
    }
}
