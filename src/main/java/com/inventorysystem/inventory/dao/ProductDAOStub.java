package com.inventorysystem.inventory.dao;
import com.inventorysystem.inventory.dto.Product;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/** Data Access Object Stub Class for Products.
 *
 */

@Repository
public class ProductDAOStub implements IProductDAO {
    Map<Integer, Product> allProudcts = new HashMap<>();

    /**
     * Adds products to a list
     * @param product Product Object
     * @return product
     * @throws Exception
     */
    @Override
    public Product addItem(Product product) throws Exception {
        Integer productSKU = product.getProductSKU();
        allProudcts.put(productSKU, product);
        return product;
    }

    /**
     * Displays all Products in the list.
     * @return
     */
    @Override
    public List<Product> displayProducts() {
        List<Product> returnProducts = new ArrayList(allProudcts.values());
        return returnProducts;
    }

    /**
     * Discontinues a product based on ProductSKU.
     * @param sku
     * @throws Exception
     */
    @Override
    public void discontinueItem(int sku) throws Exception {
        allProudcts.remove(sku);

    }
}
