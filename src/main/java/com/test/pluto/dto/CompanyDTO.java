package com.test.pluto.dto;




public class CompanyDTO {

    private int id;
    private String name;
    private  String description;
    private String slogan;
    private byte remove;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public byte getRemove() {
        return remove;
    }

    public void setRemove(byte remove) {
        this.remove = remove;
    }
}
