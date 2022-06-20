package DAO;

import DAO.DAOInterface.ComputerComponentsDAO;
import DAO.DAOInterface.OrdersDAO;
import DAO.DAOInterface.UserDAO;
import DAO.DAORealize.ComputerComponentsDAORealize;
import DAO.DAORealize.OrdersDAORealize;
import DAO.DAORealize.UserDAORealize;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOFactory extends AbstractDAOFactory implements DBManager {

    private static DAOFactory instance;
    private static UserDAO userDAO;
    private static ComputerComponentsDAO computerComponentsDAO;
    private static OrdersDAO ordersDAO;

    private DAOFactory(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static final String URL = "jdbc:mysql://localhost:3306/CompShop";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static synchronized DAOFactory getInstance(){
        DAOFactory localInstance = instance;
        if(localInstance == null){
            synchronized (DAOFactory.class){
                localInstance = instance;
                if(localInstance == null)
                    localInstance = new DAOFactory();
            }
        }
        return localInstance;

    }

    @Override
    public UserDAO getUserDAORealize() {
        if(userDAO == null)
            userDAO = new UserDAORealize();
        return userDAO;
    }

    @Override
    public ComputerComponentsDAO getComputerComponentsDAORealize() {
        if(computerComponentsDAO == null)
            computerComponentsDAO = new ComputerComponentsDAORealize();
        return computerComponentsDAO;
    }

    @Override
    public OrdersDAO getOrdersDAO() {
        if(ordersDAO == null)
            ordersDAO = new OrdersDAORealize();
        return ordersDAO;
    }
}
