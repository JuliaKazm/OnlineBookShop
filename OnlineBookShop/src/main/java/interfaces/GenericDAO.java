package interfaces;

import models.Publishers;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface GenericDAO<T, K> {
    void create(T entity) throws SQLException;
    List<T> getAll() throws SQLException;
    Optional<T> getById(int id) throws SQLException;
    void update(T entity) throws SQLException;
    void delete(int id) throws SQLException;
}

