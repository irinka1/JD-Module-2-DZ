package com.goit.jdbc.app;

import java.util.List;

public interface ItemDev {
    public static final String SQL_FIND_ALL = "SELECT * FROM Developer";
    public static final String SQL_FIND_BY_ID = SQL_FIND_ALL + " WHERE ID = ?";
    public static final String SQL_INSERT = "INSERT INTO DEVELOPER (NAME) VALUES(?)";
    public static final String SQL_UPDATE = "UPDATE DEVELOPER SET NAME=? WHERE ID=?";
    public static final String SQL_DELETE = "DELETE FROM DEVELOPER WHERE ID=?";

   // public Developer findById(Long id);
   // public void insert(Developer developer);
    public void update(Developer developer);
   // public void delete(Developer developer);
}
