package com.inventorysystem.inventory.dto;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public @Data
class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SerializedName("ProductID")
    private int productID;
    @SerializedName("ProductName")
    private String productName;
    @SerializedName("ProductDesc")
    private String productDesc;
    @SerializedName("VendorID")
    private int vendorID;
    @SerializedName("Price")
    private double price;
    @SerializedName("Quantity")
    private int quantity;
}
