package mybatis;

import mapper.BooksMapper;
import mapper.CustomersMapper;
import mapper.OrdersMapper;
import models.Books;
import models.Customers;
import models.Orders;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisRunner {
    public static void main(String[] args) throws IOException {
        Logger logger = LogManager.getLogger();

        try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
            SqlSession session = sqlSessionFactory.openSession(true);

            // BooksMapper
            BooksMapper booksMapper = session.getMapper(BooksMapper.class);

            Books books = booksMapper.selectBooksById(5);
            logger.info("Selecting books by id: " + books);

            List<Books> allBooks = booksMapper.selectAllBooks();
            logger.info("Selecting all books: " + allBooks);

            Books newBook = new Books(11,"White flowers", 3, "romance", 6, 5);

            booksMapper.insertBooks(newBook);
            logger.info("Inserted book: " + newBook);

            booksMapper.updateBooks(newBook);
            logger.info("Updated book: " + newBook);

            booksMapper.deleteBooks(newBook.getBook_id());
            logger.info("Deleted book with ID: " + newBook.getBook_id());

            // CustomersMapper
            CustomersMapper customersMapper = session.getMapper(CustomersMapper.class);

            Customers customers = customersMapper.selectCustomersById(3);
            logger.info("Selecting customers by id: " + customers);

            List<Customers> allCustomers = customersMapper.selectAllCustomers();
            logger.info("Selecting all customers: " + allCustomers);

            Customers newCustomer = new Customers(14,"John", "Val", "758 Blue street, Orlando, FL 33987", "john.val@example.com");

            customersMapper.insertCustomers(newCustomer);
            logger.info("Inserted Customer: " + newCustomer);

            customersMapper.updateCustomers(newCustomer);
            logger.info("Updated Customer: " + newCustomer);

            customersMapper.deleteCustomers(newCustomer.getCustomer_id());
            logger.info("Deleted Customer: " + newCustomer.getCustomer_id());

            // OrdersMapper
            OrdersMapper ordersMapper = session.getMapper(OrdersMapper.class);

            Orders orders = ordersMapper.selectOrdersById(9);
            logger.info("Selecting orders by id: " + orders);

            List<Orders> allOrders = ordersMapper.selectAllOrders();
            logger.info("Selecting all orders: " + allOrders);

            Orders newOrders = new Orders(13, 4, "2023-06-21", "shipped");

            ordersMapper.insertOrders(newOrders);
            logger.info("Inserted Order: " + newOrders);

            ordersMapper.updateOrders(newOrders);
            logger.info("Updated Order: " + newOrders);

            ordersMapper.deleteOrders(newOrders.getOrders_id());
            logger.info("Deleted Order: " + newOrders.getOrders_id());

        }
    }
}
