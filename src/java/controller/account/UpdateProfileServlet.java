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
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");

            // Lấy người dùng hiện tại từ session
            User currentUser = getUserFromDataStorage(request);

            // Cập nhật thông tin nếu không rỗng
            if (username != null && !username.isEmpty()) {
                currentUser.setUsername(username);
            }
            if (email != null && !email.isEmpty()) {
                currentUser.setEmail(email);
            }
            if (password != null && !password.isEmpty()) {
                currentUser.setPassword(password);
            }
            if (phone != null && !phone.isEmpty()) {
                currentUser.setPhone(phone);
            }
            if (address != null && !address.isEmpty()) {
                currentUser.setAddress(address);
            }

            // Cập nhật thông tin người dùng trong cơ sở dữ liệu
            UserDAO dao = new UserDAO(DatabaseConnector.getConnection());
            dao.updateUserProfile(currentUser);

            // Chuyển hướng về trang profile
            response.sendRedirect("profile.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            // Xử lý ngoại lệ một cách phù hợp
        }
    }

    private User getUserFromDataStorage(HttpServletRequest request) {
        int userID = (int) request.getSession().getAttribute("userID");

        UserDAO dao = new UserDAO(DatabaseConnector.getConnection());
        return dao.getUserById(userID);
    }

    @Override
    public String getServletInfo() {
        return "Servlet to update user profile";
    }
}
