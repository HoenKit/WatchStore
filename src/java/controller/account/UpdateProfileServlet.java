package controller.account;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.UserDAO;
import model.database.DatabaseConnector;
import model.entity.User;

public class UpdateProfileServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            
            User user=new User();
            user.setUserID(id);
            user.setUsername(username);
            user.setEmail(email);
            user.setPassword(password);
            user.setPhone(phone);
            user.setAddress(address);
                         
                    
            
            // Cập nhật thông tin người dùng trong cơ sở dữ liệu
            UserDAO dao = new UserDAO(DatabaseConnector.getConnection());
            boolean f=dao.checkPassword(id, password);
            if(f){
                boolean f2=dao.updateUserProfile(user);
                if(f2){
                request.setAttribute("succMsg", "User Profile Update Successfully");
                request.getRequestDispatcher("profile.jsp").forward(request, response);
                }else{
                request.setAttribute("failedMsg", "Somthing wrong on server");
                request.getRequestDispatcher("profile.jsp").forward(request, response);
                }
                
            }
            /*else{
                request.setAttribute("failedMsg", "Your Password is Incorect");
                request.getRequestDispatcher("profile.jsp").forward(request, response);
            }*/

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   
    @Override
    public String getServletInfo() {
        return "Servlet to update user profile";
    }
}
