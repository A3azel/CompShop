package RealiseServlets;

import CreateObj.User;
import DAO.DAOFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/changePass")
public class ChangePasswordServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String oldPassword = req.getParameter("oldPassword");
        String newPassword = req.getParameter("newPassword");
        DAOFactory daoFactory = DAOFactory.getInstance();
        String username =  ((User) req.getSession().getAttribute("user")).getUserName();
        System.out.println(username);
        boolean isLogin = daoFactory.getUserDAORealize().findInDB(username,oldPassword);
        if (isLogin && !oldPassword.equals(newPassword)){
            daoFactory.getUserDAORealize().updatePassword(newPassword,((User) req.getSession().getAttribute("user")).getUserID());
        }
    }
}
