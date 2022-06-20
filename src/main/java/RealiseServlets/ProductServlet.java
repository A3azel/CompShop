package RealiseServlets;

import CreateObj.ComputerComponents;
import DAO.DAOFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if(req.getParameter("action") == null){
            int productID = Integer.parseInt(req.getParameter("productID"));
            DAOFactory daoFactory = DAOFactory.getInstance();
            ComputerComponents components = daoFactory.getComputerComponentsDAORealize().getComputerComponentsByID(productID);
            req.getServletContext().setAttribute("findProductServletContext", components);
            req.setAttribute("findProduct", components);
            req.getRequestDispatcher("productPage.jsp").forward(req, resp);
        }

        switch (action){
            case "by":
                req.setAttribute("toOrder",req.getServletContext().getAttribute("findProductServletContext"));
                req.getRequestDispatcher("toOrder").forward(req, resp);
                break;
            case "addToBasket":
                ArrayList<ComputerComponents> basketCompList = (ArrayList<ComputerComponents>) req.getSession().getAttribute("basketCompList");
                basketCompList.add((ComputerComponents) req.getServletContext().getAttribute("findProductServletContext"));
                req.getSession().setAttribute("basketCompList",basketCompList);
                req.getRequestDispatcher("personalOfficePage.jsp").forward(req, resp);
                break;
        }

    }

}
