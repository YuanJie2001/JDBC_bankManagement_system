package com.MyBank.pojo;


public class Administrator {
    private String  Aname;
    private String  Acord;

    public String getAname() {
        return Aname;
    }
    public void setAname(String aname) {
        Aname = aname;
    }
    public String getAcord() {
        return Acord;
    }
    public void setAcord(String acord) {
        Acord = acord;
    }
    public Administrator() {
    }
    @Override
    public String toString() {
        return "Administrator{" +
                "Aname='" + Aname + '\'' +
                ", Acord='" + Acord + '\'' +
                '}';
    }
}
