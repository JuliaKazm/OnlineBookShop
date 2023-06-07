package dao;
import interfaces.IDepartmentsDAO;
import models.Departments;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DepartmentsDAO implements IDepartmentsDAO {
    private static final String INSERT = "INSERT INTO Departments(department_id, department_name, bookStock_book_stock_id) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE Departments SET department_name = ?, bookStock_book_stock_id = ? WHERE department_id = ?";
    private static final String DELETE = "DELETE FROM Departments WHERE department_id = ?";
    private static final String SELECT_ALL = "SELECT * FROM Departments";
    private static final String SELECT_BY_ID = "SELECT * FROM Departments WHERE department_id = ?";

    private Connection connection;

    public DepartmentsDAO(Connection connection) {
        this.connection = connection;
    }

    public Optional<Departments> findById(int departmentId) {
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)) {
            statement.setInt(1, departmentId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Departments department = new Departments();
                department.setDepartment_id(resultSet.getInt("department_id"));
                department.setDepartment_name(resultSet.getString("department_name"));
                department.setBookStock_book_stock_id(resultSet.getInt("bookStock_book_stock_id"));
                return Optional.of(department);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public List<Departments> findAll() {
        List<Departments> departments = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Departments department = new Departments();
                department.setDepartment_id(resultSet.getInt("department_id"));
                department.setDepartment_name(resultSet.getString("department_name"));
                department.setBookStock_book_stock_id(resultSet.getInt("bookStock_book_stock_id"));
                departments.add(department);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departments;
    }

    public void create(Departments department) {
        try (PreparedStatement statement = connection.prepareStatement(INSERT)) {
            statement.setInt(1, department.getDepartment_id());
            statement.setString(2, department.getDepartment_name());
            statement.setInt(3, department.getBookStock_book_stock_id());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Departments> getAll() throws SQLException {
        List<Departments> departments = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Departments department = new Departments();
                department.setDepartment_id(resultSet.getInt("department_id"));
                department.setDepartment_name(resultSet.getString("department_name"));
                department.setBookStock_book_stock_id(resultSet.getInt("bookStock_book_stock_id"));
                departments.add(department);
            }
        }
        return departments;
    }

    @Override
    public Optional<Departments> getById(int id) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Departments department = new Departments();
                    department.setDepartment_id(resultSet.getInt("department_id"));
                    department.setDepartment_name(resultSet.getString("department_name"));
                    department.setBookStock_book_stock_id(resultSet.getInt("bookStock_book_stock_id"));
                    return Optional.of(department);
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public void update(Departments department) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            statement.setString(1, department.getDepartment_name());
            statement.setInt(2, department.getBookStock_book_stock_id());
            statement.setInt(3, department.getDepartment_id());
            statement.executeUpdate();
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
