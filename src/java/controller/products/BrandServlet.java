/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.products;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.BrandDAO;
import model.database.DatabaseConnector;
import model.entity.Brand;

@WebServlet("/BrandServlet")
public class BrandServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private BrandDAO brandDAO;

    public void init() {
        
         brandDAO = new BrandDAO(DatabaseConnector.getConnection());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "list"; // Default action
        }

        switch (action) {
            case "list":
                listBrands(request, response);
                break;
            case "showForm":
                showBrandForm(request, response);
                break;
            case "add":
                addBrand(request, response);
                break;
            case "delete":
                deleteBrand(request, response);
                break;
            default:
                listBrands(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private void listBrands(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Brand> brands = brandDAO.getAllBrands();
        request.setAttribute("brands", brands);
        request.getRequestDispatcher("brand-list.jsp").forward(request, response);
    }

    private void showBrandForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Forward to a JSP page for adding a new brand
        request.getRequestDispatcher("brand-form.jsp").forward(request, response);
    }

    private void addBrand(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String brandName = request.getParameter("brandName");

        // Validation (add your own validation logic as needed)
        if (brandName == null || brandName.trim().isEmpty()) {
            // Handle validation error
            // For simplicity, redirect to the showForm page with an error message
            response.sendRedirect("BrandServlet?action=showForm&error=Brand name is required");
            return;
        }

        Brand newBrand = new Brand();
        newBrand.setBrandName(brandName);

        brandDAO.addBrand(newBrand);

        // Redirect to the list after adding
        response.sendRedirect("BrandServlet?action=list");
    }

    private void deleteBrand(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String brandIdStr = request.getParameter("id");

        if (brandIdStr == null || brandIdStr.trim().isEmpty()) {
            // Handle error, invalid brand ID
            response.sendRedirect("BrandServlet?action=list");
            return;
        }

        int brandId = Integer.parseInt(brandIdStr);
        brandDAO.deleteBrand(brandId);

        // Redirect to the list after deleting
        response.sendRedirect("BrandServlet?action=list");
    }
}
