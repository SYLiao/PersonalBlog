package com.shaw.demo.service.impl;

import com.shaw.demo.model.ArticlePicture;
import com.shaw.demo.repository.ArticlePictureRepository;
import com.shaw.demo.service.ArticlePictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticlePictureServiceImpl implements ArticlePictureService {
    @Autowired
    private ArticlePictureRepository articlePictureRepository;

    @Override
    public int createPicture(ArticlePicture articlePicture) {
        articlePictureRepository.saveAndFlush(articlePicture);
        return 1;
    }

    @Override
    public int deletePicture(long pictureId) {
        articlePictureRepository.deleteById(pictureId);
        return 1;
    }
}
