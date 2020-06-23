package com.shaw.demo.service.impl;

import com.shaw.demo.model.ArticleSort;
import com.shaw.demo.repository.ArticleSortRepository;
import com.shaw.demo.service.ArticleSortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleSortServiceImpl implements ArticleSortService {
    @Autowired
    private ArticleSortRepository articleSortRepository;

    @Override
    public int createSort(ArticleSort articleSort) {
        articleSortRepository.save(articleSort);
        return 1;
    }

    @Override
    public int deleteSort(long sortId) {
        articleSortRepository.deleteById(sortId);
        return 1;
    }

    @Override
    public int changeSort(long sortId, ArticleSort articleSort) {
        articleSort.setId(sortId);
        articleSortRepository.save(articleSort);
        return 0;
    }
}
