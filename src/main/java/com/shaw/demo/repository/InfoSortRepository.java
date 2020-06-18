package com.shaw.demo.repository;

import com.shaw.demo.model.InfoSort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoSortRepository extends JpaRepository<InfoSort, Long> {
}
