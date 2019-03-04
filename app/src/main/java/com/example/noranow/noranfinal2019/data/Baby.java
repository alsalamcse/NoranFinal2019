package com.example.noranow.noranfinal2019.data;

import java.util.Date;

public class Baby {
    private String name;// key: unique id for each object. have to be....
    private String weight;
    private String lenght;
    private Date date;
    private String owner;

    public Baby()
    {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getLenght() {
        return lenght;
    }

    public void setLenght(String lenght) {
        this.lenght = lenght;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    @Override
    public String toString() {
        return "MyTask{" +
                "name='" + name+ '\'' +
                ", weight='" + weight + '\'' +
                ", length='" + lenght + '\'' +
                ", date=" + date +
                '}';
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}




