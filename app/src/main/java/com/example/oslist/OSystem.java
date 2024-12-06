package com.example.oslist;

public class OSystem {
    Integer logo;
    String osys;
    String plateforme;

    public OSystem(Integer logo, String osys, String plateforme) {
        this.logo = logo;
        this.osys = osys;
        this.plateforme = plateforme;
    }

    public Integer getLogo() {
        return logo;
    }

    public void setLogo(Integer logo) {
        this.logo = logo;
    }

    public String getOsys() {
        return osys;
    }

    public void setOsys(String osys) {
        this.osys = osys;
    }

    public String getPlateforme() {
        return plateforme;
    }

    public void setPlateforme(String plateforme) {
        this.plateforme = plateforme;
    }
}
