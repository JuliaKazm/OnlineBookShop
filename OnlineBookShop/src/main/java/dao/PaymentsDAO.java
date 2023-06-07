package dao;
import interfaces.IPaymentsDAO;
import models.Payments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PaymentsDAO implements IPaymentsDAO {
    private final static String INSERT = "INSERT INTO Payments(payment_id, customer_id, order_id, payment_amount, payment_date) VALUES (?, ?, ?, ?, ?)";
    private final static String UPDATE = "UPDATE Payments SET customer_id = ?, order_id = ?, payment_amount = ?, payment_date = ? WHERE payment_id = ?";
    private final static String DELETE = "DELETE FROM Payments WHERE payment_id = ?";
    private final static String SELECT_ALL = "SELECT * FROM Payments";
    private final static String SELECT_BY_ID = "SELECT * FROM Payments WHERE payment_id = ?";

    private Connection connection;

    public PaymentsDAO(Connection connection) {
        this.connection = connection;
    }

    public void create(Payments payment) {
        try (PreparedStatement statement = connection.prepareStatement(INSERT)) {
            statement.setInt(1, payment.getPayment_id());
            statement.setInt(2, payment.getCustomer_id());
            statement.setInt(3, payment.getOrder_id());
            statement.setBigDecimal(4, payment.getPayment_amount());
            statement.setDate(5, payment.getPayment_date());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Payments> getAll() throws SQLException {
        return null;
    }

    @Override
    public Optional<Payments> getById(int id) throws SQLException {
        return Optional.empty();
    }

    public void update(Payments payment) {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            statement.setInt(1, payment.getCustomer_id());
            statement.setInt(2, payment.getOrder_id());
            statement.setBigDecimal(3, payment.getPayment_amount());
            statement.setDate(4, payment.getPayment_date());
            statement.setInt(5, payment.getPayment_id());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int paymentId) {
        try (PreparedStatement statement = connection.prepareStatement(DELETE)) {
            statement.setInt(1, paymentId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Payments> findAll() {
        List<Payments> payments = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Payments payment = new Payments();
                payment.setPayment_id(resultSet.getInt("payment_id"));
                payment.setCustomer_id(resultSet.getInt("customer_id"));
                payment.setOrder_id(resultSet.getInt("order_id"));
                payment.setPayment_amount(resultSet.getBigDecimal("payment_amount"));
                payment.setPayment_date(resultSet.getDate("payment_date"));
                payments.add(payment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payments;
    }

    public Optional<Payments> findById(int paymentId) {
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)) {
            statement.setInt(1, paymentId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Payments payment = new Payments();
                payment.setPayment_id(resultSet.getInt("payment_id"));
                payment.setCustomer_id(resultSet.getInt("customer_id"));
                payment.setOrder_id(resultSet.getInt("order_id"));
                payment.setPayment_amount(resultSet.getBigDecimal("payment_amount"));
                payment.setPayment_date(resultSet.getDate("payment_date"));
                return Optional.of(payment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}

