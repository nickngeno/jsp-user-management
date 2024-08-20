package com.kimmy.dao;

import com.kimmy.model.City;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CityDao {
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

    public List<City> getCitiesByStateId(int stateId) throws SQLException {
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement("SELECT id, name FROM cities WHERE state_id = ?");
        ps.setInt(1, stateId);
        ResultSet rs = ps.executeQuery();
        List<City> cities = new ArrayList<>();
        while (rs.next()) {
            cities.add(new City(rs.getInt("id"), rs.getString("name")));
        }
        return cities;
    }
}
