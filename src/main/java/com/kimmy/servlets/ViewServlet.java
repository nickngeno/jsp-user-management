package com.kimmy.servlets;

import com.kimmy.dao.UserDao;
import com.kimmy.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ViewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            User byId = userDao.getById(id);
            req.setAttribute("user", byId);
            req.getRequestDispatcher("/pages/update.jsp").forward(req, resp);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

