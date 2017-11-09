package com.goit.jdbc.app.DAOs;

import com.goit.jdbc.app.Entities.Companies;

public interface CompaniesDAO {

    public static final String selectAllCompanies = "SELECT * FROM COMPANIES";
    public static final String selectCompaniesSt = selectAllCompanies + " WHERE ID = ?";
    public static final String createCompaniesSt = "INSERT INTO COMPANIES (NAME) VALUES(?)";
    public static final String updateCompaniesSt = "UPDATE COMPANIES SET NAME=? WHERE ID=?";
    public static final String deleteCompaniesSt = "DELETE FROM COMPANIES WHERE ID=?";

    public Companies selectCompanies(Long id);
    public void createCompanies(Companies companies);
    public void updateCompanies(Companies companies);
    public void deleteCompanies(Companies companies);
}
