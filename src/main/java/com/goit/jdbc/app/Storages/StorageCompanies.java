package com.goit.jdbc.app.Storages;
import com.goit.jdbc.app.Entities.Companies;
import java.sql.*;

import static com.goit.jdbc.app.DAOs.CompaniesDAO.*;

public class StorageCompanies {

    private String connectionURL = "jdbc:mysql://localhost/module2";
    private String user = "root";
    private String pass = "Bhbirf29";

    private Connection connection;
    private Statement statement;


    public StorageCompanies() {
        try {
            Class.forName("com.mysql.jdbc.Driver");  //драйвер, позволяет загрузить через форнейм
            connection = DriverManager.getConnection(connectionURL, user, pass); //соединяем
            statement = connection.createStatement(); //конкретная точка, куда отправляем наш запрос
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createCompanies(Companies companies) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionURL, user, pass);
            PreparedStatement statement = connection.prepareStatement(createCompaniesSt, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, companies.getName());
            statement.execute();

            ResultSet generatedkeys = statement.getGeneratedKeys();
            if (generatedkeys.next()) {
                companies.setId(generatedkeys.getLong(1));
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

    public Companies selectCompanies(Long id) {
        Companies companies = null;
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionURL, user, pass);
            PreparedStatement statement = connection.prepareStatement(selectCompaniesSt);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                companies = new Companies();
                companies.setId(rs.getLong("ID"));
                companies.setName(rs.getString("NAME"));
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
        return companies;
    }

    public void updateCompanies(Companies companies) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionURL, user, pass);
            PreparedStatement statement = connection.prepareStatement(updateCompaniesSt);
            statement.setString(1, companies.getName());
            statement.setLong(2, companies.getId());
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

    public void deleteCompanies(Companies companies) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionURL, user, pass);
            PreparedStatement statement = connection.prepareStatement(deleteCompaniesSt);
            statement.setLong(1, companies.getId());
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
