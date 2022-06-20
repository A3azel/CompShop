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
import java.util.List;

@WebServlet("/basket")
public class BasketServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("removeFromBasket")!=null){
            DAOFactory daoFactory = DAOFactory.getInstance();
            ComputerComponents removeComp = daoFactory.getComputerComponentsDAORealize().getComputerComponentsByID(Integer.parseInt(req.getParameter("removeFromBasket")));
            List<ComputerComponents> basketCompList = (List<ComputerComponents>) req.getSession().getAttribute("basketCompList");
            basketCompList.remove(removeComp);
            req.getSession().setAttribute("basketCompList",basketCompList);
            resp.sendRedirect("basket.jsp");
            return;
        }
        if(req.getParameter("byThisComp")!=null){
            DAOFactory daoFactory = DAOFactory.getInstance();
            ComputerComponents comp = daoFactory.getComputerComponentsDAORealize().getComputerComponentsByID(Integer.parseInt(req.getParameter("byThisComp")));
            Orders orders = new Orders();
            orders.setUserOrder(((User)req.getSession().getAttribute("user")).getUserName());
            orders.setOrderComp(comp.getComponentName());
            orders.setOrderCount(1);
            orders.setOrderPrise(comp.getComponentPrise());
            daoFactory.getComputerComponentsDAORealize().setCompCount(comp.getComponentID());
            daoFactory.getOrdersDAO().addOrder(orders);
            List<ComputerComponents> basketCompList = (List<ComputerComponents>) req.getSession().getAttribute("basketCompList");
            basketCompList.remove(comp);
            req.getSession().setAttribute("basketCompList",basketCompList);
            resp.sendRedirect("office");
            return;
        }
    }
}
