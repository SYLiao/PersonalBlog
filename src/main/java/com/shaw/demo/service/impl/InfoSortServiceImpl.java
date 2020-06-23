package com.shaw.demo.service.impl;

import com.shaw.demo.model.InfoSort;
import com.shaw.demo.repository.InfoSortRepository;
import com.shaw.demo.service.InfoSortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoSortServiceImpl implements InfoSortService {
    @Autowired
    private InfoSortRepository infoSortRepository;

    @Override
    public int createInfoSort(InfoSort infoSort) {
        infoSortRepository.save(infoSort);
        return 1;
    }

    @Override
    public int deleteInfoSort(long sortId) {
        infoSortRepository.deleteById(sortId);
        return 1;
    }

    @Override
    public int modifyInfoSort(long sortId, InfoSort infoSort) {
        infoSort.setId(sortId);
        infoSortRepository.save(infoSort);
        return 1;
    }

    @Override
    public List<InfoSort> listAll() {
        List<InfoSort> result = infoSortRepository.findAll();
        return result;
    }

    @Override
    public InfoSort findById(long id) {
        InfoSort infoSort = infoSortRepository.findById(id).orElse(null);
        return infoSort;
    }
}
