package com.inventorysystem.inventory.dao;

import com.inventorysystem.inventory.dto.Product;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface IProductRetrofitDAO {
    // you will need to have some sort of resting API running to hit this
    @GET("link here")
    Call<List<Product>> getProducts(@Query("Combined_Name") String combinedName);
}
