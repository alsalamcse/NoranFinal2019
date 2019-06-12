package com.example.noranow.noranfinal2019.data;

public class Doctor {
    private String name;
    private String id;
    private String license;
    private String key;
    private String email;

    public Doctor()
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

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
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
                ", license='" + license + '\'' +
                ", id='" + id + '\'' +
                ", email=" + email +
                '}';

    }


}


