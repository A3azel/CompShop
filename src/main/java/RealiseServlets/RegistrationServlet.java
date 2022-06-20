package RealiseServlets;

import DAO.DAOFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("username");
        String password = req.getParameter("userPassword");
        String secondPassword = req.getParameter("userPasswordSubmit");
        String userEmail = req.getParameter("userEmail");
        String userPhone = req.getParameter("userPhone");
        String userSex = req.getParameter("sex");

        DAOFactory daoFactory = DAOFactory.getInstance();
        daoFactory.getUserDAORealize().AddUser(name,password,userEmail,userPhone,userSex);
        RequestDispatcher rq = req.getRequestDispatcher("index.jsp");
        rq.forward(req,resp);
    }

    public void passToErrorPage(HttpServletRequest req, HttpServletResponse resp, HashMap<String,String> errorAttribute) throws ServletException, IOException {
        for (HashMap.Entry<String, String> ent : errorAttribute.entrySet()){
            req.setAttribute(ent.getKey(), ent.getValue());
        }

        req.getRequestDispatcher("RegistrationPage.jsp").forward(req, resp);
    }
}
