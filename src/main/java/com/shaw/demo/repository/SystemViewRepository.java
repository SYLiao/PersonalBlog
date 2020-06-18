package com.shaw.demo.repository;

import com.shaw.demo.model.SystemView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemViewRepository extends JpaRepository<SystemView, Long> {
}
