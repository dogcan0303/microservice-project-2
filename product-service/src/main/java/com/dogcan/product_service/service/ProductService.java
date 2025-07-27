package com.dogcan.product_service.service;

import com.dogcan.product_service.dto.ProductRequest;
import com.dogcan.product_service.dto.ProductResponse;
import com.dogcan.product_service.mapper.ProductsMapper;
import com.dogcan.product_service.model.Product;
import com.dogcan.product_service.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;

    }

    public void createProduct(ProductRequest productRequest) {
        Product product =  new Product(productRequest.getName(),productRequest.getDescription(),productRequest.getPrice());
        productRepository.save(product);
        logger.info("Product {} is saved", product.getId());
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(ProductsMapper::mapToProductResponse).collect(Collectors.toList());
    }
}
