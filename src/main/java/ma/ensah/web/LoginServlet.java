package ma.ensah.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ma.ensah.service.UserService;
import ma.ensah.model.User;

import java.io.IOException;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		if(email.isEmpty() || password.isEmpty()) {
			request.setAttribute("error", "Ooops, erreur !!! Vous devez remplir tous les champs");
			request.getRequestDispatcher("/login.jsp").forward(request,response);
		} else {
			UserService metier = (UserService) getServletContext().getAttribute("userService");
			User user = metier.authenticate(email, password);
			if (user != null) {
	            HttpSession session = request.getSession();
	            session.setAttribute("user", user);
	            response.sendRedirect("dashboard.jsp");
	        } else {
	            request.setAttribute("error", "Email ou mot de passe incorrect");
	            request.getRequestDispatcher("/login.jsp").forward(request, response);
	        }
		}	
	}
}
