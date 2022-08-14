package com.carboard.center.service;

import com.carboard.domain.staff.StaffRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class StaffApiService {
    private final StaffRepository staffRepository;
}
