package org.yassine.webservice.services;

import org.yassine.webservice.entities.Product;

import java.util.List;

public interface ProductService {
    Double sellingPrice(Double price);
    Product getProduct(Integer code);
    List<Product> getAllProducts();
    boolean addProduct(Product product);
    Product updateProduct(Product product);
    boolean deleteProduct(Integer code);

}
