package com.example.demo.service;

import com.example.demo.Dto.ProductDto;
import com.example.demo.data.ProductData;
import com.example.demo.impl.ProductImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductData productData;

    public List<ProductDto> getProductList() {
        List<ProductImpl> productList = productData.getAllProduct();
        return productList.stream().map((p) -> new ProductDto(p.getName(), p.getSku(), p.getCatalog())).collect(Collectors.toList());
    }

    public void saveProduct(ProductDto productDto) {
        ProductImpl product = new ProductImpl();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setSku(productDto.getSku());
        product.setCatalog(productDto.getCatalog());
        productData.saveProduct(product);
    }

    public ProductDto findProduct(String sku) {
        ProductImpl product = productData.findProduct(sku);
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setSku(product.getSku());
        productDto.setCatalog(product.getCatalog());

        return productDto;
    }
}
