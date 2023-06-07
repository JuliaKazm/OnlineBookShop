package dao;
import interfaces.IDiscountsDAO;
import models.Discounts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DiscountsDAO implements IDiscountsDAO {
    private static final String INSERT = "INSERT INTO Discounts(discount_id, code, percentage, Orders_orders_id) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE Discounts SET code = ?, percentage = ?, Orders_orders_id = ? WHERE discount_id = ?";
    private static final String DELETE = "DELETE FROM Discounts WHERE discount_id = ?";
    private static final String SELECT_ALL = "SELECT * FROM Discounts";
    private static final String SELECT_BY_ID = "SELECT * FROM Discounts WHERE discount_id = ?";

    private Connection connection;

    public DiscountsDAO(Connection connection) {
        this.connection = connection;
    }

    public void create(Discounts discount) {
        try (PreparedStatement statement = connection.prepareStatement(INSERT)) {
            statement.setInt(1, discount.getDiscount_id());
            statement.setString(2, discount.getCode());
            statement.setBigDecimal(3, discount.getPercentage());
            statement.setInt(4, discount.getOrders_orders_id());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Discounts> getAll() throws SQLException {
        return null;
    }

    @Override
    public Optional<Discounts> getById(int id) throws SQLException {
        return Optional.empty();
    }

    public Optional<Discounts> findById(int discountId) {
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)) {
            statement.setInt(1, discountId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Discounts discount = new Discounts();
                discount.setDiscount_id(resultSet.getInt("discount_id"));
                discount.setCode(resultSet.getString("code"));
                discount.setPercentage(resultSet.getBigDecimal("percentage"));
                discount.setOrders_orders_id(resultSet.getInt("Orders_orders_id"));
                return Optional.of(discount);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public List<Discounts> findAll() {
        List<Discounts> discounts = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Discounts discount = new Discounts();
                discount.setDiscount_id(resultSet.getInt("discount_id"));
                discount.setCode(resultSet.getString("code"));
                discount.setPercentage(resultSet.getBigDecimal("percentage"));
                discount.setOrders_orders_id(resultSet.getInt("Orders_orders_id"));
                discounts.add(discount);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return discounts;
    }

    public void update(Discounts discount) {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            statement.setString(1, discount.getCode());
            statement.setBigDecimal(2, discount.getPercentage());
            statement.setInt(3, discount.getOrders_orders_id());
            statement.setInt(4, discount.getDiscount_id());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int discountId) {
        try (PreparedStatement statement = connection.prepareStatement(DELETE)) {
            statement.setInt(1, discountId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

