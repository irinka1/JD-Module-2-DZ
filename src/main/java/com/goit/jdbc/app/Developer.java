package com.goit.jdbc.app;

public class Developer {
    private long id;
    private String Name;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return Name;
    }

    public void setFirstName(String Name) {
        this.Name = Name;
    }



    @Override
    public String toString() {
        return Name;
    }
}
