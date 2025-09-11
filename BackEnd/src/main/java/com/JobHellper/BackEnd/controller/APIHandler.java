package com.jobhellper.backend.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobhellper.backend.services.NumberServices;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
// public class ProductController 
// {@CrossOrigin(origins = "http://localhost:3000"){}
// @RestController
public class APIHandler {

     private NumberServices productService;

    @Autowired
    public APIHandler(NumberServices productService) {
        this.productService = productService;
    }
//  ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

    // Create a new product.

    // @PostMapping("/product")
    // public ResponseEntity<Product> saveProduct(@RequestBody  product) {
    //     Product newProduct = productService.saveProduct(product);
    //     return ResponseEntity.ok(newProduct);
    // }

    // Get all products.
     
    @GetMapping("/products")
    public int APIreturn(int a) {
        return productService.processedNumber(a);
        // return productService.getAllProducts();
    }

    // // Get a product by ID.
    
    // @GetMapping("/products/{id}")
    // public ResponseEntity<Product> getProductById(@PathVariable Long id) {
    //     Optional<Product> product = productService.getProductById(id);
    //     return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    // }

    // Update a product by ID.
     
    // @PutMapping("/products/{id}")
    // public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
    //     Product updatedProduct = productService.updateProduct(id, product);
    //     return ResponseEntity.ok(updatedProduct);
    // }

    // Delete a product by ID.
     
    // @DeleteMapping("/products/{id}")
    // public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
    //     productService.deleteProduct(id);
    //     return ResponseEntity.ok("Product deleted successfully");
    // }
    // public Map<String, String> hello() {
    //     return Collections.singletonMap("message", "Hello from the backend!");
    // }
}
