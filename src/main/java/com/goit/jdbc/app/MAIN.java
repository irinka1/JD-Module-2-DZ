package com.goit.jdbc.app;

import com.goit.jdbc.app.Storages.*;

import java.sql.SQLException;

public class MAIN {
    public static void main(String[] args) throws SQLException {
        StorageProject storageProject = new StorageProject();
        Storage storage = new Storage();
        StorageSkills storageSkills = new StorageSkills();
        StorageCompanies storageCompanies = new StorageCompanies();
        StorageCustomers storageCustomers = new StorageCustomers();

        Skills skills = new Skills();
        Developer developer = new Developer();
        Project project = new Project();
        Companies companies = new Companies();
        Customers customers = new Customers();

        //create new developer
       /* developer.setFirstName("Roma");
        developer.setLastName("Dodo");
        storage.createDeveloper(developer);

        Developer developer2 = storage.selectSt(1L); //update data developer by ID 1
        developer2.setFirstName("Volodya");
        storage.updateDeveloper(developer2);

        //find developer by ID 1
        System.out.println(storage.selectSt(1L));

        Developer developer3 = storage.selectSt(2L);   //delete developers by ID 2
        storage.deleteDeveloper(developer3);

        //create new project
        project.setName("Project5");
        project.setCost(new BigDecimal(15));
        storageProject.createProject(project);

        Project project2 = storageProject.selectProject(6L); //update data project by ID 1
        project2.setName("Project123");
        project2.setCost(new BigDecimal(154800));
        storageProject.updateProject(project2);

        //find project by ID 1
        System.out.println(storageProject.selectProject(6L));

        Project project4 = storageProject.selectProject(7L);   //delete project by ID 2
        storageProject.deleteProject(project4);*/

        //create new skills
        /*skills.setName("C+++");
        storageSkills.createSkills(skills);*/

        /*Skills skills2 = storageSkills.selectSkills(1L); //update data skills by ID 1
        skills2.setName("Skill234");
        storageSkills.updateSkills(skills2);*/

        //find skills by ID 1
       /* System.out.println(storageSkills.selectSkills(2L));

        Skills skills1 = storageSkills.selectSkills(5L);   //delete skills by ID 2
        storageSkills.deleteSkills(skills1);*/


        //create new companies
        /*companies.setName("Compas");
        storageCompanies.createCompanies(companies);*/

        /*Companies companies2 = storageCompanies.selectCompanies(1L); //update data companies by ID 1
        companies2.setName("Doodle");
        storageCompanies.updateCompanies(companies2);*/

        //find companies by ID 1
        /*System.out.println(storageCompanies.selectCompanies(2L));

        Companies companies3 = storageCompanies.selectCompanies(6L);   //delete companies by ID 2
        storageCompanies.deleteCompanies(companies3);*/

        //create new customer
        /*customers.setName("Client1584");
        storageCustomers.createCustomers(customers);*/

        /*Customers customers2 = storageCustomers.selectCustomers(1L); //update data customer by ID 1
        customers2.setName("New Client");
        storageCustomers.updateCustomers(customers2);*/

        //find customer by ID 1
        System.out.println(storageCustomers.selectCustomers(2L));

        Customers customers3 = storageCustomers.selectCustomers(6L);   //delete customer by ID 2
        storageCustomers.deleteCustomers(customers3);
        }
}
