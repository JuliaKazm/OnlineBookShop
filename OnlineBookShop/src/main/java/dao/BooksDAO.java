package dao;
import interfaces.IBooksDAO;
import models.Books;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BooksDAO implements IBooksDAO {

    private final static String INSERT = "INSERT INTO Books(book_id, title, author_id, genre, Publishers_publisher_id, BookStock_book_stock_id) VALUES(?, ?, ?, ?, ?, ?)";
    private final static String UPDATE = "UPDATE Books SET title = ?, author_id = ?, genre = ?, Publishers_publisher_id = ?, BookStock_book_stock_id = ? WHERE book_id = ?";
    private final static String DELETE = "DELETE FROM Books WHERE book_id = ?";
    private final static String SELECT_ALL = "SELECT * FROM Books";

    private Connection connection;

    public BooksDAO(Connection connection) {
        this.connection = connection;
    }

    public BooksDAO() {

    }

    @Override
    public Optional<Books> findById(int id) {
        String query = "SELECT * FROM Books WHERE book_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Books book = new Books();
                book.setBook_id(resultSet.getInt("book_id"));
                book.setTitle(resultSet.getString("title"));
                book.setAuthor_id(resultSet.getInt("author_id"));
                book.setGenre(resultSet.getString("genre"));
                book.setPublishers_publisher_id(resultSet.getInt("Publishers_publisher_id"));
                book.setBookStock_book_stock_id(resultSet.getInt("BookStock_book_stock_id"));
                return Optional.of(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Books> findAll() {
        List<Books> books = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Books book = new Books();
                book.setBook_id(resultSet.getInt("book_id"));
                book.setTitle(resultSet.getString("title"));
                book.setAuthor_id(resultSet.getInt("author_id"));
                book.setGenre(resultSet.getString("genre"));
                book.setPublishers_publisher_id(resultSet.getInt("Publishers_publisher_id"));
                book.setBookStock_book_stock_id(resultSet.getInt("BookStock_book_stock_id"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public void create(Books book) {
        try (PreparedStatement statement = connection.prepareStatement(INSERT)) {
            statement.setInt(1, book.getBook_id());
            statement.setString(2, book.getTitle());
            statement.setInt(3, book.getAuthor_id());
            statement.setString(4, book.getGenre());
            statement.setInt(5, book.getPublishers_publisher_id());
            statement.setInt(6, book.getBookStock_book_stock_id());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Books> getAll() throws SQLException {
        return null;
    }

    @Override
    public Optional<Books> getById(int id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public void update(Books book) {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            statement.setString(1, book.getTitle());
            statement.setInt(2, book.getAuthor_id());
            statement.setString(3, book.getGenre());
            statement.setInt(4, book.getPublishers_publisher_id());
            statement.setInt(5, book.getBookStock_book_stock_id());
            statement.setInt(6, book.getBook_id());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement statement = connection.prepareStatement(DELETE)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
