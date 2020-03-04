package com.example.project;

public class Post {
    String event;
    String date;
    String price;

    public Post() {
    }

    public Post(String event, String date, String price) {
        this.event = event;
        this.date = date;
        this.price = price;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
