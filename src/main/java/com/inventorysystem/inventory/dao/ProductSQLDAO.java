package com.inventorysystem.inventory.dao;

import com.inventorysystem.inventory.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ProductDAO")
public class ProductSQLDAO implements IProductDAO{
    @Autowired
    ProductRepository productRepository;

    @Override
    public Product addItem(Product product) throws Exception {
      Product createdProduct = productRepository.save(product);
        return createdProduct;
    }

    @Override
    public List<Product> displayProducts() {
        return null;
    }

    @Override
    public void discontinueItem(int id) throws Exception {

    }
}
