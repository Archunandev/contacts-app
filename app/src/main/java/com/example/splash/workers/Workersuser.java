package com.example.splash.workers;

public class Workersuser {

    private String location;
    private String name;
    private String phone;
    private String sendsms;
    private String sendwhatsapp;
    private String map;
    private String rank;
    private String since;
    private String age;
    private String exp;
    private String received;
    private String photo;

    public Workersuser(String location, String name, String phone, String sendsms, String sendwhatsapp, String map, String rank, String since, String age, String exp, String received, String photo) {
        this.location = location;
        this.name = name;
        this.phone = phone;
        this.sendsms = sendsms;
        this.sendwhatsapp = sendwhatsapp;
        this.map = map;
        this.rank = rank;
        this.since = since;
        this.age = age;
        this.exp = exp;
        this.received = received;
        this.photo = photo;
    }
    public Workersuser() {

    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSendsms() {
        return sendsms;
    }

    public void setSendsms(String sendsms) {
        this.sendsms = sendsms;
    }

    public String getSendwhatsapp() {
        return sendwhatsapp;
    }

    public void setSendwhatsapp(String sendwhatsapp) {
        this.sendwhatsapp = sendwhatsapp;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSince() {
        return since;
    }

    public void setSince(String since) {
        this.since = since;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public String getReceived() {
        return received;
    }

    public void setReceived(String received) {
        this.received = received;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
