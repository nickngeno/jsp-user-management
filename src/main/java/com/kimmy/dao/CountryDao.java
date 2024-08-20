package com.kimmy.dao;

import com.kimmy.model.Country;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountryDao {
    private final String JDBC_URL = "jdbc:mysql://localhost:3306/users_db";
    private final String DB_USER = "root";
    private final String DB_PASSWORD = "pass";

    private Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Country> getAllCountries() throws SQLException {
        Connection con = getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT id, name FROM countries");
        List<Country> countries = new ArrayList<>();
        while (rs.next()) {
            countries.add(new Country(rs.getInt("id"), rs.getString("name")));
        }
        return countries;
    }
}
