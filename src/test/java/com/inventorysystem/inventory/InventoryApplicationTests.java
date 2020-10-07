package com.inventorysystem.inventory;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import com.inventorysystem.inventory.service.IProductService;
import com.inventorysystem.inventory.service.ProductServiceStub;
import com.inventorysystem.inventory.dto.Product;
import com.inventorysystem.inventory.dao.IProductDAO;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class InventoryApplicationTests {
    private IProductService productService;
    private Product productPaperCup = new Product();
    private Product productDairyButter = new Product();

    @MockBean
    private IProductDAO productDAO;

    @Test
    void addPaperCupToCatalogAndConfirm() throws Exception{
        givenProductDataAvailable();
        whenUserCreatesAProductPaperCup();
        thenAddProductPaperCupToCatalogAndConfirm();
    }
    @Test
    void DiscontinueProductDairyButterAndConfirm() throws Exception{
        givenProductDataAvailable();
        whenUserCreatesProductDairyButter();
        whenUserDiscontinuesProductDairyButter();
        thenProductDairyButterNotInCatalog();
    }

    private void givenProductDataAvailable() throws Exception{
        Mockito.when(productDAO.addItem(productPaperCup)).thenReturn(productPaperCup);
        productService = new ProductServiceStub(productDAO);
    }
    private void whenUserCreatesAProductPaperCup(){
        productPaperCup.setProductID(15);
        productPaperCup.setProductName("Paper Cup");
        productPaperCup.setVendorID(25);
        productPaperCup.setQuantity(400);
        productPaperCup.setPrice(2);
        productPaperCup.setProductDesc("Hefty pApER cups");

    }
    private void whenUserCreatesProductDairyButter() throws  Exception{
        productDairyButter.setProductID(17);
        productDairyButter.setProductName("Butter");
        productDairyButter.setVendorID(3);
        productDairyButter.setQuantity(225);
        productDairyButter.setPrice(1);
        productDairyButter.setProductDesc("Dairy Butter");
        productDairyButter = productService.addItem(productDairyButter);
    }
    private void whenUserDiscontinuesProductDairyButter() throws Exception{
      productService.discontinueItem(17);
    }
    private void thenProductDairyButterNotInCatalog() throws Exception{
        assertNull(productDairyButter);
    }
    private void thenAddProductPaperCupToCatalogAndConfirm() throws Exception{
        Product createdProduct = productService.addItem(productPaperCup);
        assertEquals(productPaperCup, createdProduct);
    }

}
