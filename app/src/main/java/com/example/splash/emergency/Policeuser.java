package com.example.splash.emergency;

public class Policeuser {

    private String locationp;
    private String namep;
    private String phonep;
    private String landlinep;
    private String sendsmsp;
    private String sendwhatsappp;
    private String photop;

    public Policeuser(String locationp, String namep, String phonep, String landlinep, String sendsmsp, String sendwhatsappp, String photop) {
        this.locationp = locationp;
        this.namep = namep;
        this.phonep = phonep;
        this.landlinep = landlinep;
        this.sendsmsp = sendsmsp;
        this.sendwhatsappp = sendwhatsappp;
        this.photop = photop;
    }

    public Policeuser(){

    }

    public String getLocationp() {
        return locationp;
    }

    public void setLocationp(String locationp) {
        this.locationp = locationp;
    }

    public String getNamep() {
        return namep;
    }

    public void setNamep(String namep) {
        this.namep = namep;
    }

    public String getPhonep() {
        return phonep;
    }

    public void setPhonep(String phonep) {
        this.phonep = phonep;
    }

    public String getLandlinep() {
        return landlinep;
    }

    public void setLandlinep(String landlinep) {
        this.landlinep = landlinep;
    }

    public String getSendsmsp() {
        return sendsmsp;
    }

    public void setSendsmsp(String sendsmsp) {
        this.sendsmsp = sendsmsp;
    }

    public String getSendwhatsappp() {
        return sendwhatsappp;
    }

    public void setSendwhatsappp(String sendwhatsappp) {
        this.sendwhatsappp = sendwhatsappp;
    }

    public String getPhotop() {
        return photop;
    }

    public void setPhotop(String photop) {
        this.photop = photop;
    }
}
