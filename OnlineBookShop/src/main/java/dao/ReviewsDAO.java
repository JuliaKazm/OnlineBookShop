package dao;
import interfaces.IReviewsDAO;
import models.Reviews;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReviewsDAO implements IReviewsDAO {
    private static final String INSERT = "INSERT INTO Reviews (book_id, customer_id, rating, comments) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE Reviews SET book_id = ?, customer_id = ?, rating = ?, comments = ? WHERE review_id = ?";
    private static final String DELETE = "DELETE FROM Reviews WHERE review_id = ?";
    private static final String SELECT_ALL = "SELECT * FROM Reviews";
    private static final String SELECT_BY_ID = "SELECT * FROM Reviews WHERE review_id = ?";

    private Connection connection;

    public ReviewsDAO(Connection connection) {
        this.connection = connection;
    }

    public void create(Reviews review) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(INSERT)) {
            statement.setInt(1, review.getBook_id());
            statement.setInt(2, review.getCustomer_id());
            statement.setInt(3, review.getRating());
            statement.setString(4, review.getComments());
            statement.executeUpdate();
        }
    }

    public void update(Reviews review) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            statement.setInt(1, review.getBook_id());
            statement.setInt(2, review.getCustomer_id());
            statement.setInt(3, review.getRating());
            statement.setString(4, review.getComments());
            statement.setInt(5, review.getReview_id());
            statement.executeUpdate();
        }
    }

    public void delete(int reviewId) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(DELETE)) {
            statement.setInt(1, reviewId);
            statement.executeUpdate();
        }
    }

    public List<Reviews> getAll() throws SQLException {
        List<Reviews> reviews = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Reviews review = new Reviews();
                review.setReview_id(resultSet.getInt("review_id"));
                review.setBook_id(resultSet.getInt("book_id"));
                review.setCustomer_id(resultSet.getInt("customer_id"));
                review.setRating(resultSet.getInt("rating"));
                review.setComments(resultSet.getString("comments"));
                reviews.add(review);
            }
        }
        return reviews;
    }

    public Optional<Reviews> getById(int reviewId) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)) {
            statement.setInt(1, reviewId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Reviews review = new Reviews();
                    review.setReview_id(resultSet.getInt("review_id"));
                    review.setBook_id(resultSet.getInt("book_id"));
                    review.setCustomer_id(resultSet.getInt("customer_id"));
                    review.setRating(resultSet.getInt("rating"));
                    review.setComments(resultSet.getString("comments"));
                    return Optional.of(review);
                }
            }
        }
        return Optional.empty();
    }

}
