package dao;
import models.Publishers;
import interfaces.IPublishersDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PublishersDAO implements IPublishersDAO {

    private static final String INSERT = "INSERT INTO Publishers (publisher_id, name, phone_number) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE Publishers SET name = ?, phone_number = ? WHERE publisher_id = ?";
    private static final String DELETE = "DELETE FROM Publishers WHERE publisher_id = ?";
    private static final String SELECT_ALL = "SELECT * FROM Publishers";
    private static final String SELECT_BY_ID = "SELECT * FROM Publishers WHERE publisher_id = ?";

    private Connection connection;

    public PublishersDAO(Connection connection) {this.connection = connection;
    }

    public void create(Publishers publisher) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(INSERT)) {
            statement.setInt(1, publisher.getPublisher_id());
            statement.setString(2, publisher.getName());
            statement.setString(3, publisher.getPhone_number());
            statement.executeUpdate();
        }
    }

    public void update(Publishers publisher) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            statement.setString(1, publisher.getName());
            statement.setString(2, publisher.getPhone_number());
            statement.setInt(3, publisher.getPublisher_id());
            statement.executeUpdate();
        }
    }

    public void delete(int publisherId) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(DELETE)) {
            statement.setInt(1, publisherId);
            statement.executeUpdate();
        }
    }

    public List<Publishers> getAll() throws SQLException {
        List<Publishers> publishers = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Publishers publisher = new Publishers();
                publisher.setPublisher_id(resultSet.getInt("publisher_id"));
                publisher.setName(resultSet.getString("name"));
                publisher.setPhone_number(resultSet.getString("phone_number"));
                publishers.add(publisher);
            }
        }
        return publishers;
    }

    public Optional<Publishers> getById(int publisherId) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)) {
            statement.setInt(1, publisherId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Publishers publisher = new Publishers();
                    publisher.setPublisher_id(resultSet.getInt("publisher_id"));
                    publisher.setName(resultSet.getString("name"));
                    publisher.setPhone_number(resultSet.getString("phone_number"));
                    return Optional.of(publisher);
                }
            }
        }
        return Optional.empty();
    }
}
