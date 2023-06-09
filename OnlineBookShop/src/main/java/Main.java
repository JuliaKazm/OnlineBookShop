import dao.BooksDAO;
import models.Books;
import dao.EmployeesDAO;
import models.Employees;
import dao.CustomersDAO;
import models.Customers;
import services.CustomersServiceImpl;
import services.CustomersService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        try (BasicDataSource dataSource = DBConnectionPool.getDataSource()) {
            try (Connection connection = dataSource.getConnection()) {
                BooksDAO booksDAO = new BooksDAO(connection);
                Books book = new Books();
                book.setTitle("The sun is yellow");
                book.setAuthor_id(1);
                book.setGenre("Romance");
                book.setPublishers_publisher_id(1);
                book.setBookStock_book_stock_id(1);
                booksDAO.create(book);
                logger.info("Created book: {}", book);

                Optional<Books> optionalBook = booksDAO.findById(book.getBook_id());
                if (optionalBook.isPresent()) {
                    Books retrievedBook = optionalBook.get();
                    logger.info("Retrieved book: {}", retrievedBook);
                } else {
                    logger.info("Book not found.");
                }

                if (optionalBook.isPresent()) {
                    Books existingBook = optionalBook.get();
                    existingBook.setTitle("New Title");
                    existingBook.setAuthor_id(2);
                    existingBook.setGenre("Science Fiction");
                    booksDAO.update(existingBook);
                    logger.info("Updated book: {}", existingBook);
                }

                List<Books> allBooks = booksDAO.findAll();
                logger.info("All books:");
                for (Books b : allBooks) {
                    logger.info(b);
                }

                if (optionalBook.isPresent()) {
                    Books deleteBook = optionalBook.get();
                    booksDAO.delete(deleteBook.getBook_id());
                    logger.info("Deleted book: {}", deleteBook);
                }
            }

            try (Connection connection = dataSource.getConnection()) {
                EmployeesDAO employeesDAO = new EmployeesDAO(connection);
                Employees newEmployee = new Employees();
                newEmployee.setEmployee_id(12);
                newEmployee.setFirst_name("Arin");
                newEmployee.setLast_name("Bonn");
                newEmployee.setPosition("Manager");
                newEmployee.setDepartments_department_id(1);
                newEmployee.setDate_of_birth("1975");
                employeesDAO.createEmployees(newEmployee);

                List<Employees> employeesList = employeesDAO.getAllEmployees();
                for (Employees employee : employeesList) {
                    logger.info(employee);
                }

                Employees employeeToUpdate = employeesDAO.getEmployeesById(1);
                if (employeeToUpdate != null) {
                    employeeToUpdate.setPosition("Senior Manager");
                    employeesDAO.updateEmployees(employeeToUpdate);
                }

                employeesDAO.deleteEmployees(1);
            }

            try (Connection connection = dataSource.getConnection()) {
                CustomersDAO customersDAO = new CustomersDAO(connection);
                CustomersService customersService = new CustomersServiceImpl(customersDAO);

                Customers customer = new Customers();
                customer.setCustomer_id(14);
                customer.setFirst_name("Olga");
                customer.setLast_name("Robin");
                customer.setAddress("876 Round Ct");
                customer.setContact_details("olga.robin@example.com");
                customersService.createCustomer(customer);
                logger.info("Created customer: {}", customer);

                Optional<Customers> optionalCustomer = customersService.getCustomerById(customer.getCustomer_id());
                if (optionalCustomer.isPresent()) {
                    Customers retrievedCustomer = optionalCustomer.get();
                    logger.info("Retrieved customer: {}", retrievedCustomer);
                } else {
                    logger.info("Customer not found.");
                }

                if (optionalCustomer.isPresent()) {
                    Customers existingCustomer = optionalCustomer.get();
                    existingCustomer.setFirst_name("Jane");
                    existingCustomer.setLast_name("Smith");
                    existingCustomer.setAddress("456 Oak St");
                    existingCustomer.setContact_details("jane.smith@example.com");
                    customersService.updateCustomer(existingCustomer);
                    logger.info("Updated customer: {}", existingCustomer);
                }

                List<Customers> allCustomers = customersService.getAllCustomers();
                logger.info("All customers:");
                for (Customers c : allCustomers) {
                    logger.info(c);
                }

                if (optionalCustomer.isPresent()) {
                    Customers deleteCustomer = optionalCustomer.get();
                    customersService.deleteCustomer(deleteCustomer.getCustomer_id());
                    logger.info("Deleted customer: {}", deleteCustomer);
                }
            }
        } catch (SQLException e) {
            logger.error("Error occurred while executing JDBC operations: {}", e.getMessage());
        }
    }
}




