package com.br.mymovies1.model;

public class Movie {

    private String title;
    private String type;
    private String year;

    public Movie (String title,String type, String year){
        this.title = title;
        this.type = type;
        this.year =year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
