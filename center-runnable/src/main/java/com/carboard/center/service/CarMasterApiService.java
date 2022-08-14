package com.carboard.center.service;

import com.carboard.domain.carMaster.CarMasterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class CarMasterApiService {
    private final CarMasterRepository carMasterRepository;
}
