/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.products;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.dao.BrandDAO;
import model.dao.CategoryDAO;
import model.dao.ProductDAO;
import model.database.DatabaseConnector;
import model.entity.Brand;
import model.entity.Category;
import model.entity.Product;


/**
 *
 * @author PC
 */
public class ProductServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProductServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          try {
              Connection connection = DatabaseConnector.getConnection();
            String action = request.getParameter("command");
            CategoryDAO categoryDAO = new CategoryDAO(connection);
            // Retrieve the list of categories
            List<Category> categoryList = categoryDAO.getAllCategories();
            // Set the categoryList as an attribute in the request
            request.setAttribute("categoryList", categoryList);
            if (action == null) {
                action = "";
            }
            
            switch (action) {
                case "list": showListtoUpdate(request, response); break;
                
                case "home" :  showList(request, response);break;
              
                case "load" : load(request, response);break;
                
                case "loadtoUpdate": loadtoUpdate(request, response); break;
                
                case "add" : addProduct(request, response);break;
                
                case "addForm": showAddProductForm(request, response);break;
                
                case "updateForm": showUpdateProductForm(request, response);break;
                
                case"delete": deleteProduct(request, response); break;
                
                case "update": updateProduct(request, response); break;
                
                case "search": searchProduct(request, response); break;
                
                default : showList(request, response);break;
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

   private void showListtoUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        Connection connection = DatabaseConnector.getConnection();
    List<Product> productList = new ProductDAO(connection).getAllProducts();
    request.setAttribute("productListU", productList);

    request.getRequestDispatcher("ManageProduct.jsp").forward(request, response);
}



      private void showList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          Connection connection = DatabaseConnector.getConnection(); // Handle the exception appropriately
        // You might want to redirect to an error page in case of an exception
        ProductDAO productDAO = new ProductDAO(connection);
        List<Product> productList = productDAO.getAllProducts();
        request.setAttribute("productList", productList);
        // Forward the request to the listProduct.jsp page
        getServletContext().getRequestDispatcher("/listProduct.jsp").forward(request, response);
    }

    private void load(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException, SQLException, Exception {
         Connection connection = DatabaseConnector.getConnection();
    // Get the productId parameter from the request
    String productIdParam = request.getParameter("productID");

    // Check if productIdParam is not null and is a valid integer
   
        int productId = Integer.parseInt(productIdParam);

        // Get the product object from the database using its ID
        Product product = new ProductDAO(connection).getProductById(productId);

        // Set the product object as an attribute in the session and request
        HttpSession session = request.getSession();
        session.setAttribute("productObj", product);
        request.setAttribute("LoadProduct", product);

        // Forward the request to the "showProductInfo.jsp" page
        request.getRequestDispatcher("ShowProductInfo.jsp").forward(request, response);
    
}


    private void loadtoUpdate(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException, SQLException, Exception {
         Connection connection = DatabaseConnector.getConnection();
    // Get the productId parameter from the request
    String productIdParam = request.getParameter("productID");

    // Check if productIdParam is not null and is a valid integer
    
        int productId = Integer.parseInt(productIdParam);

        // Get the product object from the database using its ID
        Product product = new ProductDAO(connection).getProductById(productId);

        // Set the product object as an attribute in the request
        request.setAttribute("THE_PRODUCT", product);

        // Forward the request to the "EditProduct.jsp" page
        showUpdateProductForm(request, response);
    
}


   private void addProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        // Retrieve data from the form or request parameters
        String productName = request.getParameter("productName");
        BigDecimal price = new BigDecimal(request.getParameter("price"));
        String description = request.getParameter("productDescription");
        int stockQuantity = Integer.parseInt(request.getParameter("stockQuantity"));
        int brandId = Integer.parseInt(request.getParameter("brandID"));
        String imageURL = request.getParameter("imageURL");

        // Assuming you have a ProductDAO class
        ProductDAO productDAO = new ProductDAO(DatabaseConnector.getConnection());

        // Create a new Product object
        Product product = new Product(productName, price, description, stockQuantity, new Brand(brandId), imageURL);

        // Add the product to the database
        productDAO.addProduct(product);

        // Redirect to a success page or update the view
        showListtoUpdate(request, response);
    }
   
    private void showAddProductForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Assuming you have a BrandDAO class
        BrandDAO brandDAO = new BrandDAO(DatabaseConnector.getConnection());

        // Retrieve the brandList from the database
        List<Brand> brandList = brandDAO.getAllBrands();

        // Set the brandList as an attribute in the request
        request.setAttribute("brandList", brandList);

        // Forward the request to the addProduct.jsp page
        getServletContext().getRequestDispatcher("/addProduct.jsp").forward(request, response);
    }
    
    private void showUpdateProductForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Assuming you have a BrandDAO class
        BrandDAO brandDAO = new BrandDAO(DatabaseConnector.getConnection());

        // Retrieve the brandList from the database
        List<Brand> brandList = brandDAO.getAllBrands();

        // Set the brandList as an attribute in the request
        request.setAttribute("brandList", brandList);

        // Forward the request to the addProduct.jsp page
        getServletContext().getRequestDispatcher("/editProduct.jsp").forward(request, response);
    }

     private void deleteProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        // Retrieve data from the form or request parameters
        int productId = Integer.parseInt(request.getParameter("productID"));

        // Assuming you have a ProductDAO class
        ProductDAO productDAO = new ProductDAO(DatabaseConnector.getConnection());

        // Delete the product from the database
        productDAO.deleteProduct(productId);

        // Redirect to a success page or update the view
        showListtoUpdate(request, response);
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        // Retrieve data from the form or request parameters
        int productId = Integer.parseInt(request.getParameter("productID"));
        String productName = request.getParameter("productName");
        BigDecimal price = new BigDecimal(request.getParameter("price"));
        String description = request.getParameter("productDescription");
        int stockQuantity = Integer.parseInt(request.getParameter("stockQuantity"));
        int brandId = Integer.parseInt(request.getParameter("brandID"));
        String imageURL = request.getParameter("imageURL");

        // Assuming you have a ProductDAO class
        ProductDAO productDAO = new ProductDAO(DatabaseConnector.getConnection());

        // Create a new Product object
        Product product = new Product(productId, productName, price, description, stockQuantity, new Brand(brandId), imageURL);

        // Update the product in the database
        productDAO.updateProduct(product);

        // Redirect to a success page or update the view
        showListtoUpdate(request, response);
    }

    
    

    private void searchProduct(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
