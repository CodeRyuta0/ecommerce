package com.uam.ecommerce.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uam.ecommerce.model.Product;
import com.uam.ecommerce.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@Component("serviceProduct")
public class ImpServiceProduct implements IServiceProduct{

    @Autowired
    private IProductRepository repo;

    @Override
    public List<Product> getListProduct() {
        return repo.findAll();
    }

    @Override
    public Product findById(Long id) {
        return repo.findById(id).get()  ;
    }

    /*@Override
    public Product saveProduct(Product product) {
        return repo.save(product);
    }*/

    @Value("${ruta.archivos.imagen}")
    private String ruta;

    @Override
    public Product saveProduct(String ProductDto, MultipartFile image) throws IOException {
        byte[] imgByte = image.getBytes();
        Path path = Paths.get(ruta + "//" + image.getOriginalFilename());
        if (!Files.exists(path)){
            Files.write(path, imgByte);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        Product product = objectMapper.readValue(ProductDto, Product.class);
        product.setImage(image.getOriginalFilename());
        return repo.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        repo.deleteById(id);
    }

}
