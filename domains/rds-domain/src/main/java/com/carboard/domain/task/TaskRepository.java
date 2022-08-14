package com.carboard.domain.task;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
//    List<Task> findAllByStatusAndKeyword();
}
