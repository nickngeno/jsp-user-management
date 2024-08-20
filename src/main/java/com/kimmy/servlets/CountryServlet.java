package com.kimmy.servlets;

import com.kimmy.dao.CountryDao;
import com.kimmy.model.Country;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class CountryServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CountryDao countryDAO = new CountryDao();
        try {
            List<Country> countries = countryDAO.getAllCountries();
            request.setAttribute("countries", countries);
            request.getRequestDispatcher("signUp.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
