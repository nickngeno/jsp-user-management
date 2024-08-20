package com.kimmy.model;

public class Student {
    private int id;
    private String name;
    private String studentId;
    private String phoneNumber;
    private String currentClassNumber;

    public Student() {
    }

    public Student(int id, String name, String studentId, String phoneNumber, String currentClassNumber) {
        this.id = id;
        this.name = name;
        this.studentId = studentId;
        this.phoneNumber = phoneNumber;
        this.currentClassNumber = currentClassNumber;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCurrentClassNumber() {
        return currentClassNumber;
    }

    public void setCurrentClassNumber(String currentClassNumber) {
        this.currentClassNumber = currentClassNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", studentId='" + studentId + '\'' +
               ", phoneNumber='" + phoneNumber + '\'' +
               ", currentClassNumber='" + currentClassNumber + '\'' +
               '}';
    }
}
