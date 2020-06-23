package com.shaw.demo.repository;

import com.shaw.demo.model.ArticlePicture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticlePictureRepository extends JpaRepository<ArticlePicture, Long> {
}
