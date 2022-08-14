package com.carboard.center.api;

import com.carboard.center.service.StaffApiService;
import com.carboard.domain.staff.StaffRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("api/v1")
@RestController
public class StaffApiController {

    private final StaffApiService staffApiService;
    private final StaffRepository staffRepository;
}
