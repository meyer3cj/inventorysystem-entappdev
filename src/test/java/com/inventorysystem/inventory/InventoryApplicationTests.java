package com.inventorysystem.inventory;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import com.inventorysystem.inventory.service.IProductService;
import com.inventorysystem.inventory.service.ProductServiceStub;
import com.inventorysystem.inventory.dto.Product;
import com.inventorysystem.inventory.dao.IProductDAO;
import com.inventorysystem.inventory.dao.ProductDAOStub;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.inventorysystem.inventory.dao.ProductDAOStub;
@SpringBootTest
class InventoryApplicationTests {
    private IProductService productService;
    private Product product = new Product();
    private Product product2 = new Product();

    @MockBean
    private IProductDAO productDAO;

    @Test
    void contextLoads() {
    }

    @Test
    void addPaperCupAndReturnIt() throws Exception{
        givenProductDataAvailable();
        whenUserCreatesAProduct();
        thenAddProductAndReturn();
    }
    @Test
    void DiscontinueAProduct() throws Exception{
        givenProductDataAvailable();
        whenUserCreatesAProduct2();
        whenUserDiscontinueProduct();
        thenUserDiscontinueProduct();
    }

    private void givenProductDataAvailable() throws Exception{
        Mockito.when(productDAO.addItem(product)).thenReturn(product);
        productService = new ProductServiceStub(productDAO);
    }
    private void whenUserCreatesAProduct(){
        product.setProductID(15);
        product.setProductName("Paper Cup");
        product.setVendorID(25);
        product.setQuantity(400);
        product.setPrice(2);
        product.setProductDesc("Hefty pApER cups");

    }
    private void whenUserCreatesAProduct2() throws  Exception{
        product2.setProductID(17);
        product2.setProductName("Butter");
        product2.setVendorID(3);
        product2.setQuantity(225);
        product2.setPrice(1);
        product2.setProductDesc("Dairy Butter");
        product2 = productService.addItem(product2);
    }
    private void whenUserDiscontinueProduct() throws Exception{
      productService.discontinueItem(17);
    }
    private void thenUserDiscontinueProduct() throws Exception{
        assertEquals(null, product2);
    }
    private void thenAddProductAndReturn() throws Exception{
        Product createdProduct = productService.addItem(product);
        assertEquals(product, createdProduct);
    }

}
