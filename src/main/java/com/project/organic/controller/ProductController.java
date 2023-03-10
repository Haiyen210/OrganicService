package com.project.organic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.organic.model.Category;
import com.project.organic.model.Product;
import com.project.organic.respository.ProductRespository;
import com.project.organic.service.ProductService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    ProductRespository productRespository;
    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.findAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);

    }
    @GetMapping("/products/sale")
    public ResponseEntity<List<Product>> getSale() {
        List<Product> products = productService.findSale();
        return new ResponseEntity<>(products, HttpStatus.OK);

    }
    @GetMapping("/products/related/{catId}")
    public ResponseEntity<List<Product>> getByCate(@PathVariable("catId") Category catId) {
        List<Product> products = productService.findProductsByCat(catId);
        return new ResponseEntity<>(products, HttpStatus.OK);

    }
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") int id) {
    	Product product = productService.findProductByID(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
    	Product newProduct = productService.addProduct(product);	
    	System.out.println(product);
    	System.out.println(newProduct);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }
    @PutMapping("/products/update")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
    	Product updateProduct = productService.updateProduct(product);
        return new ResponseEntity<>(updateProduct, HttpStatus.OK);
    }
    @DeleteMapping("/products/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") int id) {
        if (productService.findProductByID(id)!=null){
        	productService.deleteProduct(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
