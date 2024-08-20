package com.kimmy.servlets;

import com.kimmy.dao.UserDao;
import com.kimmy.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/Signup")
public class SignUpServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        String state = request.getParameter("state");
        String city = request.getParameter("city");
        String houseNumber = request.getParameter("house_number");
        String phoneNumber = request.getParameter("phone_number");
        String password = request.getParameter("password");

        User user = new User(0, name, email, country, state, city, houseNumber, phoneNumber, password);
        UserDao userDAO = new UserDao();

        try {
            userDAO.saveUser(user);
            response.sendRedirect("allUsers");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
