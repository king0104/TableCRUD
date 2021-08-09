package com.example.tablecrud.entity;

public class SearchParamVO {

    private String username;
    private String email;
    private int page;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "SearchParamVO{"
                + "username='"
                + username
                + '\''
                + ", email='"
                + email
                + '\''
                + ", page="
                + page
                + '}';
    }
}

