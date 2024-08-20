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


@WebServlet("/result")
public class ResultServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final UserDao userDao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            int id = Integer.parseInt(req.getParameter("id"));
            User byId = userDao.getById(id);
            req.setAttribute("user", byId);
            req.getRequestDispatcher("/pages/result.jsp").forward(req, resp);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

