package org.yassine.soapclient.Controllers;


import org.springframework.web.bind.annotation.*;
import org.yassine.soapclient.proxy.Product;
import org.yassine.soapclient.proxy.ProductServiceImpl;
import org.yassine.soapclient.proxy.ProductWS;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin("*")
public class ProductController {

    private ProductServiceImpl productService;


    public ProductController() {
        this.productService = new ProductWS().getProductServiceImplPort();
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // Add a new product
    @PostMapping
    public boolean addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    // Update an existing product
    @PutMapping("/{code}")
    public void updateProduct(@PathVariable int code, @RequestBody Product updatedProduct) {
        updatedProduct.setCode(code);
        productService.updateProduct(updatedProduct);
    }

    // Delete a product by code
    @DeleteMapping("/{code}")
    public boolean deleteProduct(@PathVariable int code) {
        return productService.deleteProduct(code);
    }

    // Calculate the selling price for a product
    @GetMapping("/sellingPrice/{price}")
    public double calculateSellingPrice(@PathVariable double price) {
        return productService.sellingPrice(price);
    }
}
