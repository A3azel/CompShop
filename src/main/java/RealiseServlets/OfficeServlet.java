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
import java.util.List;

@WebServlet("/office")
public class OfficeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if(req.getParameter("action") == null){
            Object userName = req.getSession().getAttribute("username");
            DAOFactory daoFactory = DAOFactory.getInstance();
            User user = daoFactory.getUserDAORealize().getUser(String.valueOf(userName));
            if(req.getSession().getAttribute("user") == null){
                req.getSession().setAttribute("user",user);
            }
            if(req.getSession().getAttribute("basketCompList") == null){
                List<ComputerComponents> basketCompList = new ArrayList<>();
                req.getSession().setAttribute("basketCompList",basketCompList);
            }
            req.getRequestDispatcher("personalOfficePage.jsp").forward(req,resp);
        }
        switch (action){
            case "exit":
                req.getSession().invalidate();
                req.getRequestDispatcher("/login").forward(req,resp);
                break;
            case "changPassword":
                req.getRequestDispatcher("changePassPage.jsp").forward(req,resp);
                break;
            case "myOrders":
                 req.getRequestDispatcher("/userOrders").forward(req,resp);
                break;
        }
    }
}
