package com.goit.jdbc.app;

import java.math.BigDecimal;

public class Project {

    private long id;
    private String Name;
    private BigDecimal Cost;

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



    public BigDecimal getCost() {
        return Cost;
    }

    public void setCost(BigDecimal Cost) {
        this.Cost = Cost;
    }

    @Override
    public String toString() {
        return Name + ", " + Cost;
    }
}
