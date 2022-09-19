package com.damian.testibm.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class SupplierModel {

    private int id;

    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date addDate;

    private String cif;

    private String logo;

    private int stars;

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

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    @Override
    public String toString() {
        return "SupplierModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", addDate=" + addDate +
                ", cif='" + cif + '\'' +
                ", logo='" + logo + '\'' +
                ", stars=" + stars +
                '}';
    }
}
