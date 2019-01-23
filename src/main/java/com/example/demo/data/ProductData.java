package com.example.demo.data;

import com.example.demo.impl.ProductImpl;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ProductData {

    @Autowired
    private ProductRepository productRepository;



    public void saveProduct(ProductImpl product){
        productRepository.save(product);

    }

    public ProductImpl getProduct(long id){
       return productRepository.findById(id).get();
    }

    public List<ProductImpl> getAllProduct(){
        return productRepository.findAll();
    }

    public ProductImpl findProduct(String sku){
       return productRepository.findProduct(sku);
    }
}
