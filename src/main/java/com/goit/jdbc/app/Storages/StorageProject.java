package com.goit.jdbc.app.Storages;

import com.goit.jdbc.app.Project;
import com.goit.jdbc.app.DAOs.ProjectDAO;

import java.sql.*;


public class StorageProject implements ProjectDAO {

    private String connectionURL = "jdbc:mysql://localhost/module2";
    private String user = "root";
    private String pass = "Bhbirf29";

    private Connection connection;
    private Statement statement;


    public StorageProject() {
        try {
            Class.forName("com.mysql.jdbc.Driver");  //драйвер, позволяет загрузить через форнейм
            connection = DriverManager.getConnection(connectionURL, user, pass); //соединяем
            statement = connection.createStatement(); //конкретная точка, куда отправляем наш запрос
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createProject(Project project) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionURL, user, pass);
            PreparedStatement statement = connection.prepareStatement(createPr, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, project.getName());
            statement.setBigDecimal(2, project.getCost());
            statement.execute();

            ResultSet generatedkeys = statement.getGeneratedKeys();
            if (generatedkeys.next()) {
                project.setId(generatedkeys.getLong(1));
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

    public Project selectProject(Long id) {
        Project project = null;
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionURL, user, pass);
            PreparedStatement statement = connection.prepareStatement(selectPr);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                project = new Project();
                project.setId(rs.getLong("ID"));
                project.setName(rs.getString("NAME"));
                project.setCost(rs.getBigDecimal("COST"));
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
        return project;
    }

    public void updateProject(Project project) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionURL, user, pass);
            PreparedStatement statement = connection.prepareStatement(updatePr);
            statement.setString(1, project.getName());
            statement.setBigDecimal(2, project.getCost());
            statement.setLong(3, project.getId());
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

    public void deleteProject(Project project ) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionURL, user, pass);
            PreparedStatement statement = connection.prepareStatement(deletePr);
            statement.setLong(1, project.getId());
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
