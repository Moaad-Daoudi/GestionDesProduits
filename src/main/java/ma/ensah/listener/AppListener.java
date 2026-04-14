package ma.ensah.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import ma.ensah.service.ProductService;
import ma.ensah.service.ProductServiceImpl;
import ma.ensah.service.UserService;

@WebListener
public class AppListener implements ServletContextListener {
	@Override
    public void contextInitialized(ServletContextEvent sce) {
        UserService metier = new UserService();
        sce.getServletContext().setAttribute("userService", metier);
        
        ProductService productService = new ProductServiceImpl();
        sce.getServletContext().setAttribute("productService", productService);
    }
	
	@Override
    public void contextDestroyed(ServletContextEvent sce) {}
}
