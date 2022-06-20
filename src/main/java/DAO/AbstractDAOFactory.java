package DAO;

import DAO.DAOInterface.ComputerComponentsDAO;
import DAO.DAOInterface.OrdersDAO;
import DAO.DAOInterface.UserDAO;

public abstract class AbstractDAOFactory {
    public abstract UserDAO getUserDAORealize();
    public abstract ComputerComponentsDAO getComputerComponentsDAORealize();
    public abstract OrdersDAO getOrdersDAO();
}
