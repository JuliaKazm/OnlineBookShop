package dao;
import interfaces.IBookStockDAO;
import models.BookStock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookStockDAO implements IBookStockDAO {
    private final static String INSERT = "INSERT INTO BookStock(address, phone_number, department_id) VALUES (?, ?, ?)";
    private final static String UPDATE = "UPDATE BookStock SET address = ?, phone_number = ?, department_id = ? WHERE book_stock_id = ?";
    private final static String DELETE = "DELETE FROM BookStock WHERE book_stock_id = ?";
    private final static String SELECT_ALL = "SELECT * FROM BookStock";
    private final static String SELECT_BY_ID = "SELECT * FROM BookStock WHERE book_stock_id = ?";

    private Connection connection;

    public BookStockDAO(Connection connection) {
        this.connection = connection;
    }

    public void create(BookStock bookStock) {
        try (PreparedStatement statement = connection.prepareStatement(INSERT)) {
            statement.setString(1, bookStock.getAddress());
            statement.setString(2, bookStock.getPhone_number());
            statement.setInt(3, bookStock.getDepartment_id());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<BookStock> getAll() throws SQLException {
        return null;
    }

    @Override
    public Optional<BookStock> getById(int id) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    BookStock bookStock = new BookStock();
                    bookStock.setBook_stock_id(resultSet.getInt("book_stock_id"));
                    bookStock.setAddress(resultSet.getString("address"));
                    bookStock.setPhone_number(resultSet.getString("phone_number"));
                    bookStock.setDepartment_id(resultSet.getInt("department_id"));
                    return Optional.of(bookStock);
                }
            }
        }
        return Optional.empty();
    }

    public void update(BookStock bookStock) {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            statement.setString(1, bookStock.getAddress());
            statement.setString(2, bookStock.getPhone_number());
            statement.setInt(3, bookStock.getDepartment_id());
            statement.setInt(4, bookStock.getBook_stock_id());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int bookStockId) {
        try (PreparedStatement statement = connection.prepareStatement(DELETE)) {
            statement.setInt(1, bookStockId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<BookStock> findAll() {
        List<BookStock> bookStocks = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                BookStock bookStock = new BookStock();
                bookStock.setBook_stock_id(resultSet.getInt("book_stock_id"));
                bookStock.setAddress(resultSet.getString("address"));
                bookStock.setPhone_number(resultSet.getString("phone_number"));
                bookStock.setDepartment_id(resultSet.getInt("department_id"));
                bookStocks.add(bookStock);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookStocks;
    }

    public Optional<BookStock> findById(int bookStockId) {
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)) {
            statement.setInt(1, bookStockId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                BookStock bookStock = new BookStock();
                bookStock.setBook_stock_id(resultSet.getInt("book_stock_id"));
                bookStock.setAddress(resultSet.getString("address"));
                bookStock.setPhone_number(resultSet.getString("phone_number"));
                bookStock.setDepartment_id(resultSet.getInt("department_id"));
                return Optional.of(bookStock);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
