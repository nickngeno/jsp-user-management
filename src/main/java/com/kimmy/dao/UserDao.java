package com.kimmy.dao;

import com.kimmy.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private final String JDBC_URL = "jdbc:mysql://localhost:3306/users_db";
    private final String DB_USER = "root";
    private final String DB_PASSWORD = "pass";

    private static final String SELECT_ALL_STUDENTS = "SELECT * FROM students";

    private Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void saveUser(User user) throws SQLException {
        Connection connection = getConnection();

        try {
            if (connection != null) {
                String sql = "INSERT INTO users (name, email, country_id, state_id, city_id, house_number, phone_number, password_hash) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1, user.getName());
                ps.setString(2, user.getEmail());
                ps.setString(3, user.getCountry());
                ps.setString(4, user.getState());
                ps.setString(5, user.getCity());
                ps.setString(6, user.getHouseNumber());
                ps.setString(7, user.getPhoneNumber());
                ps.setString(8, user.getPassword()); // Hash password before saving
                ps.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public List<User> getAllUsers() throws SQLException {
        Connection connection = getConnection();
        List<User> users = new ArrayList<>();
        try {
            if (connection != null) {
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM users");

                while (rs.next()) {
                    User user = new User(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("email"),
                            rs.getString("country_id"),
                            rs.getString("state_id"),
                            rs.getString("city_id"),
                            rs.getString("house_number"),
                            rs.getString("phone_number"),
                            rs.getString("password_hash")
                    );
                    users.add(user);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return users;
    }

    public User getById(int id) throws SQLException {
        User user = null;
        Connection connection = getConnection();
        try {
            if (connection != null) {
                String sql = "SELECT * FROM users WHERE id = ?";

                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, id);
                ResultSet rs = preparedStatement.executeQuery();

                while (rs.next()) {
                    user = new User(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("email"),
                            rs.getString("country_id"),
                            rs.getString("state_id"),
                            rs.getString("city_id"),
                            rs.getString("house_number"),
                            rs.getString("phone_number"),
                            rs.getString("password_hash")
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return user;
    }

    public List<User> searchUsers(String query) {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users WHERE name LIKE ? OR email LIKE ? OR phone_number LIKE ?";

        Connection connection = getConnection();
        try {
            if (connection != null) {

                PreparedStatement statement = connection.prepareStatement(sql);

                String searchQuery = "%" + query + "%";
                statement.setString(1, searchQuery);
                statement.setString(2, searchQuery);
                statement.setString(3, searchQuery);

                ResultSet rs = statement.executeQuery();

                while (rs.next()) {
                    User user = new User(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("email"),
                            rs.getString("country_id"),
                            rs.getString("state_id"),
                            rs.getString("city_id"),
                            rs.getString("house_number"),
                            rs.getString("phone_number"),
                            rs.getString("password_hash"));
                    users.add(user);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return users;
    }

    public User updateUser(User user) {
        Connection connection = getConnection();
        try {
            if (connection != null) {
                String sql = "UPDATE users SET name=?,email=?, phone_number=?, house_number=? WHERE id=?";

                PreparedStatement statement = connection.prepareStatement(sql);

                statement.setString(1, user.getName());
                statement.setString(2, user.getEmail());
                statement.setString(3, user.getPhoneNumber());
                statement.setString(4, user.getHouseNumber());
                statement.setInt(5, user.getId());

                int rowsAffected = statement.executeUpdate();

                if (rowsAffected > 0) {
                    return user;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public int deleteUser(int id) {
        Connection connection = getConnection();
        try {
            if (connection != null) {
                String sql = "Delete from users WHERE id=?";

                PreparedStatement statement = connection.prepareStatement(sql);

                statement.setInt(1, id);

                return statement.executeUpdate();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }
}
