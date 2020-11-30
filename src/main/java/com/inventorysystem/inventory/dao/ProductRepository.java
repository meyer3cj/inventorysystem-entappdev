package com.inventorysystem.inventory.dao;

import com.inventorysystem.inventory.dto.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
