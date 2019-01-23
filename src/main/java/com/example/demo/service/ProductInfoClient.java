package com.example.demo.service;

import com.example.demo.Dto.PriceDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "price-service", fallback = ProductInfoClientImpl.class)
public interface ProductInfoClient {

    @RequestMapping(value = "/price/getPrice/{sku}", method = RequestMethod.GET)
    public PriceDto getProductPrice(@PathVariable(value="sku") String sku);



}
@Component
class ProductInfoClientImpl implements ProductInfoClient{
    @Override
    public PriceDto getProductPrice(String sku) {
        return new PriceDto(0,"NO SKU",8500,700);
    }
}