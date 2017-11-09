package com.goit.jdbc.app;

public class Companies {



    private long id;
    private String Name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }


    @Override
    public String toString() {
        return Name;
    }
}
