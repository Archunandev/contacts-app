package com.example.splash;

public class Mechanicuser {

    private String locationm;
    private String namem;
    private String phonem;
    private String sendsmsm;
    private String sendwhatsappm;
    private String photom;

    public Mechanicuser(String locationm, String namem, String phonem,String sendsmsm, String sendwhatsappm, String photom) {
        this.locationm = locationm;
        this.namem = namem;
        this.phonem = phonem;
        this.sendsmsm = sendsmsm;
        this.sendwhatsappm = sendwhatsappm;
        this.photom = photom;
    }

    public Mechanicuser() {
    }

    public String getLocationm() {
        return locationm;
    }

    public void setLocationm(String locationm) {
        this.locationm = locationm;
    }

    public String getNamem() {
        return namem;
    }

    public void setNamem(String namem) {
        this.namem = namem;
    }

    public String getPhonem() {
        return phonem;
    }

    public void setPhonem(String phonem) {
        this.phonem = phonem;
    }

    public String getSendsmsm() {
        return sendsmsm;
    }

    public void setSendsmsm(String sendsmsm) {
        this.sendsmsm = sendsmsm; }

    public String getSendwhatsappm() {
        return sendwhatsappm;
    }

    public void setSendwhatsappm(String sendwhatsappm) {
        this.sendwhatsappm = sendwhatsappm;
    }

    public String getPhotom() {
        return photom;
    }

    public void setPhotom(String photom) {
        this.photom = photom;
    }
}
