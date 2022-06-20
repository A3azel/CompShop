package DAO.DAOInterface;

import CreateObj.Orders;

import java.util.ArrayList;

public interface OrdersDAO {
    void addOrder(Orders orders);
    ArrayList<Orders> getOrdersFromUser(int id);
    Orders getOrdersByID(int id);
}
