package com.inventorysystem.inventory.dto;

import lombok.Data;

public @Data
class Vendor {
    private int vendorID;
    private String vendorName;
    private String address;
    private String city;
    private String state;
    private int zipCode;
    private String phoneNumber;

}
