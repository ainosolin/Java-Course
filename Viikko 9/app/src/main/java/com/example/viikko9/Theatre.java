package com.example.viikko9;

public class Theatre {
    private String name;
    private String id;

    public Theatre(){}

    public Theatre(String name, String id){
        this.name = name;
        this.id = id;
    }
    @Override
    public String toString() {
        return name;
    }
    public String getName(){
        return name;
    }
    public String getId(){
        return id;
    }
}
