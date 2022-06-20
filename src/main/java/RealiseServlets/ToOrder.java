package RealiseServlets;

import CreateObj.ComputerComponents;
import CreateObj.Orders;
import CreateObj.User;
import DAO.DAOFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/toOrder")
public class ToOrder extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().setAttribute("comp",(ComputerComponents)req.getAttribute("toOrder"));
        req.getRequestDispatcher("checkoutPage.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Orders orders = new Orders();
        orders.setUserOrder(((User)req.getSession().getAttribute("user")).getUserName());
        orders.setOrderComp(((ComputerComponents)req.getServletContext().getAttribute("comp")).getComponentName());
        orders.setOrderCount(1);
        orders.setOrderPrise(((ComputerComponents)req.getServletContext().getAttribute("comp")).getComponentPrise());
        DAOFactory daoFactory = DAOFactory.getInstance();
        daoFactory.getOrdersDAO().addOrder(orders);
        daoFactory.getComputerComponentsDAORealize().setCompCount(((ComputerComponents)req.getServletContext().getAttribute("comp")).getComponentID());
        resp.sendRedirect("office");
    }
}
