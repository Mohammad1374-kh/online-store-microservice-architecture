package com.mohammad.productservice.service;

import com.mohammad.productservice.dto.ProductRequest;
import com.mohammad.productservice.dto.ProductResponse;
import com.mohammad.productservice.model.Product;
import com.mohammad.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;


    @Override
    public void createProduct(ProductRequest productRequest) {

        Product product = Product.builder().name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice()).build();

        productRepository.save(product);
        log.info("The product {} is saved",product.getId());
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        List<Product> products =productRepository.findAll();
        return products.stream().map(this:: mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice()).build();
    }
}
