package ma.ensah.web;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.ensah.service.ProductService;

@WebServlet("/editProduit")
public class EditProduitServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductService service = (ProductService) getServletContext().getAttribute("productService");
        Long id = Long.parseLong(request.getParameter("id"));
        
        request.setAttribute("productEdit", service.getProduct(id));
        request.setAttribute("listeProduits", service.getAllProducts());
        request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
    }
}