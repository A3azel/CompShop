package RealiseServlets;

import CreateObj.Orders;
import CreateObj.User;
import DAO.DAOFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/userOrders")
public class UserOrders extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        User user = (User) req.getSession().getAttribute("user");
        System.out.println(user.getUserID());
        ArrayList<Orders> userOrdersList = daoFactory.getOrdersDAO().getOrdersFromUser(user.getUserID());
        req.setAttribute("userOrders",userOrdersList);
        req.getRequestDispatcher("UserOrdersPage.jsp").forward(req,resp);
    }
}
