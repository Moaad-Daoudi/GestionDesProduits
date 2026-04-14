package ma.ensah.web;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.ensah.model.Product;
import ma.ensah.service.ProductService;

@WebServlet("/addProduit")
public class AddProduitServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductService service = (ProductService) getServletContext().getAttribute("productService");
        
        String nom = request.getParameter("nom");
        String desc = request.getParameter("description");
        double prix = Double.parseDouble(request.getParameter("prix"));
        
        service.addProduct(new Product(null, nom, desc, prix));
        response.sendRedirect("listProduits");
    }
}