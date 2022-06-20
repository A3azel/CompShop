package RealiseServlets;


import CreateObj.Orders;
import DAO.DAOFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/selectedOrder")
public class SelectedOrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("action"));
        DAOFactory daoFactory = DAOFactory.getInstance();
        Orders myOrder = daoFactory.getOrdersDAO().getOrdersByID(id);
        req.setAttribute("selectedOrders",myOrder);
        req.getRequestDispatcher("userSelectedOrderPage.jsp").forward(req,resp);

    }
}
