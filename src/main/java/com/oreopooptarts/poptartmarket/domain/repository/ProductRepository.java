package com.oreopooptarts.poptartmarket.domain.repository;

import com.oreopooptarts.poptartmarket.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> getAll();
    Optional<List<Product>> getByCategory(long categoryId);
    Optional<List<Product>> getByPrices(double price);
    Optional<List<Product>> getScarseProducts(long quantity);
    Optional<Product> getProduct(long productId);
    Product saveProduct(Product product);
    void deleteProduct(Product product);
    void deleteProductById(long productId);
}
