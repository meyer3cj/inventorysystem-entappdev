package com.inventorysystem.inventory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.inventorysystem.inventory.dto.Product;
import com.inventorysystem.inventory.service.IProductService;

import javax.swing.event.HyperlinkEvent;
import java.util.List;

@Controller
public class VendorProfitController {
    @Autowired
    IProductService productService;

    Logger log = LoggerFactory.getLogger(this.getClass());

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
     * @return main.html or error.html if something goes wrong.
     */
    @RequestMapping("/addProduct")
    public String addProduct(Product product){
        log.debug("Entering the add product endpoint");
        try{
            productService.addItem(product);
            log.info ("Product  " + product.getProductName() + " was added");
        } catch (Exception e){
            log.error("Unable to add product " + product.getProductName() + ", message: " + e.getMessage(), e);
            return "error";
        }
        return "main";
    }

    /** GetMapping for /product endpoint
     * @return all products entered.
     */
    @GetMapping("/product")
    @ResponseBody
    public List<Product> fetchAllProducts(){

        return productService.displayProducts();
    }

    /**
     * Create a new product object, given the data provided.
     *
     * returns one of the following status codes:
     * 201: successfully created a new product.
     * 409: unable to create a product, because it already exists.
     *
     * @param product a JSON representation of a product object.
     * @return the newly created product object.
     */
    @PostMapping(value="/product", consumes="application/json", produces="application/json")
    public ResponseEntity createProduct(@RequestBody Product product) {
        Product newProduct = null;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        try {
            newProduct = productService.addItem(product);
        } catch (Exception e) {

            return new ResponseEntity(headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(newProduct, headers, HttpStatus.OK);
    }


    /**
     * DeleteMapping for product/{id} endpoint
     * @param id ID for deletion
     * @return HTTP Status Code
     */
    @DeleteMapping("product/{id}")
    public ResponseEntity discontinueProduct(@PathVariable("id") int id){
        log.debug("Entering the discontinue product endpoint");
        try{
            productService.discontinueItem(id);
            log.info("Product with the ID of " + id + " was discontinued");
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e){
            log.error("Unable to delete product with ID of " + id + " , message: " + e.getMessage(), e);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Handle the profits endpoint and return the page.
     * @return profits.html
     */
    @RequestMapping("/profits")
    public String profits() {

        return "profits";
    }

    /**
     * Handle the purchases endpoint and return the page.
     * @return purchases.html
     */
    @RequestMapping("/purchases")
    public String purchases() {

        return "purchases";
    }
}
