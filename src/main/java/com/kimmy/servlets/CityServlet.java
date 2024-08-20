package com.kimmy.servlets;


import com.google.gson.Gson;
import com.kimmy.dao.CityDao;
import com.kimmy.model.City;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/CityServlet")
public class CityServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CityDao cityDAO = new CityDao();
        try {
            int stateId = Integer.parseInt(request.getParameter("stateId"));
            List<City> cities = cityDAO.getCitiesByStateId(stateId);
            String json = new Gson().toJson(cities);
            response.setContentType("application/json");
            response.getWriter().write(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
