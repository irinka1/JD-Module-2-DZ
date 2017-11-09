package com.goit.jdbc.app.Storages;

import com.goit.jdbc.app.DAOs.DevDAO;
import com.goit.jdbc.app.Entities.Developer;

import java.sql.*;

public class Storage implements DevDAO {
    private String connectionURL = "jdbc:mysql://localhost/module2";
    private String user = "root";
    private String pass = "Bhbirf29";

    private Connection connection;
    private Statement statement;


    public Storage() {
        try {
            Class.forName("com.mysql.jdbc.Driver");  //драйвер, позволяет загрузить через форнейм
            connection = DriverManager.getConnection(connectionURL, user, pass); //соединяем
            statement = connection.createStatement(); //конкретная точка, куда отправляем наш запрос
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void createDeveloper(Developer developer) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionURL, user, pass);
            PreparedStatement statement = connection.prepareStatement(createSt, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, developer.getFirstName());
            statement.setString(2, developer.getLastName());
            statement.execute();

            ResultSet generatedkeys = statement.getGeneratedKeys();
            if (generatedkeys.next()) {
                developer.setId(generatedkeys.getLong(1));
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

    public Developer selectSt(Long id) {
        Developer developer = null;
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionURL, user, pass);
            PreparedStatement statement = connection.prepareStatement(selectSt);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                developer = new Developer();
                developer.setId(rs.getLong("ID"));
                developer.setFirstName(rs.getString("FIRST_NAME"));
                developer.setLastName(rs.getString("LAST_NAME"));
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
        return developer;
    }

    public void updateDeveloper(Developer developer) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionURL, user, pass);
            PreparedStatement statement = connection.prepareStatement(updateSt);
            statement.setString(1, developer.getFirstName());
            statement.setString(2, developer.getLastName());
            statement.setLong(3, developer.getId());
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

    public void deleteDeveloper(Developer developer) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionURL, user, pass);
            PreparedStatement statement = connection.prepareStatement(deleteSt);
            statement.setLong(1, developer.getId());
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

