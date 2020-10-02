package com.inventorysystem.inventory.dao;
import com.inventorysystem.inventory.dto.Product;
import java.util.List;

public interface IProductDAO {
    Product addItem(Product product) throws Exception;

    List<Product> displayProducts();

    void discontinueItem(int id) throws Exception;

}
