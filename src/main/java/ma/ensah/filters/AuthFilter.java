package ma.ensah.filters;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest; 
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;         
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter("/*")
public class AuthFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
            throws IOException, ServletException {
        
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String uri = req.getRequestURI();

        boolean isIndex = uri.endsWith("/GestionDesProduits/") || uri.endsWith("index.jsp");
        boolean isLoginPage = uri.endsWith("login.jsp");
        boolean isRegisterPage = uri.endsWith("register.jsp");
        boolean isLoginServlet = uri.endsWith("/login");
        boolean isRegisterServlet = uri.endsWith("/register");

        if (isLoginPage || isRegisterPage || isLoginServlet || isRegisterServlet || isIndex) {
            chain.doFilter(request, response);
            return;
        }

        HttpSession session = req.getSession(false);
        
        if (session != null && session.getAttribute("user") != null) {
            chain.doFilter(request, response);
        } else {
            res.sendRedirect("login.jsp");
        }
    }

    public void init(FilterConfig fConfig) throws ServletException {}
    public void destroy() {}
}