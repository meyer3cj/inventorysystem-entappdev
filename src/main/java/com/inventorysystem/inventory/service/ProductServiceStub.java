package com.inventorysystem.inventory.service;
import com.inventorysystem.inventory.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.inventorysystem.inventory.dao.IProductDAO;

@Service
public class ProductServiceStub implements IProductService {

    @Autowired
    private IProductDAO productDAO;

    public ProductServiceStub(){

    }
    public ProductServiceStub(IProductDAO productDAO){
        this.productDAO = productDAO;
    }

    @Override
    public Product addItem(Product product) throws Exception {
        return productDAO.addItem(product);
    }

    @Override
    public List<Product> displayProducts() {

        return productDAO.displayProducts();
    }

    @Override
    public void discontinueItem(int id) throws Exception {
        productDAO.discontinueItem(id);

    }
}
