package com.carboard.center.api;

import com.carboard.center.service.StockApiService;
import com.carboard.domain.stock.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("api/v1")
@RestController
public class StockApiController {
    private final StockApiService stockApiService;
    private final StockRepository stockRepository;
}
