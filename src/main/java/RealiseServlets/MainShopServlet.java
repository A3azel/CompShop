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
import java.util.stream.Collectors;

@WebServlet("/shop")
public class MainShopServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String[] selectedComponents = req.getParameterValues("v1");

        if (selectedComponents == null){
            DAOFactory daoFactory = DAOFactory.getInstance();
            ArrayList<ComputerComponents> componentsArrayList = daoFactory.getComputerComponentsDAORealize().getAllComputerComponents();
            req.setAttribute("ComponentsList",componentsArrayList);
            req.getServletContext().setAttribute("allComponents",componentsArrayList);
            req.getRequestDispatcher("shopMainWindow.jsp").forward(req,resp);
        }

        if(selectedComponents!=null){
            ArrayList<ComputerComponents> computerComponentsArrayList = (ArrayList<ComputerComponents>) req.getServletContext().getAttribute("allComponents");
            ArrayList<ComputerComponents> sortedList = (ArrayList<ComputerComponents>) computerComponentsArrayList.stream().filter(a -> {
                for(String s: selectedComponents){
                    return a.getComponentCategory().equals(s);
                }
                 return false;
                }
            ).collect(Collectors.toList());

            req.setAttribute("ComponentsList",sortedList);
            req.getRequestDispatcher("shopMainWindow.jsp").forward(req,resp);

        }
    }
}
