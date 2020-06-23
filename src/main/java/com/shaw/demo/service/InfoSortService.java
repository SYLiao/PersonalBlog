package com.shaw.demo.service;

import com.shaw.demo.model.InfoSort;

import javax.sound.sampled.Line;
import java.util.List;

public interface InfoSortService {
    int createInfoSort(InfoSort infoSort);

    int deleteInfoSort(long sortId);

    int modifyInfoSort(long sortId, InfoSort infoSort);

    List<InfoSort> listAll();

    InfoSort findById(long id);
}
