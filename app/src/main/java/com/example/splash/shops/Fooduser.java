package com.example.splash.shops;

public class Fooduser {

    private String aboutf;
    private String locationf;
    private String namef;
    private String phonef;
    private String sendsmsf;
    private String sendwhatsappf;
    private String photof;
    private String gpsf;

    public Fooduser(String aboutf, String locationf, String namef, String phonef, String sendsmsf, String sendwhatsappf, String photof,String gpsf) {
        this.aboutf = aboutf;
        this.locationf = locationf;
        this.namef = namef;
        this.phonef = phonef;
        this.sendsmsf = sendsmsf;
        this.sendwhatsappf = sendwhatsappf;
        this.photof = photof;
        this.gpsf = gpsf;
    }

    public Fooduser() {


    }

    public String getAboutf() {
        return aboutf;
    }

    public void setAboutf(String aboutf) {
        this.aboutf = aboutf;
    }

    public String getLocationf() {
        return locationf;
    }

    public void setLocationf(String locationf) {
        this.locationf = locationf;
    }

    public String getNamef() {
        return namef;
    }

    public void setNamef(String namef) {
        this.namef = namef;
    }

    public String getPhonef() {
        return phonef;
    }

    public void setPhonef(String phonef) {
        this.phonef = phonef;
    }

    public String getSendsmsf() {
        return sendsmsf;
    }

    public void setSendsmsf(String sendsmsf) {
        this.sendsmsf = sendsmsf;
    }

    public String getSendwhatsappf() {
        return sendwhatsappf;
    }

    public void setSendwhatsappf(String sendwhatsappf) {
        this.sendwhatsappf = sendwhatsappf;
    }

    public String getPhotof() {
        return photof;
    }

    public void setPhotof(String photof) {
        this.photof = photof;
    }

    public String getGpsf() {
        return gpsf;
    }

    public void setGpsf(String gpsf) {
        this.gpsf = gpsf;
    }
}
