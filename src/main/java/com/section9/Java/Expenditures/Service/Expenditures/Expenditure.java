package com.section9.Java.Expenditures.Service.Expenditures;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.section9.Java.Expenditures.Service.user.User;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Expenditure {
    public Expenditure() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Expenditure(String title, String description, Double price, LocalDate localDate, Integer userID) {

        this.title = title;
        this.description = description;
        this.price = price;
        this.localDate = localDate;
        this.userId = userID;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    private Double price;
    private LocalDate localDate;

    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }


}
