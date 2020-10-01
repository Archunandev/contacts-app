package com.example.splash;

public class Electriuser {

    private String locatione;
    private String namee;
    private String phonee;
    private String sendsmse;
    private String sendwhatsappe;
    private String photoe;

    public Electriuser(String locatione, String namee, String phonee, String sendsmse,String sendwhatsappe, String photoe) {
        this.locatione = locatione;
        this.namee = namee;
        this.phonee = phonee;
        this.sendsmse = sendsmse;
        this.sendwhatsappe = sendwhatsappe;
        this.photoe = photoe;
    }

    public Electriuser() {

    }

    public String getLocatione() {
        return locatione;
    }

    public void setLocatione(String locatione) {
        this.locatione = locatione;
    }

    public String getNamee() {
        return namee;
    }

    public void setNamee(String namee) {
        this.namee = namee;
    }

    public String getPhonee() {
        return phonee;
    }

    public void setPhonee(String phonee) {
        this.phonee = phonee;
    }

    public String getSendsmse() {
        return sendsmse;
    }

    public void setSendsmse(String sendsmse) {
        this.sendsmse = sendsmse;
    }

    public String getSendwhatsappe() {
        return sendwhatsappe;
    }

    public void setSendwhatsappe(String sendwhatsappe) {
        this.sendwhatsappe = sendwhatsappe;
    }

    public String getPhotoe() {
        return photoe;
    }

    public void setPhotoe(String photoe) {
        this.photoe = photoe;
    }
}