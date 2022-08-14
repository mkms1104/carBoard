package com.carboard.center.api;

import com.carboard.domain.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("api/v1")
@RestController
public class ProductApiController {

    private final ProductRepository productRepository;

}
