package com.example.demo.repository;

import com.example.demo.impl.ProductImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<ProductImpl ,Long> {


        @Query(value= "select * from product p where p.sku =:sku",nativeQuery = true)
        public ProductImpl findProduct(@Param("sku") String sku);

}
