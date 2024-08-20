package com.kimmy.servlets;

import com.kimmy.dao.UserDao;
import com.kimmy.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDAO = new UserDao();
        try {
            List<User> users = userDAO.getAllUsers();
            request.setAttribute("users", users);
            request.getRequestDispatcher("/pages/home.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String method = request.getParameter("_method");
        if (method.equalsIgnoreCase("PUT")) {
            doPut(request, response);
        } else if (method.equalsIgnoreCase("Delete")) {
            doDelete(request, response);
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) {

        UserDao userDao = new UserDao();
        // Retrieve form data
        int id = Integer.parseInt(request.getParameter("userId"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phoneNo");
        String houseNo = request.getParameter("houseNo");

        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setEmail(email);
        user.setPhoneNumber(phone);
        user.setHouseNumber(houseNo);

        User user1 = userDao.updateUser(user);

        try {
            if (null != user1) {
                response.sendRedirect(request.getContextPath() + "/UserServlet");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) {
        UserDao userDao = new UserDao();
        try {

            int id = Integer.parseInt(request.getParameter("userId"));
            int i = userDao.deleteUser(id);
            if (i > 0) {
                try {
                    response.sendRedirect(request.getContextPath() + "/UserServlet");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");
            out.println("Deletion not successful");
            out.close();
        }catch ( Exception e ) {
            e.printStackTrace();
        }
    }
}
