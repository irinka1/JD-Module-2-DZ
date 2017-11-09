package com.goit.jdbc.app.DAOs;

import com.goit.jdbc.app.Entities.Project;

public interface ProjectDAO {
    public static final String selectAll = "SELECT * FROM PROJECT";
    public static final String selectPr = selectAll + " WHERE ID = ?";
    public static final String createPr = "INSERT INTO PROJECT (NAME, COST) VALUES(?,?)";
    public static final String updatePr = "UPDATE PROJECT SET  NAME=?, COST=? WHERE ID=?";
    public static final String deletePr = "DELETE FROM PROJECT WHERE ID=?";

    public Project selectProject(Long id);
    public void createProject(Project project);
    public void updateProject(Project project);
    public void deleteProject(Project project);

}
