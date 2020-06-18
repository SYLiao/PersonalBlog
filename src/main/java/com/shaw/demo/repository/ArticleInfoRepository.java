package com.shaw.demo.repository;

import com.shaw.demo.model.ArticleInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleInfoRepository extends JpaRepository<ArticleInfo, Long> {
}
