package com.goit.jdbc.app.Storages;

import com.goit.jdbc.app.Companies;
import com.goit.jdbc.app.Customers;
import com.goit.jdbc.app.DAOs.CustomersDAO;

import java.sql.*;

import static com.goit.jdbc.app.DAOs.CompaniesDAO.*;
import static com.goit.jdbc.app.DAOs.CustomersDAO.selectCustomersSt;

public class StorageCustomers implements CustomersDAO {


    private String connectionURL = "jdbc:mysql://localhost/module2";
    private String user = "root";
    private String pass = "Bhbirf29";

    private Connection connection;
    private Statement statement;


    public StorageCustomers() {
        try {
            Class.forName("com.mysql.jdbc.Driver");  //драйвер, позволяет загрузить через форнейм
            connection = DriverManager.getConnection(connectionURL, user, pass); //соединяем
            statement = connection.createStatement(); //конкретная точка, куда отправляем наш запрос
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createCustomers(Customers customers) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionURL, user, pass);
            PreparedStatement statement = connection.prepareStatement(createCustomersSt, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, customers.getName());
            statement.execute();

            ResultSet generatedkeys = statement.getGeneratedKeys();
            if (generatedkeys.next()) {
                customers.setId(generatedkeys.getLong(1));
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

    public Customers selectCustomers(Long id) {
        Customers customers = null;
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionURL, user, pass);
            PreparedStatement statement = connection.prepareStatement(selectCustomersSt);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                customers = new Customers();
                customers.setId(rs.getLong("ID"));
                customers.setName(rs.getString("NAME"));
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
        return customers;
    }

    public void updateCustomers(Customers customers) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionURL, user, pass);
            PreparedStatement statement = connection.prepareStatement(updateCustomersSt);
            statement.setString(1, customers.getName());
            statement.setLong(2, customers.getId());
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

    public void deleteCustomers(Customers customers) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionURL, user, pass);
            PreparedStatement statement = connection.prepareStatement(deleteCustomersSt);
            statement.setLong(1, customers.getId());
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
