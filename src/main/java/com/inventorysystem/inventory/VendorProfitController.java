package com.inventorysystem.inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.inventorysystem.inventory.dto.Product;
import com.inventorysystem.inventory.service.IProductService;

import java.util.List;

@Controller
public class VendorProfitController {

    @Autowired
    IProductService productService;

    /**
     * Handle the / endpoint
     * @return main.html
     */
    @RequestMapping("/")
    public String start(Model model) {
       Product product = new Product();
       product.setProductID(1);
       product.setProductName("Peanut butter");
       product.setVendorID(12);
       product.setProductDesc("good Peanuts");
       product.setPrice(1);
       product.setQuantity(300);
       model.addAttribute(product);

       return "main";
    }

    /**
     * handles /addProduct endpoint
     * @param product Product
     * @return main.html
     */
    @RequestMapping("/addProduct")
    public String addProduct(Product product){
        try{
            productService.addItem(product);
        } catch (Exception e){
            e.printStackTrace();
            return "main";
        }
        return "main";
    }

     /** GetMapping for /view-products endpoint
     * @return all products entered.
     */

     @RequestMapping("/view-inventory")

     public String viewInventory(){
         return "view-inventory";
     }

    @ResponseBody
    public List<Product> fetchAllProducts(){
        return productService.displayProducts();
    }

    /**
     * PostMApping for /product endpoint
     * @param product product
     * @return Product entered
     */
    @PostMapping(value="/product", consumes="application/json", produces="application/json")
    @ResponseBody
    public Product createProduct(@RequestBody Product product){
        Product newProduct = null;
        try {
            newProduct = productService.addItem(product);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return newProduct;
    }

    /**
     * DeleteMapping for product/{id} endpoint
     * @param id ID for deletion
     * @return HTTP Status Code
     */
    @DeleteMapping("product/{id}")
    public ResponseEntity discontinueProduct(@PathVariable("id") int id){
        try{
            productService.discontinueItem(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
