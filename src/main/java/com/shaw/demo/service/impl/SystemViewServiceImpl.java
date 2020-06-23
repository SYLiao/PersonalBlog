package com.shaw.demo.service.impl;

import com.shaw.demo.model.SystemLog;
import com.shaw.demo.model.SystemView;
import com.shaw.demo.repository.SystemLogRepository;
import com.shaw.demo.repository.SystemViewRepository;
import com.shaw.demo.service.SystemLogService;
import com.shaw.demo.service.SystemViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemViewServiceImpl implements SystemViewService {
    @Autowired
    private SystemViewRepository systemViewRepository;


    @Override
    public int addView(SystemView view) {
        systemViewRepository.save(view);
        return 1;
    }
}
