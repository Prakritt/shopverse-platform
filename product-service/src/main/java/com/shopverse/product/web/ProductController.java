package com.shopverse.product.web;

import com.shopverse.product.domain.Product;
import com.shopverse.product.dto.ProductRequest;
import com.shopverse.product.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@Valid @RequestBody ProductRequest request){
        Product product = new Product(request.getName(), request.getSku(), request.getPrice());

        return repository.save(product);
    }

    @GetMapping
    public List<Product> findAll(){
        return repository.findAll();
    }

    public Product findById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }


}
