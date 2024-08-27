package com.ark_i.b2b.Models;

public class ModelClassForAreaList {
    ModelClassForAreaList(){}


    public ModelClassForAreaList(String countryadress, String branchaddress, String locationaddress) {
        this.countryadress = countryadress;
        this.branchaddress = branchaddress;
        this.locationaddress = locationaddress;
    }

    public String getCountryadress() {
        return countryadress;
    }

    public void setCountryadress(String countryadress) {
        this.countryadress = countryadress;
    }

    public String getBranchaddress() {
        return branchaddress;
    }

    public void setBranchaddress(String branchaddress) {
        this.branchaddress = branchaddress;
    }

    public String getLocationaddress() {
        return locationaddress;
    }

    public void setLocationaddress(String locationaddress) {
        this.locationaddress = locationaddress;
    }

    String countryadress;
    String branchaddress;
    String locationaddress;
}
