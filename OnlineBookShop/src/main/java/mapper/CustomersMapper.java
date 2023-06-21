package mapper;
import models.Customers;
import java.util.List;

public interface CustomersMapper {

    Customers selectCustomersById(int id);
    List<Customers> selectAllCustomers();
    void insertCustomers(Customers customers);
    void updateCustomers(Customers customers);
    void deleteCustomers(int id);

}
