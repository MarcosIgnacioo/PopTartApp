package com.oreopooptarts.poptartmarket.web.controller;

import com.oreopooptarts.poptartmarket.domain.Product;
import com.oreopooptarts.poptartmarket.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
// En que path va a aceptar las peticiones que le hagamos

public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/all")
    public List<Product> getAll(){
        return productService.getAll();
    }
    @GetMapping("/{productId}")
    public Optional<Product> getProductById(@PathVariable("productId") long productId){
        return productService.getProduct(productId);
    }
    @GetMapping("/category/{categoryId}")
    private Optional<List<Product>> getByCategoryId(@PathVariable("categoryId") long categoryId){
        return productService.getByCategory(categoryId);
    }
    @PostMapping("/save")
    private Product saveProduct(@RequestBody Product product){
        return productService.save(product);
    }
    @DeleteMapping("/delete/{productId}")
    private boolean deleteProductById(@PathVariable("productId") long productId){
        return productService.delete(productId);
    }
}
