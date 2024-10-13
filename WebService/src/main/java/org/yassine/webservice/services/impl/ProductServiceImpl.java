package org.yassine.webservice.services.impl;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.yassine.webservice.entities.Product;
import org.yassine.webservice.repositeries.ProductRepositerie;
import org.yassine.webservice.services.ProductService;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import jakarta.jws.WebService;

@Service
@WebService(serviceName = "ProductWS")
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepositerie productRepository;

    @Override
    @WebMethod(operationName = "sellingPrice")
    public Double sellingPrice(@WebParam(name = "Price") Double price) {
        return price * 1.5;
    }

    @Override
    @WebMethod
    public Product getProduct(Integer code) {
        return productRepository.findByCode(code).orElseThrow();
    }

    @Override
    @WebMethod
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    @WebMethod
    public boolean addProduct(Product product) {
        Product productSaved = productRepository.save(product);
        return productSaved != null;
    }

    @Override
    @WebMethod
    public Product updateProduct(Product product) {
        Optional<Product> productOptional = productRepository.findByCode(product.getCode());
        if (productOptional.isPresent()) {
            Product productExict = productOptional.get();
            productExict.setName(product.getName());
            productExict.setPrice(product.getPrice());
            productExict.setDateCreated(product.getDateCreated());
            return productRepository.save(productExict);
        } else {
            // Handle product not found, could throw an exception
            throw new IllegalArgumentException("Product not found for code: " + product.getCode());
        }
    }

    @Override
    @WebMethod
    public boolean deleteProduct(Integer code) {
        Optional<Product> productOptional = productRepository.findByCode(code);
        if (productOptional.isPresent()) {
            productRepository.deleteByCode(code);
            return true;
        } else {
            return false;
        }
    }
}
