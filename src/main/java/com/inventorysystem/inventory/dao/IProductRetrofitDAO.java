package com.inventorysystem.inventory.dao;

import com.inventorysystem.inventory.dto.Product;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface IProductRetrofitDAO {
    @GET()
    List<Product> getProducts(@Query("ProductName") String Product);

}
