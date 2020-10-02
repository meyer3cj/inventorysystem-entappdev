package com.inventorysystem.inventory.service;
import com.inventorysystem.inventory.dto.Product;
import java.util.List;

public interface IProductService {

    Product addItem(Product product) throws Exception;

    List<Product> displayProducts();

    void discontinueItem(int id) throws Exception;


}
