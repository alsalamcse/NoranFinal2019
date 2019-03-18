package com.example.noranow.noranfinal2019.data;

public class Parent {
    private String name;
    private String email;
    private String id;
    private String phone;
    private String key;

    public Parent()
    {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }



    @Override
    public String toString() {
        return "MyTask{" +
                "name='" + name+ '\'' +
                ", phone='" + phone + '\'' +
                ", id='" + id + '\'' +
                ", email=" + email +
                '}';
    }


}

