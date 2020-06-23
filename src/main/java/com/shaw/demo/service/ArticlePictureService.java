package com.shaw.demo.service;

import com.shaw.demo.model.ArticlePicture;

public interface ArticlePictureService {

    int createPicture(ArticlePicture articlePicture);

    int deletePicture(long pictureId);
}
