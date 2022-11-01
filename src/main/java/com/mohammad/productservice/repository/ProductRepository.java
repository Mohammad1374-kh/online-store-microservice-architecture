package com.mohammad.productservice.repository;

import com.mohammad.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@org.springframework.stereotype.Repository
public interface ProductRepository extends MongoRepository<Product,String> {

}
