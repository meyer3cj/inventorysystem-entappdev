package com.inventorysystem.inventory.dto;
import lombok.Data;

public @Data
class Product {
    private int ProductSKU;
    private String ProductName;
    private String ProductDesc;
    private int VendorID;
    private double Price;
    private int Quantity;
}
