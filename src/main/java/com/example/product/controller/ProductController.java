package com.example.product.controller;

import com.example.product.dto.ProductDTO;
import com.example.product.model.Category;
import com.example.product.model.Product;
import com.example.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("/products")
public class ProductController {


    @Autowired
    private ProductService productService;

    @GetMapping("/search")
    public List<Product> searchProducts(@RequestParam String query) {
        return productService.searchProducts(query);
    }

//    @GetMapping("/filter")
//    public List<Product> filterProducts(@RequestParam String category, @RequestParam String brand) {
//        return productService.filterProducts(category, brand);
//    }

    @Transactional
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> addProduct(@RequestBody ProductDTO productDTO) {
        return new ResponseEntity<>(productService.saveOrUpdateProduct(productDTO), HttpStatus.CREATED);
    }

//    @GetMapping
//    public List<Product> getAllProducts() {
//        return productService.getAllProducts();
//    }

    @GetMapping("/subcategory-item/{id}")
    public ResponseEntity<List<Product>> getProducts(@RequestParam Long subCategoryItemId) {
        return ResponseEntity.ok(productService.getProductsBySubCategoryItemId(subCategoryItemId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        if (product != null) {
            return ResponseEntity.ok(product);
        }
        return ResponseEntity.notFound().build();
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        Product existingProduct = productService.getProductById(id);
        if (existingProduct != null) {
            productDTO.setId(id);
            productDTO.setProductCode(existingProduct.getProductCode());
            return ResponseEntity.ok(productService.saveOrUpdateProduct(productDTO));
        }
        return ResponseEntity.notFound().build();
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getAllCategories() {
        return ResponseEntity.ok(productService.getAllCategories());
    }

    @GetMapping("/by-category-subcategory")
    public List<Product> getProductsByCategoryAndSubCategory(
            @RequestParam Long categoryId,
            @RequestParam Long subCategoryId) {
        return productService.getProductsByCategoryAndSubCategory(categoryId, subCategoryId);
    }

    @GetMapping("/by-category-subcategory-subcategory-item")
    public List<Product> getProductsByCategoryAndSubCategoryAndSubCategoryItem(
            @RequestParam Long categoryId,
            @RequestParam Long subCategoryId,
            @RequestParam Long subCategoryItemId) {
        return productService.getProductsByCategoryAndSubCategoryAndSubCategoryItem(categoryId, subCategoryId, subCategoryItemId);
    }
}

