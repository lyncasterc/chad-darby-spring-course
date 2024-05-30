package com.love2code.thymeleafdemo.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public class Student {

    @NotNull(message = "First name is required.")
    @Size(min = 1, message = "First name must be at least one character.")
    private String firstName;

    @NotNull(message = "Last name is required")
    @Size(min = 1, message = "Last name must be at least one character.")
    private String lastName;

    @NotNull(message = "Country is required")
    private String country;

    private List<String> favoriteSystems;

    private String favoriteLanguage;

    public List<String> getFavoriteSystems() {
        return favoriteSystems;
    }

    public void setFavoriteSystems(List<String> favoriteSystems) {
        this.favoriteSystems = favoriteSystems;
    }


    public String getFavoriteLanguage() {
        return favoriteLanguage;
    }

    public void setFavoriteLanguage(String favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;
    }


    public Student() {
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
