package DAO.DAORealize;

import CreateObj.Orders;
import DAO.DAOFactory;
import DAO.DAOInterface.OrdersDAO;
import HelpDAO.DAOHelper;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

public class OrdersDAORealize implements OrdersDAO {
    public static final String ADD_ORDER = "INSERT INTO Orders(user_orders_ID,computer_components_orders_ID,order_status_ID" +
            ",order_count,order_create_time,order_prise) VALUE((SELECT ID FROM USERData WHERE user_name = ?)," +
            "(SELECT ID FROM ComputerComponents WHERE computer_components_name = ?)," +
            "(SELECT ID FROM OrderStatus WHERE order_status = ?),?,?,?)";

    public static final String GET_ORDERS_FROM_USER = "SELECT Orders.ID,user_name,computer_components_name,order_status,order_count,order_create_time,order_prise FROM Orders LEFT outer JOIN USERData on USERData.ID = user_orders_ID\n" +
            "            LEFT outer JOIN ComputerComponents on ComputerComponents.ID = computer_components_orders_ID\n" +
            "            LEFT outer JOIN OrderStatus on OrderStatus.ID = order_status_ID where USERData.ID = ?";


    public static final String GET_ORDERS_BY_ID = "SELECT Orders.ID,user_name,computer_components_name,order_status,order_count,order_create_time,order_prise FROM Orders LEFT outer JOIN USERData on USERData.ID = user_orders_ID\n" +
            "            LEFT outer JOIN ComputerComponents on ComputerComponents.ID = computer_components_orders_ID\n" +
            "            LEFT outer JOIN OrderStatus on OrderStatus.ID = order_status_ID where Orders.ID = ?";

    public static final String ORDER_ID = "ID";
    public static final String USER_NAME = "user_name";
    public static final String COMP_NAME = "computer_components_name";
    public static final String ORDER_STATUS = "order_status";
    public static final String ORDER_COUNT = "order_count";
    public static final String ORDER_TIME = "order_create_time";
    public static final String ORDER_PRISE = "order_prise";

    @Override
    public void addOrder(Orders orders){
        Connection con = DAOFactory.getInstance().getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = con.prepareStatement(ADD_ORDER);
            int k = 0;
            preparedStatement.setString(++k,orders.getUserOrder());
            preparedStatement.setString(++k,orders.getOrderComp());
            preparedStatement.setString(++k,"processed");
            preparedStatement.setInt(++k,orders.getOrderCount());
            preparedStatement.setDate(++k, new Date(Calendar.getInstance().getTimeInMillis()));
            preparedStatement.setBigDecimal(++k,orders.getOrderPrise());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DAOHelper.closeCon(preparedStatement);
            DAOHelper.closeCon(con);
        }
    }

    @Override
    public ArrayList<Orders> getOrdersFromUser(int id){
        Connection con = DAOFactory.getInstance().getConnection();
        PreparedStatement preparedStatement = null;
        ArrayList<Orders> ordersArrayList = new ArrayList<>();
        try {
            preparedStatement = con.prepareStatement(GET_ORDERS_FROM_USER);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Orders orders = helpToAdd(resultSet);
                ordersArrayList.add(orders);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DAOHelper.closeCon(preparedStatement);
            DAOHelper.closeCon(con);
        }
        return ordersArrayList;
    }

    @Override
    public Orders getOrdersByID(int id){
        Connection con = DAOFactory.getInstance().getConnection();
        PreparedStatement preparedStatement = null;
        Orders orders = new Orders();
        try {
            preparedStatement = con.prepareStatement(GET_ORDERS_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){

                orders = helpToAdd(resultSet);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DAOHelper.closeCon(preparedStatement);
            DAOHelper.closeCon(con);
        }
        return orders;
    }

    public Orders helpToAdd(ResultSet rs) throws SQLException {
        Orders orders = new Orders();
        int orderID = rs.getInt(ORDER_ID);
        String userName = rs.getString(USER_NAME);
        String computerComponentsName = rs.getString(COMP_NAME);
        String orderStatus = rs.getString(ORDER_STATUS);
        int orderCount = rs.getInt(ORDER_COUNT);
        Date orderTime = rs.getDate(ORDER_TIME);
        BigDecimal orderPrise = rs.getBigDecimal(ORDER_PRISE);
        orders.setID(orderID);
        orders.setUserOrder(userName);
        orders.setOrderComp(computerComponentsName);
        orders.setOrderStatus(orderStatus);
        orders.setOrderCount(orderCount);
        orders.setOrderCreateTime(orderTime);
        orders.setOrderPrise(orderPrise);
        return orders;
    }
}
