package com.example.demo.endpoint;

import com.example.demo.Dto.PriceDto;
import com.example.demo.Dto.ProductDto;
import com.example.demo.service.ProductInfoClient;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    //@Autowired
    private  ProductInfoClient productInfoClient;

    public ProductController(ProductInfoClient productInfoClient) {
        this.productInfoClient = productInfoClient;
    }

    @RequestMapping(value = "/list" , method = RequestMethod.GET)
    public List<ProductDto> getProductList(){
        try {
            return productService.getProductList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @PostMapping(path = "/save")
    public void saveProduct(@RequestBody ProductDto productDto){
        try {
            productService.saveProduct(productDto);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/getPrice/{sku}" , method = RequestMethod.GET)
    public ProductDto getProductPrice(@PathVariable String sku){
        try {
            ProductDto productDto = productService.findProduct(sku);
            PriceDto priceDto =  productInfoClient.getProductPrice(sku);
            productDto.setListPrice(priceDto.getListPrice());
            productDto.setSalePrice(priceDto.getSalePrice());

            return productDto;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
