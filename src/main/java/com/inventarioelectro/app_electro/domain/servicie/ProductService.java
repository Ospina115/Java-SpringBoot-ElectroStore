package com.inventarioelectro.app_electro.domain.servicie;

import java.util.List;
import java.util.stream.Collectors;


import com.inventarioelectro.app_electro.domain.entity.Product;
import com.inventarioelectro.app_electro.infrastructure.repositories.ProductRepository;

public class ProductService{
    
    private ProductRepository repositoryProduct = new ProductRepository();

    public List<Product> findAll() {
        return repositoryProduct.findAll().stream().map(p -> {
            Double priceImp = p.getPrice() * 1.45d;
            p.setPrice(priceImp.longValue());
            return p;
        }).collect(Collectors.toList());
    }

    public Product findById(Long id) {
        return repositoryProduct.findById(id);
    }
}
