package com.kimmy.servlets;

import com.kimmy.dao.StudentDao;
import com.kimmy.dao.UserDao;
import com.kimmy.model.Student;
import com.kimmy.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/fetch")
public class SearchServlet extends HttpServlet {

    private final UserDao userDao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String query = req.getParameter("query");
            List<User> users = userDao.searchUsers(query);
            req.setAttribute("users", users);
            req.getRequestDispatcher("/pages/home.jsp").forward(req, resp);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
