package com.ark_i.b2b.Models;

public class AreaAmModel {

    String countryName;
    String companyName;
    String locationName;

    public AreaAmModel(String countryName, String companyName, String locationName) {
        this.countryName = countryName;
        this.companyName = companyName;
        this.locationName = locationName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
}
