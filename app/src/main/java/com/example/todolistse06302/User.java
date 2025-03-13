package com.example.todolistse06302;

public class User {
    private int Id;
    private String password;

    private String email;
    public User(int id,String email,String password){
        this.Id=id;
        this.email=email;
        this.password=password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }




}
