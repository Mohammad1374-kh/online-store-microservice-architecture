package com.mohammad.productservice.controller;

import com.mohammad.productservice.dto.ProductRequest;
import com.mohammad.productservice.dto.ProductResponse;
import com.mohammad.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

/*----------------Creating a new product in DB-------------------------------------*/

    @PostMapping("/add-product")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct (@RequestBody ProductRequest productRequest){

        productService.createProduct(productRequest);
    }

/*----------------Reading all products from data base------------------------------*/

    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts(){
        return productService.getAllProducts();
    }
}
