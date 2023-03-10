package com.project.organic.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.organic.model.Category;
import com.project.organic.model.Product;
import com.project.organic.respository.ProductRespository;

@Service
@Transactional
public class ProductService {
    private final ProductRespository  productRespository;

    @Autowired
    public ProductService(ProductRespository productRespository) {
        this.productRespository = productRespository;
    }
    public List<Product> findAllProducts() {
        return productRespository.findAll();
    }
    public List<Product> findProductsByCat(Category catId) {
        return productRespository.findByCategoryID(catId);
    }
    public List<Product> findSale() {
        return productRespository.getBySalePrice();
    }
    public Product updateProduct(Product product) {
        return productRespository.save(product);
    }
    public void deleteProduct(int id){
    	productRespository.deleteById(id);
    }
    public Product addProduct(Product product) {
        return productRespository.save(product);
    }
    public Product findProductByID(int id){
        return productRespository.findById(id);
    }

}
