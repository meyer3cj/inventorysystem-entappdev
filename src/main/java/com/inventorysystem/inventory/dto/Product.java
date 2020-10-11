package com.inventorysystem.inventory.dto;
import lombok.Data;

public @Data
class Product {
    private int productID;
    private String productName;
    private String productDesc;
    private int vendorID;
    private double price;
    private int quantity;
}
