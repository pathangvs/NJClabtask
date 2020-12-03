package com.example.NJCTask.Controller;

import com.example.NJCTask.Model.Product;
import com.example.NJCTask.Repository.ProductRepository;
import com.example.NJCTask.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/store")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductService productService;

    @PutMapping("/product/{productId}")
    public ResponseEntity<String> updateProduct(@PathVariable("productId") Integer productId, @RequestBody Product product) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        productService.updateProduct(product, productId);
        return new ResponseEntity<String>(
                "Product Updated Successfully", headers, HttpStatus.OK);
    }

    @GetMapping("/allproducts")
    public ResponseEntity<List<Product>> getAllProduct() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        List<Product> productList = productRepository.findAll();
        return new ResponseEntity<List<Product>>(
                productList, headers, HttpStatus.OK);
    }

    @GetMapping("/products/{productId}")
    public Product getProduct(@PathVariable("productId") Integer productId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        Product entity = productService.getProductById(productId);
        return entity;
    }

    @PostMapping("/addproduct")
    /*
    Plese use [{object}]
    */
    public ResponseEntity<String> createProduct(@RequestBody List<Product> product) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        product.forEach(p ->{
            productService.addProduct(p);
        });
        return new ResponseEntity<String>(
                "Product Created Successfully", headers, HttpStatus.OK);
    }


    @DeleteMapping("/products/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable("productId") Integer productId, @RequestBody Product product) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        productRepository.deleteById(productId);
        return new ResponseEntity<String>(
                "Product Deleted Successfully", headers, HttpStatus.OK);

    }

}
