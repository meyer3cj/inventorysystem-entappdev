package com.inventorysystem.inventory.dao;
import com.inventorysystem.inventory.dto.Product;

import java.io.IOException;
import java.util.List;

/**
 * Data Access Object Interface for ProductDAO
 */
public interface IProductDAO {
    Product addItem(Product product) throws Exception;

    List<Product> displayProducts();

    List<Product> getProducts(String combinedName) throws Exception;

    void discontinueItem(int id) throws Exception;
}
