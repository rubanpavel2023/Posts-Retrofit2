package org.example.app.entity;

public class Post {

    private int userId;
    private int id;
    private String title;
    private String body;

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }


    @Override
    public String toString() {
        return "{\"userId\":" + userId + "," +
                "\"id\":" + id + "," +
                "\"title\":\"" + title + "\"," +
                "\"body\":\"" + body + "\"}";
    }
}

