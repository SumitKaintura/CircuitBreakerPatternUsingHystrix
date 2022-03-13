package com.niit.MongoDbExample.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="CustomerMovieDB1")
public class Customer {

    public Customer() {}
    @Id
    private int id;
    private String username;
    private String password;
    private String phoneNo;
    private Movie movieList;

    public Customer(int id, String username, String password, String phoneNo, Movie movieList) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phoneNo = phoneNo;
        this.movieList = movieList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public Movie getMovieList() {
        return movieList;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setMovieList(Movie movieList) {
        this.movieList = movieList;
    }
}
