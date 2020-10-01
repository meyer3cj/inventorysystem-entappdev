package com.inventorysystem.inventory;

import org.springframework.web.bind.annotation.RequestMapping;

public class VendorProfitController {

    /**
     * Handle the / endpoint
     * @return
     */
    @RequestMapping("/")
    public String index() {
        return "start";
    }
}
