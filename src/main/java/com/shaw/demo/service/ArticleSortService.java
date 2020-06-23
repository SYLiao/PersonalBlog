package com.shaw.demo.service;

import com.shaw.demo.model.ArticleSort;

public interface ArticleSortService {

    int createSort(ArticleSort articleSort);

    int deleteSort(long sortId);

    int changeSort(long sortId, ArticleSort articleSort);
}
