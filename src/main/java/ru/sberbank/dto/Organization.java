package ru.sberbank.dto;

public class Organization {
    private final String name;
    private final String id;

    public Organization(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public Organization(){
        this.name = null;
        this.id = null;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "{Organization " +
                "firstName='" + name + '\'' +
                ", last_name='" + id + '\'' +
                '}';
    }
}
