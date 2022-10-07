package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBManager {
    private ClientFrame clientFrame;
    private Connection connection;

    public DBManager(String ip, String port) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + ip + ":" + port + "/students?useUnicode=true&serverTimezone=UTC", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addStudent(PackageData pd) {
        Students student = pd.getStudent();
        if (pd.getOperationType().equals("ADD_STUDENT")) {
            try {
                PreparedStatement statement = connection.prepareStatement("insert into students(name, surname, age) values(?,?,?)");
                statement.setString(1, student.getName());
                statement.setString(2, student.getSurname());
                statement.setInt(3, student.getAge());

                statement.executeUpdate();
                statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<Students> getAllStudents(PackageData pd) {
        ArrayList<Students> students = new ArrayList<>();
        if (pd.getOperationType().equals("LIST_STUDENTS")) {
            try {
                PreparedStatement statement = connection.prepareStatement("select * from students");
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    Long id = resultSet.getLong("id");
                    String name = resultSet.getString("name");
                    String surname = resultSet.getString("surname");
                    int age = resultSet.getInt("age");

                    Students stud = new Students(id, name, surname, age);
                    students.add(stud);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return students;
    }
}