/*
public class Main {
    public static void main(String[] args) {
        BasicDataSource dataSource = DBConnectionPool.getDataSource();

        try (Connection connection = dataSource.getConnection()) {
            BooksDAO booksDAO = new BooksDAO(connection);

            // Create a new book
            Books book = new Books();
            book.setTitle("The sun is yellow");
            book.setAuthor_id(1);
            book.setGenre("Romance");
            book.setPublishers_publisher_id(1);
            book.setBookStock_book_stock_id(1);
            booksDAO.create(book);
            System.out.println("Created book: " + book);

            // Get a book by ID
            Optional<Books> optionalBook = booksDAO.findById(book.getBook_id());
            if (optionalBook.isPresent()) {
                Books retrievedBook = optionalBook.get();
                System.out.println("Retrieved book: " + retrievedBook);
            } else {
                System.out.println("Book not found.");
            }

            // Update the book
            if (optionalBook.isPresent()) {
                Books existingBook = optionalBook.get();
                existingBook.setTitle("New Title");
                existingBook.setAuthor_id(2);
                existingBook.setGenre("Science Fiction");
                booksDAO.update(existingBook);
                System.out.println("Updated book: " + existingBook);
            }

            // Get all books
            List<Books> allBooks = booksDAO.findAll();
            System.out.println("All books:");
            for (Books b : allBooks) {
                System.out.println(b);
            }

            // Delete the book
            if (optionalBook.isPresent()) {
                Books deleteBook = optionalBook.get();
                booksDAO.delete(deleteBook.getBook_id());
                System.out.println("Deleted book: " + deleteBook);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (Connection connection = dataSource.getConnection()) {
            EmployeesDAO employeesDAO = new EmployeesDAO(connection);

            // Create a new employee
            Employees newEmployee = new Employees();
            newEmployee.setEmployee_id(23);
            newEmployee.setFirst_name("Arin");
            newEmployee.setLast_name("Bonn");
            newEmployee.setPosition("Manager");
            newEmployee.setDepartments_department_id(1);
            newEmployee.setDate_of_birth("1975");

            // Insert the new employee into the database
            employeesDAO.createEmployees(newEmployee);

            // Retrieve all employees from the database
            List<Employees> employeesList = employeesDAO.getAllEmployees();
            for (Employees employee : employeesList) {
                System.out.println(employee);
            }

            // Update an employee's position
            Employees employeeToUpdate = employeesDAO.getEmployeesById(1);
            if (employeeToUpdate != null) {
                employeeToUpdate.setPosition("Senior Manager");
                employeesDAO.updateEmployees(employeeToUpdate);
            }

            // Delete an employee
            employeesDAO.deleteEmployees(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (Connection connection = dataSource.getConnection()) {
            CustomersDAO customersDAO = new CustomersDAO(connection);
            CustomersService customersService = new CustomersServiceImpl(customersDAO);

            // Create a new customer
            Customers customer = new Customers();
            customer.setCustomer_id(14);
            customer.setFirst_name("Olga");
            customer.setLast_name("Robin");
            customer.setAddress("876 Round Ct");
            customer.setContact_details("olga.robin@example.com");
            customersService.createCustomer(customer);
            System.out.println("Created customer: " + customer);

            // Get a customer by ID
            Optional<Customers> optionalCustomer = customersService.getCustomerById(customer.getCustomer_id());
            if (optionalCustomer.isPresent()) {
                Customers retrievedCustomer = optionalCustomer.get();
                System.out.println("Retrieved customer: " + retrievedCustomer);
            } else {
                System.out.println("Customer not found.");
            }

            // Update the customer
            if (optionalCustomer.isPresent()) {
                Customers existingCustomer = optionalCustomer.get();
                existingCustomer.setFirst_name("Jane");
                existingCustomer.setLast_name("Smith");
                existingCustomer.setAddress("456 Oak St");
                existingCustomer.setContact_details("jane.smith@example.com");
                customersService.updateCustomer(existingCustomer);
                System.out.println("Updated customer: " + existingCustomer);
            }

            // Get all customers
            List<Customers> allCustomers = customersService.getAllCustomers();
            System.out.println("All customers:");
            for (Customers c : allCustomers) {
                System.out.println(c);
            }

            // Delete the customer
            if (optionalCustomer.isPresent()) {
                Customers deleteCustomer = optionalCustomer.get();
                customersService.deleteCustomer(deleteCustomer.getCustomer_id());
                System.out.println("Deleted customer: " + deleteCustomer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
*/