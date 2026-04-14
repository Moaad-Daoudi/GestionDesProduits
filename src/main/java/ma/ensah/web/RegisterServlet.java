package ma.ensah.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.ensah.model.User;
import ma.ensah.service.UserService;

import java.io.IOException;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		
		if(nom.isEmpty() || prenom.isEmpty() || password.isEmpty() || email.isEmpty()) {
			request.setAttribute("error", "Ooops, erreur !!! Vous devez remplir tous les champs");
			request.getRequestDispatcher("/register.jsp").forward(request,response);
		} else {
			User newUser = new User(nom,prenom,email,password,role);
			UserService metier = (UserService) getServletContext().getAttribute("userService");
			metier.register(newUser);
			response.sendRedirect("login.jsp");
		}
	}

}
