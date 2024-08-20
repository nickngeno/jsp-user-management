package com.kimmy.dao;

import com.kimmy.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class StudentDao {
    private final String JDBC_URL = "jdbc:mysql://localhost:3306/student_db";
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

    public List<Student> searchStudents(String query) {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students WHERE name LIKE ? OR student_id LIKE ? OR phone_number LIKE ?";

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
                    Student student = new Student();
                    student.setId(rs.getInt("id"));
                    student.setName(rs.getString("name"));
                    student.setStudentId(rs.getString("student_id"));
                    student.setPhoneNumber(rs.getString("phone_number"));
                    student.setCurrentClassNumber(rs.getString("current_class_number"));
                    students.add(student);
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
        return students;
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        Connection connection = getConnection();
        try {
            if (connection != null) {

                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENTS);
                ResultSet rs = preparedStatement.executeQuery();

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String studentId = rs.getString("student_id");
                    String phoneNumber = rs.getString("phone_number");
                    String classNumber = rs.getString("current_class_number");

                    students.add(new Student(id, name, studentId, phoneNumber, classNumber));
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
        return students;
    }

    public Student getById(int id) throws SQLException {
        Student student = null;
        Connection connection = getConnection();
        try {
            if (connection != null) {
                String sql = "SELECT * FROM students WHERE id = ?";

                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, id);
                ResultSet rs = preparedStatement.executeQuery();

                while (rs.next()) {
                    int _id = rs.getInt("id");
                    String name = rs.getString("name");
                    String studentId = rs.getString("student_id");
                    String phoneNumber = rs.getString("phone_number");
                    String classNumber = rs.getString("current_class_number");
                    student = new Student(_id, name, studentId, phoneNumber, classNumber);
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
        return student;
    }

    public Student updateStudent(Student student) {
        Connection connection = getConnection();
        try {
            if (connection != null) {
                String sql = "UPDATE students SET name=?, phone_number=?, current_class_number=? WHERE student_id=?";

                PreparedStatement statement = connection.prepareStatement(sql);

                statement.setString(1, student.getName());
                statement.setString(2, student.getPhoneNumber());
                statement.setString(3, student.getCurrentClassNumber());
                statement.setString(4, student.getStudentId());

                int rowsAffected = statement.executeUpdate();

                if (rowsAffected > 0) {
                    return student;
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
}
