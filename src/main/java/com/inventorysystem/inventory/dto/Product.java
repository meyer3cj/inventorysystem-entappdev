package com.inventorysystem.inventory.dto;
import lombok.Data;

public @Data
class Product {
    private int ProudctID;
    private String ProductName;
    private String ProductDesc;
    private int VendorID;
    private double Price;
}
