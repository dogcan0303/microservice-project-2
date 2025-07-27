package com.dogcan.product_service.mapper;

import com.dogcan.product_service.dto.ProductResponse;
import com.dogcan.product_service.model.Product;


public class ProductsMapper {

    public static ProductResponse mapToProductResponse(Product product) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(product.getId());
        productResponse.setName(product.getName());
        productResponse.setDescription(product.getDescription());
        productResponse.setPrice(product.getPrice());
        return productResponse;
    }
}
