package com.example.NJCTask.Service;

import com.example.NJCTask.Model.Product;
import com.example.NJCTask.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product getProductById(Integer productId){
        Optional<Product> product = productRepository.findById(productId);
        if (product.isPresent()){
            return product.get();
        }
        return new Product();
    }

    public void updateProduct(Product productData,int productId){
        Optional<Product> existingProduct = productRepository.findById(productId);
        if (existingProduct.isPresent()){
            Product product = existingProduct.get();
            product.setProductName(productData.getProductName());
            product.setBrandName(productData.getBrandName());
            product.setPrice(productData.getPrice());
            productRepository.save(product);
        }
    }

    public void addProduct(Product product){
        productRepository.save(product);
    }
}
