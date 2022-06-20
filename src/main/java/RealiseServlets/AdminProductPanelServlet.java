package RealiseServlets;


import CreateObj.ComputerComponents;
import CreateObj.User;
import DAO.DAOFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

@WebServlet("/adminPanelProductInfo")
public class AdminProductPanelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!Objects.equals(((User) req.getSession().getAttribute("user")).getUserStatus(), "admin")) {
            resp.sendRedirect("office");
            return;
        }
        if(req.getParameter("Update product") != null){
            DAOFactory daoFactory = DAOFactory.getInstance();
            ComputerComponents components = daoFactory.getComputerComponentsDAORealize().getComputerComponentsByID(Integer.parseInt(req.getParameter("Update product")));
            req.setAttribute("productInfo",components);
            req.getRequestDispatcher("productInfoForAdmin.jsp").forward(req,resp);


        }

        DAOFactory daoFactory = DAOFactory.getInstance();
        ArrayList<ComputerComponents> componentsArrayList = daoFactory.getComputerComponentsDAORealize().getAllComputerComponents();
        req.setAttribute("allCompComponents",componentsArrayList);
        System.out.println(componentsArrayList);
        req.getRequestDispatcher("productInfo.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!Objects.equals(((User) req.getSession().getAttribute("user")).getUserStatus(), "admin")) {
            resp.sendRedirect("office");
            return;
        }
        if(req.getParameter("Delete product") != null){
            DAOFactory daoFactory = DAOFactory.getInstance();
            daoFactory.getComputerComponentsDAORealize().deleteCompComponentByID(Integer.parseInt(req.getParameter("Delete product")));
            resp.sendRedirect("adminPanelProductInfo");
            return;
        }
        if(req.getParameter("Update product") != null){
            ComputerComponents components = new ComputerComponents();
            components.setComponentName(req.getParameter("compModel"));
            components.setComponentCategory(req.getParameter("category"));
            components.setComponentDescription(req.getParameter("compDescription"));
            components.setComponentCount(Integer.parseInt(req.getParameter("compCount")));
            components.setComponentPhotoURL(req.getParameter("compPhoto"));
            DAOFactory daoFactory = DAOFactory.getInstance();
            daoFactory.getComputerComponentsDAORealize().setCompComponent(components,Integer.parseInt(req.getParameter("Update product")));
        }
    }
}
