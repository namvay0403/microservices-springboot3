package com.newdev.product_service.service;

import com.newdev.product_service.dto.ProductRequest;
import com.newdev.product_service.dto.ProductResponse;
import com.newdev.product_service.model.Product;
import com.newdev.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    public ProductResponse createProduct(ProductRequest productRequest) {
        // Logic to create a product
        Product product = Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .skuCode(productRequest.skuCode())
                .build();
        productRepository.save(product);
        log.info("Product created: {}", product.getId());
        return new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getSkuCode());
    }

    public List<ProductResponse> getAllProducts() {
        // Logic to get all products
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(product -> new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getSkuCode()))
                .toList();
    }
}
