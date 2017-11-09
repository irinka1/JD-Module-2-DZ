package com.goit.jdbc.app.Storages;

import com.goit.jdbc.app.Entities.Skills;
import com.goit.jdbc.app.DAOs.SkillsDAO;

import java.sql.*;

public class StorageSkills implements SkillsDAO {
    private String connectionURL = "jdbc:mysql://localhost/module2";
    private String user = "root";
    private String pass = "Bhbirf29";

    private Connection connection;
    private Statement statement;


    public StorageSkills() {
        try {
            Class.forName("com.mysql.jdbc.Driver");  //драйвер, позволяет загрузить через форнейм
            connection = DriverManager.getConnection(connectionURL, user, pass); //соединяем
            statement = connection.createStatement(); //конкретная точка, куда отправляем наш запрос
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createSkills(Skills skills) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionURL, user, pass);
            PreparedStatement statement = connection.prepareStatement(createSkillsSt, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, skills.getName());
            statement.execute();

            ResultSet generatedkeys = statement.getGeneratedKeys();
            if (generatedkeys.next()) {
                skills.setId(generatedkeys.getLong(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Skills selectSkills(Long id) {
        Skills skills = null;
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionURL, user, pass);
            PreparedStatement statement = connection.prepareStatement(selectSkillsSt);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                skills = new Skills();
                skills.setId(rs.getLong("ID"));
                skills.setName(rs.getString("NAME"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return skills;
    }

    public void updateSkills(Skills skills) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionURL, user, pass);
            PreparedStatement statement = connection.prepareStatement(updateSkillsSt);
            statement.setString(1, skills.getName());
            statement.setLong(2, skills.getId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteSkills(Skills skills) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionURL, user, pass);
            PreparedStatement statement = connection.prepareStatement(deleteSkillsSt);
            statement.setLong(1, skills.getId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
