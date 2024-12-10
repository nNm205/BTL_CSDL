package com.example.demo;

public class Account {
    private int accountID;
    private String username;
    private String password;
    private String email;

    public Account() {

    }

    public Account(int accountID, String username, String password, String email) {
        this.accountID = accountID;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public void setId(int accountID) {
        this.accountID = accountID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAccountID() {
        return accountID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
