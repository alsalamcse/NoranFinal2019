package com.example.noranow.noranfinal2019.data;

import java.util.Date;

public class Baby {
    private String key;
    private String name;// key: unique id for each object. have to be....
    private String weight;
    private String lenght;
    private long date;
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

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getOwner() {
        return owner;
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




