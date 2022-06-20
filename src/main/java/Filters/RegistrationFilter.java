package Filters;


import SiteSeqretu.WebSecurity;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.HashMap;

@WebFilter("/registration")
public class RegistrationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("LogFilter init!");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        String name = servletRequest.getParameter("username");
        String password = servletRequest.getParameter("userPassword");
        String secondPassword = servletRequest.getParameter("userPasswordSubmit");
        String userEmail = servletRequest.getParameter("userEmail");
        String userPhone = servletRequest.getParameter("userPhone");
        String userSex = servletRequest.getParameter("sex");

        HashMap<String,String> errorAttribute = new HashMap<>();

        if (!WebSecurity.isLoginValid(name)){
            errorAttribute.put("LoginErrors","LoginIsNotValid");
        }
        if(!WebSecurity.isPasswordValid(secondPassword)){
            errorAttribute.put("PasswordErrors","PasswordIsNotValid");
        }
        if(!password.equals(secondPassword)){
            errorAttribute.put("DifferentPasswords","DifferentPasswords");
        }
        if(!WebSecurity.isEmailValid(userEmail)){
            errorAttribute.put("EmailErrors","EmailIsNotValid");
        }
        if(!WebSecurity.isPhoneValid(userPhone)){
            errorAttribute.put("PhoneErrors","PhoneIsNotValid");
        }

        System.out.println(errorAttribute.isEmpty());

        if (!errorAttribute.isEmpty()){
            passToErrorPage(servletRequest,servletResponse,errorAttribute);
            return;
        }

        filterChain.doFilter(servletRequest,servletResponse);


    }

    public void passToErrorPage(ServletRequest servletRequest, ServletResponse servletResponse, HashMap<String,String> errorAttribute) throws ServletException, IOException {
        for (HashMap.Entry<String, String> ent : errorAttribute.entrySet()){
            servletRequest.setAttribute(ent.getKey(), ent.getValue());
        }

        servletRequest.getRequestDispatcher("RegistrationPage.jsp").forward(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("LogFilter destroy!");
    }
}
