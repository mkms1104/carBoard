package com.carboard.center.service;

import com.carboard.domain.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductApiService {
    private final ProductRepository productRepository;
}
