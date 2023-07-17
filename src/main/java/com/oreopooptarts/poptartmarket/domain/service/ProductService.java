package com.oreopooptarts.poptartmarket.domain.service;

import com.oreopooptarts.poptartmarket.domain.Product;
import com.oreopooptarts.poptartmarket.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service()
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    /*Aqui estamos metiendo la interfaz*/
    public List<Product> getAll(){
        return productRepository.getAll();
    }
    public Optional<Product> getProduct(long id){
        return productRepository.getProduct(id);
    }
    public Optional<List<Product>> getByCategory(long categoryId){
        return productRepository.getByCategory(categoryId);
    }
    public Product save(Product product){
        return productRepository.saveProduct(product);
    }
    public boolean delete(long productId){
        return getProduct((productId)).map(product -> {
            productRepository.deleteProductById(productId);
            return true;
        }).orElse( false);
    }
}
