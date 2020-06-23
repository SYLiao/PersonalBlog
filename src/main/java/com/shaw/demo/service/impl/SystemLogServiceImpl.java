package com.shaw.demo.service.impl;

import com.shaw.demo.model.SystemLog;
import com.shaw.demo.repository.SystemLogRepository;
import com.shaw.demo.service.SystemLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemLogServiceImpl implements SystemLogService {
    @Autowired
    private SystemLogRepository systemLogRepository;

    @Override
    public int createLog(SystemLog systemLog) {
        systemLogRepository.save(systemLog);
        return 1;
    }

    @Override
    public int deleteLog(long logId) {
        systemLogRepository.deleteById(logId);
        return 1;
    }
}
