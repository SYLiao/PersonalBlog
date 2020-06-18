package com.shaw.demo.repository;

import com.shaw.demo.model.ArticleSort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleSortRepository extends JpaRepository<ArticleSort, Long> {
}
