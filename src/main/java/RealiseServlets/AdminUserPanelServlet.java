package RealiseServlets;


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

@WebServlet("/adminPanelUsersInfo")
public class AdminUserPanelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!Objects.equals(((User) req.getSession().getAttribute("user")).getUserStatus(), "admin")) {
            resp.sendRedirect("office");
            return;
        }

        if(req.getParameter("userByName") != null){
            DAOFactory daoFactory = DAOFactory.getInstance();
            User user = daoFactory.getUserDAORealize().getUser(req.getParameter("userByName"));
            req.setAttribute("userInfo",user);
            req.getRequestDispatcher("userInfoForAdmin.jsp").forward(req,resp);
            return;
        }

        DAOFactory daoFactory = DAOFactory.getInstance();
        ArrayList<User> userList = daoFactory.getUserDAORealize().getAllUsers();
        req.setAttribute("allUsers",userList);
        req.getRequestDispatcher("userInfo.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!Objects.equals(((User) req.getSession().getAttribute("user")).getUserStatus(), "admin")) {
            resp.sendRedirect("office");
            return;
        }
        if(req.getParameter("userIDPost") != null){
            DAOFactory daoFactory = DAOFactory.getInstance();
            daoFactory.getUserDAORealize().dellUser(Integer.parseInt(req.getParameter("userIDPost")));
            resp.sendRedirect("adminPanelUsersInfo");
            return;
        }

        if(req.getParameter("upgradeUser")!= null){
            DAOFactory daoFactory = DAOFactory.getInstance();
            daoFactory.getUserDAORealize().makeAnAdministrator(Integer.parseInt(req.getParameter("upgradeUser")));
            resp.sendRedirect("adminPanelUsersInfo");
        }

    }
}
