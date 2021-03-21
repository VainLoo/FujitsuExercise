package com.aloo.exercisebackend.data;

import org.springframework.data.annotation.Id;

/**
 * Represents a feedback entry in the database.
 */
public class Feedback {

    @Id
    private String id;

    private final String name;
    private final String email;
    private final String[] category;
    private final String text;

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
