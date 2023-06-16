package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class Category extends AbstractModel{
    private String name;
    List<Advertise> listAdvertise = new ArrayList<Advertise>();

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
