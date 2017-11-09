package com.goit.jdbc.app.DAOs;

import com.goit.jdbc.app.Entities.Developer;

public interface DevDAO {
    public static final String selectAll = "SELECT * FROM DEVELOPER";
    public static final String selectSt = selectAll + " WHERE ID = ?";
    public static final String createSt = "INSERT INTO DEVELOPER (FIRST_NAME,LAST_NAME) VALUES(?,?)";
    public static final String updateSt = "UPDATE DEVELOPER SET  FIRST_NAME=?, LAST_NAME=? WHERE ID=?";
    public static final String deleteSt = "DELETE FROM DEVELOPER WHERE ID=?";

    public Developer selectSt(Long id);
    public void createDeveloper(Developer developer);
    public void updateDeveloper(Developer developer);
    public void deleteDeveloper(Developer developer);
}
