package com.goit.jdbc.app.DAOs;

import com.goit.jdbc.app.Skills;

public interface SkillsDAO {
    public static final String selectAllSkills = "SELECT * FROM SKILLS";
    public static final String selectSkillsSt = selectAllSkills + " WHERE ID = ?";
    public static final String createSkillsSt = "INSERT INTO SKILLS (NAME) VALUES(?)";
    public static final String updateSkillsSt = "UPDATE SKILLS SET NAME=? WHERE ID=?";
    public static final String deleteSkillsSt = "DELETE FROM SKILLS WHERE ID=?";

    public Skills selectSkills(Long id);
    public void createSkills(Skills skills);
    public void updateSkills(Skills skills);
    public void deleteSkills(Skills skills);
}
