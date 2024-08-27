package com.ark_i.b2b.Models;

public class ModelClassForBranchList {
    ModelClassForBranchList(){}

    public ModelClassForBranchList(String branchaddress, String locationaddress) {
        this.branchaddress = branchaddress;
        this.locationaddress = locationaddress;
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

    String branchaddress;
    String locationaddress;

}
