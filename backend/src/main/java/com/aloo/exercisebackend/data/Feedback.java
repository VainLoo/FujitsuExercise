package com.aloo.exercisebackend.data;

import org.springframework.data.annotation.Id;

public class Feedback {

    @Id
    private String id;

    private String name;
    private String email;
    private String[] category;
    private String text;

    public Feedback(String name, String email, String[] category, String text) {
        this.name = name;
        this.email = email;
        this.category = category;
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String[] getCategory() {
        return category;
    }

    public String getText() {
        return text;
    }
}
