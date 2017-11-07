package com.goit.jdbc.app;

import java.sql.*;
import java.util.List;



public class Storage implements ItemDev{
    private String connectionURL = "jdbc:mysql://localhost/module2";
    private String user = "root";
    private String pass = "Bhbirf29";

    private Connection connection;
    private Statement statement;

    private PreparedStatement selectSt;
    private PreparedStatement updateSt;

    public Storage() {
        try {
            Class.forName("com.mysql.jdbc.Driver");  //драйвер, позволяет загрузить через форнейм
            connection = DriverManager.getConnection(connectionURL, user, pass); //соединяем
            statement = connection.createStatement(); //конкретная точка, куда отправляем наш запрос

            selectSt = connection.prepareStatement("SELECT NAME WHERE ID=?");
            updateSt = connection.prepareStatement("UPDATE DEVELOPER SET NAME=?, ID=?");
            //createTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*private void createTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS DEVELOPER" +
                "(ID INT AUTO_INCREMENT PRIMARY KEY," +
                "NAME VARCHAR(50)";
        statement.executeUpdate(sql);
    }*/

   /** private void createDeveloper(com.goit.jdbc.app.Developer developer) throws SQLException {

        String firstname = developer.getFirstName();
        //String lastname = developer.getLastName();

        String insertQuery = "INSERT INTO DEVELOPER (NAME)" + "VALUES('" + firstname  + "')";

        System.out.println(insertQuery);
        try {
            statement.executeUpdate(insertQuery);
            createTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

   public Developer getDeveloper(long id) {
        try {
            String selectQuery =
                    "SELECT ID,NAME FROM DEVELOPER WHERE ID=" + id;
            ResultSet resultSet = statement.executeQuery(selectQuery);

            resultSet.next();
            String firstName = resultSet.getString("NAME");
            //String lastName = resultSet.getString("LAST_NAME");
            long devID = resultSet.getLong("ID");

            Developer result = new Developer();
            result.setFirstName(firstName);
            //result.setLastName(lastName);
            result.setId(devID);

            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

   /* public void deleteDeveloper(long id)  {
        String deleteQuery = "DELETE FROM DEVELOPER WHERE ID=" + id;

        try {
            statement.executeUpdate(deleteQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }*/

    public void updateDeveloper(Developer developer) throws SQLException {
        /*String updateQuery = "UPDATE DEVELOPER SET FIRST_NAME='" +
                developer.getFirstName() + "',LAST_NAME='" +
                developer.getLastName() + "' WHERE ID=" + developer.getId();*/

        // return true;

        // System.out.println(updateQuery);
        System.out.println(updateSt);

        try {
            updateSt.setString(1, developer.getFirstName());
            //updateSt.setString(2,developer.getLastName());
            updateSt.executeUpdate();
            //statement.executeUpdate(updateQuery);
            //return true;
        } catch (SQLException e) {
            e.printStackTrace();
            //return false;
        }


    }

    public void update(Developer developer) {
        Connection connection = null;
        try {

            connection = DriverManager.getConnection(connectionURL, user, pass);
            PreparedStatement statement = connection.prepareStatement(SQL_UPDATE);
            statement.setString(1, developer.getFirstName());
            statement.setLong(2, developer.getId());
            statement.executeUpdate();
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

    public void close() throws SQLException {
        selectSt.close(); //закрываем все конннекшны
        //почитать по banch
    }

    public static void main(String[] args) throws SQLException {
        Storage storage = new Storage();

    /*    Developer dev = new Developer();
        dev.setFirstName("Ivan");
        dev.setLastName("Melnichuk");

        storage.createDeveloper(dev);*/

  /*  Developer dev = storage.getDeveloper(2);
    storage.deleteDeveloper(1);
        System.out.println(dev.getFirstName() + ", " + dev.getLastName());*/

        Developer developer = storage.getDeveloper(2);
        developer.setFirstName("Taras");
        storage.updateDeveloper(developer);
    }
}


