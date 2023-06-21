package mapper;
import models.Orders;
import java.util.List;

    public interface OrdersMapper {

        Orders selectOrdersById(int id);
        List<Orders> selectAllOrders();
        void insertOrders(Orders orders);
        void updateOrders(Orders orders);
        void deleteOrders(int id);

    }

