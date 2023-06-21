package services;

import dao.OrdersDAO;
import models.Orders;

import java.util.List;

public class OrdersService {
    private OrdersDAO ordersDAO;

    public OrdersService() {
        ordersDAO = new OrdersDAO();
    }

    public void insertOrders(Orders orders) {
        ordersDAO.create(orders);
    }

    public Orders selectOrders(int ordersId) {
        return ordersDAO.findById(ordersId).orElse(null);
    }

    public List<Orders> selectAllOrders() {
        return ordersDAO.findAll();
    }

    public void updateOrders(Orders orders) {
        ordersDAO.update(orders);
    }

    public void deleteOrders(int ordersId) {
        ordersDAO.delete(ordersId);
    }
}
