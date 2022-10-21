package com.uam.ecommerce.service;

import com.uam.ecommerce.model.Product;
import org.springframework.stereotype.Service;

import javax.sound.sampled.Port;
import java.util.List;

@Service
public interface IServiceProduct {
    public List<Product> getListProduct();

    public Product findById(Long id);

    public Product saveProduct(Product product);

    public void deleteProduct(Long id);

}
