package pl.coderslab.users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/users/add")
public class addUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        getServletContext().getRequestDispatcher("/users/add.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        User user = new User();
        user.setUserName(request.getParameter("userName"));
        user.setEmail(request.getParameter("email"));
        user.setPassword(request.getParameter("password"));
//        response.getWriter().println("user: " +request.getParameter("userName"));
//        response.getWriter().println("email: " +request.getParameter("email"));

        UserDao userDao = new UserDao();
        userDao.create(user);
        response.sendRedirect(request.getContextPath() + "/users/list");
//        getServletContext().getRequestDispatcher("/users/add.jsp")
//                .forward(request, response);
    }
}
