package com.mohammad.productservice.service;

import com.mohammad.productservice.dto.ProductRequest;
import com.mohammad.productservice.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    void createProduct(ProductRequest productRequest);

    List<ProductResponse> getAllProducts();
}
