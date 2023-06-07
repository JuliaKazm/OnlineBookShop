package dao;

import interfaces.IEmployeesDAO;
import models.Employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeesDAO implements IEmployeesDAO {
    private Connection connection;

    public EmployeesDAO(Connection connection) {
        this.connection = connection;
    }

    public void createEmployees(Employees employees) throws SQLException {
        String query = "INSERT INTO Employees (employee_id, first_name, last_name, position, Departments_department_id, date_of_birth) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, employees.getEmployee_id());
            statement.setString(2, employees.getFirst_name());
            statement.setString(3, employees.getLast_name());
            statement.setString(4, employees.getPosition());
            statement.setInt(5, employees.getDepartments_department_id());
            statement.setObject(6, employees.getDate_of_birth());
            statement.executeUpdate();
        }
    }

    public Employees getEmployeesById(int employeeId) throws SQLException {
        String query = "SELECT * FROM Employees WHERE employee_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, employeeId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Employees employees = new Employees();
                    employees.setEmployee_id(resultSet.getInt("employee_id"));
                    employees.setFirst_name(resultSet.getString("first_name"));
                    employees.setLast_name(resultSet.getString("last_name"));
                    employees.setPosition(resultSet.getString("position"));
                    employees.setDepartments_department_id(resultSet.getInt("Departments_department_id"));
                    employees.setDate_of_birth(String.valueOf(resultSet.getInt("date_of_birth")));
                    return employees;
                }
            }
        }
        return null;
    }

    public List<Employees> getAllEmployees() throws SQLException {
        String query = "SELECT * FROM Employees";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            List<Employees> employeesList = new ArrayList<>();
            while (resultSet.next()) {
                Employees employees = new Employees();
                employees.setEmployee_id(resultSet.getInt("employee_id"));
                employees.setFirst_name(resultSet.getString("first_name"));
                employees.setLast_name(resultSet.getString("last_name"));
                employees.setPosition(resultSet.getString("position"));
                employees.setDepartments_department_id(resultSet.getInt("Departments_department_id"));
                employees.setDate_of_birth(String.valueOf(resultSet.getInt("date_of_birth")));
                employeesList.add(employees);
            }
            return employeesList;
        }
    }

    public void updateEmployees(Employees employees) throws SQLException {
        String query = "UPDATE Employees SET first_name = ?, last_name = ?, position = ?, " +
                "Departments_department_id = ?, date_of_birth = ? WHERE employee_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, employees.getFirst_name());
            statement.setString(2, employees.getLast_name());
            statement.setString(3, employees.getPosition());
            statement.setInt(4, employees.getDepartments_department_id());
            statement.setObject(5, employees.getDate_of_birth());
            statement.setInt(6, employees.getEmployee_id());
            statement.executeUpdate();
        }
    }

    public void deleteEmployees(int employeeId) throws SQLException {
        String query = "DELETE FROM Employees WHERE employee_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, employeeId);
            statement.executeUpdate();
        }
    }

    @Override
    public void create(Employees entity) throws SQLException {
        createEmployees(entity);
    }

    @Override
    public List<Employees> getAll() throws SQLException {
        return getAllEmployees();
    }

    @Override
    public Optional<Employees> getById(int id) throws SQLException {
        Employees employees = getEmployeesById(id);
        return Optional.ofNullable(employees);
    }

    @Override
    public void update(Employees entity) throws SQLException {
        updateEmployees(entity);
    }

    @Override
    public void delete(int id) throws SQLException {
        deleteEmployees(id);
    }
}
