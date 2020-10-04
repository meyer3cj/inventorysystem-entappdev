package com.inventorysystem.inventory.dao;
import com.inventorysystem.inventory.dto.Product;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ProductDAOStub implements IProductDAO {
    Map<Integer, Product> allProudcts = new HashMap<>();

    @Override
    public Product addItem(Product product) throws Exception {
        Integer productID = product.getProductID();
        allProudcts.put(productID, product);
        return product;
    }

    @Override
    public List<Product> displayProducts() {
        List<Product> returnProducts = new ArrayList(allProudcts.values());
        return returnProducts;
    }

    @Override
    public void discontinueItem(int id) throws Exception {
        allProudcts.remove(id);

    }
}
