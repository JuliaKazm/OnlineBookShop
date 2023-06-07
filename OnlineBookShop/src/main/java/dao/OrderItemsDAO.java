package dao;
import interfaces.IOrderItemsDAO;
import models.OrderItems;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderItemsDAO implements IOrderItemsDAO {
    private final static String INSERT = "INSERT INTO OrderItems (item_id, order_id, book_id, quantity, price) VALUES (?, ?, ?, ?, ?)";
    private final static String UPDATE = "UPDATE OrderItems SET order_id = ?, book_id = ?, quantity = ?, price = ? WHERE item_id = ?";
    private final static String DELETE = "DELETE FROM OrderItems WHERE item_id = ?";
    private final static String SELECT_BY_ID = "SELECT * FROM OrderItems WHERE item_id = ?";
    private final static String SELECT_ALL = "SELECT * FROM OrderItems";

    private Connection connection;

    public OrderItemsDAO(Connection connection) {
        this.connection = connection;
    }

    public Optional<OrderItems> findById(int item_id) {
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)) {
            statement.setInt(1, item_id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    OrderItems orderItem = createOrderItemFromResultSet(resultSet);
                    return Optional.of(orderItem);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public List<OrderItems> findAll() {
        List<OrderItems> orderItemsList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                OrderItems orderItem = createOrderItemFromResultSet(resultSet);
                orderItemsList.add(orderItem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderItemsList;
    }

    public void addOrderItem(OrderItems orderItem) {
        try (PreparedStatement statement = connection.prepareStatement(INSERT)) {
            statement.setInt(1, orderItem.getItem_id());
            statement.setInt(2, orderItem.getOrder_id());
            statement.setInt(3, orderItem.getBook_id());
            statement.setInt(4, orderItem.getQuantity());
            statement.setBigDecimal(5, orderItem.getPrice());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateOrderItem(OrderItems orderItem) {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            statement.setInt(1, orderItem.getOrder_id());
            statement.setInt(2, orderItem.getBook_id());
            statement.setInt(3, orderItem.getQuantity());
            statement.setBigDecimal(4, orderItem.getPrice());
            statement.setInt(5, orderItem.getItem_id());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteOrderItem(int item_id) {
        try (PreparedStatement statement = connection.prepareStatement(DELETE)) {
            statement.setInt(1, item_id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private OrderItems createOrderItemFromResultSet(ResultSet resultSet) throws SQLException {
        int item_id = resultSet.getInt("item_id");
        Integer order_id = resultSet.getInt("order_id");
        Integer book_id = resultSet.getInt("book_id");
        Integer quantity = resultSet.getInt("quantity");
        BigDecimal price = resultSet.getBigDecimal("price");
        return new OrderItems(item_id, order_id, book_id, quantity, price);
    }

    @Override
    public void create(OrderItems entity) throws SQLException {
        addOrderItem(entity);
    }

    @Override
    public List<OrderItems> getAll() throws SQLException {
        return findAll();
    }

    @Override
    public Optional<OrderItems> getById(int id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public void update(OrderItems entity) throws SQLException {
        updateOrderItem(entity);
    }

    @Override
    public void delete(int id) throws SQLException {
        deleteOrderItem(id);
    }
}
