package com.kimmy.servlets;


import com.google.gson.Gson;
import com.kimmy.dao.StateDao;
import com.kimmy.model.State;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/StateServlet")
public class StateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StateDao stateDAO = new StateDao();
        try {
            int countryId = Integer.parseInt(request.getParameter("countryId"));
            List<State> states = stateDAO.getStatesByCountryId(countryId);
            String json = new Gson().toJson(states);
            response.setContentType("application/json");
            response.getWriter().write(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
