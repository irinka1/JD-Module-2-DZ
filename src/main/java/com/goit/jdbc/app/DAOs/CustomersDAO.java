package com.goit.jdbc.app.DAOs;

import com.goit.jdbc.app.Entities.Customers;

public interface CustomersDAO {
    public static final String selectAllCustomers = "SELECT * FROM CUSTOMERS";
    public static final String selectCustomersSt = selectAllCustomers + " WHERE ID = ?";
    public static final String createCustomersSt = "INSERT INTO CUSTOMERS (NAME) VALUES(?)";
    public static final String updateCustomersSt = "UPDATE CUSTOMERS SET NAME=? WHERE ID=?";
    public static final String deleteCustomersSt = "DELETE FROM CUSTOMERS WHERE ID=?";

    public Customers selectCustomers(Long id);
    public void createCustomers(Customers customers);
    public void updateCustomers(Customers customers);
    public void deleteCustomers(Customers customers);
}
