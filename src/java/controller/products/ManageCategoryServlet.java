/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.products;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.CategoryDAO;
import model.database.DatabaseConnector;
import model.entity.Category;

/**
 *
 * @author ADMIN
 */
public class ManageCategoryServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ManageCategoryServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ManageCategoryServlet at " + request.getContextPath() + "</h1>");
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
         String action = request.getParameter("action");

        if (action == null) {
            action = "list"; // Default action
        }

        switch (action) {
            case "list":
                listCategories(request, response);
                break;
            case "showForm":
                showCategoryForm(request, response);
                break;
            case "add":
                addCategory(request, response);
                break;    
            case "delete":
                deleteCategory(request, response);
                break;
            default:
                listCategories(request, response);
                break;
        }
    }
     
     private CategoryDAO categoryDAO;

    public void init() {
        
         categoryDAO = new CategoryDAO(DatabaseConnector.getConnection());
    }

    private void listCategories(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Category> categories = categoryDAO.getAllCategories();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("category-list.jsp").forward(request, response);
    }

    private void showCategoryForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Forward to a JSP page for adding a new category
        request.getRequestDispatcher("category-form.jsp").forward(request, response);
    }

    private void addCategory(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String categoryName = request.getParameter("categoryName");

        // Validation (add your own validation logic as needed)
        if (categoryName == null || categoryName.trim().isEmpty()) {
            // Handle validation error
            // For simplicity, redirect to the showForm page with an error message
            response.sendRedirect("ManageCategoryServlet?action=showForm&error=Category name is required");
            return;
        }

        Category newCategory = new Category(categoryName);
       
        categoryDAO.addCategory(newCategory);

        // Redirect to the list after adding
        response.sendRedirect("ManageCategoryServlet?action=list");
    }


    private void deleteCategory(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String categoryIdStr = request.getParameter("id");

        if (categoryIdStr == null || categoryIdStr.trim().isEmpty()) {
            // Handle error, invalid category ID
            response.sendRedirect("ManageCategoryServlet?action=list");
            return;
        }

        int categoryId = Integer.parseInt(categoryIdStr);
        categoryDAO.deleteCategory(categoryId);

        // Redirect to the list after deleting
        response.sendRedirect("ManageCategoryServlet?action=list");
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

}
