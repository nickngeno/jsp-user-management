package com.kimmy.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.kimmy.model.State;

public class StateDao {

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

    public List<State> getStatesByCountryId(int countryId) throws SQLException {
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement("SELECT id, name FROM states WHERE country_id = ?");
        ps.setInt(1, countryId);
        ResultSet rs = ps.executeQuery();
        List<State> states = new ArrayList<>();
        while (rs.next()) {
            states.add(new State(rs.getInt("id"), rs.getString("name")));
        }
        return states;
    }
}
