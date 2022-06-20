package RealiseServlets;


import DAO.DAOFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("username") != null) {
            resp.sendRedirect("office");
        } else {
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("username") != null) {
            resp.sendRedirect("office");
            return;
        }


        String name = req.getParameter("username");
        String password = req.getParameter("userPassword");
        DAOFactory daoFactory = DAOFactory.getInstance();
        boolean isLogin = daoFactory.getUserDAORealize().findUserByUsernameAndPassword(name,password) != null;
        System.out.println(name);
        System.out.println(password);
        System.out.println(isLogin);


        HashMap<String,String> errorAttribute = new HashMap<>();

        if(!isLogin){
            errorAttribute.put("userErrors","incorrect password or login");
            passToErrorPage(req,resp,errorAttribute);
            return;
        }

        req.getSession().setAttribute("username",name);
        req.getSession().setAttribute("userPassword",password);
        resp.sendRedirect("office");
    }

    public void passToErrorPage(HttpServletRequest req, HttpServletResponse resp, HashMap<String,String> errorAttribute) throws ServletException, IOException {
        for (HashMap.Entry<String, String> ent : errorAttribute.entrySet()){
            req.setAttribute(ent.getKey(), ent.getValue());
            System.out.println(ent.getKey());
        }
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}

