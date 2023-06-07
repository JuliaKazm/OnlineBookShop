package dao;
import interfaces.IAuthorsDAO;
import models.Authors;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class AuthorsDAO implements IAuthorsDAO {

    private final static String INSERT = "INSERT INTO Authors(author_id, last_name) VALUES(?, ?)";
    private final static String UPDATE = "UPDATE Authors SET last_name =? WHERE author_id =?";
    private final static String DELETE = "DELETE FROM Authors WHERE author_id = ?";
    private final static String SELECT_ALL = "SELECT * FROM Authors";
    private final static String SELECT_BY_ID = "SELECT * FROM Authors WHERE author_id = ?";

    private Connection connection;

    public AuthorsDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Optional<Authors> getById(int id) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Authors author = new Authors();
                    author.setAuthor_id(resultSet.getInt("author_id"));
                    author.setLast_name(resultSet.getString("last_name"));
                    return Optional.of(author);
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Authors> getAll() throws SQLException {
        List<Authors> authors = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Authors author = new Authors();
                author.setAuthor_id(resultSet.getInt("author_id"));
                author.setLast_name(resultSet.getString("last_name"));
                authors.add(author);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return authors;
    }

    @Override
    public void create(Authors author) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(INSERT)) {
            statement.setInt(1, author.getAuthor_id());
            statement.setString(2, author.getLast_name());
            statement.executeUpdate();
        }
    }

    @Override
    public void update(Authors author) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            statement.setString(1, author.getLast_name());
            statement.setInt(2, author.getAuthor_id());
            statement.executeUpdate();
        }
    }

    @Override
    public void delete(Long id) {
        try (PreparedStatement statement = connection.prepareStatement(DELETE)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(DELETE)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }


}
