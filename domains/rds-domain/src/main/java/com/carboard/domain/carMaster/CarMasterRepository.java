package com.carboard.domain.carMaster;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarMasterRepository extends JpaRepository<CarMaster, Long> {
    Optional<CarMaster> findByName(String name);
}
