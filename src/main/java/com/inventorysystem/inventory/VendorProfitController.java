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
     * @return
     */
    @RequestMapping("/")
    public String index(Model model) {
        Product product = new Product();
        product.setProudctID(1);
        product.setProductName("Peanut Butter");
        product.setVendorID(10);
        product.setProductDesc("pretty good peanut butter");
        product.setPrice(1.90);
        product.setQuantity(250);
        model.addAttribute(product);

        return "start";
    }
    @RequestMapping("/addProduct")
    public String addProduct(Product product){
        try{
            productService.addItem(product);
        } catch (Exception e){
            e.printStackTrace();
            return "start";
        }
        return "start";
    }
    @GetMapping("/product")
    @ResponseBody
    public List<Product> fetchAllProducts(){
        return productService.displayProducts();
    }

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
