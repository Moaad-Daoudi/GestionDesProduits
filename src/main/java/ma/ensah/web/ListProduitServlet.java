package ma.ensah.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.ensah.model.Product;
import ma.ensah.service.ProductService;

@WebServlet("/listProduits")
public class ListProduitServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductService service = (ProductService) getServletContext().getAttribute("productService");
        
        String idParam = request.getParameter("idProduit");
        List<Product> produits = new ArrayList<>();

        if (idParam != null && !idParam.isEmpty()) {
            try {
                Long id = Long.parseLong(idParam);
                Product p = service.getProduct(id);
                if (p != null) {
                    produits.add(p); // On ajoute seulement le produit trouvé
                } else {
                    request.setAttribute("error", "Produit introuvable avec l'ID : " + id);
                    produits = service.getAllProducts(); // Optionnel : on affiche tout si non trouvé
                }
            } catch (NumberFormatException e) {
                request.setAttribute("error", "Format d'ID invalide");
                produits = service.getAllProducts();
            }
        } else {
            // Aucun paramètre : on affiche tout
            produits = service.getAllProducts();
        }

        request.setAttribute("listeProduits", produits);
        request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
    }
}