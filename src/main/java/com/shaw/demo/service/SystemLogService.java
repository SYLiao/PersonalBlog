package com.shaw.demo.service;

import com.shaw.demo.model.SystemLog;

public interface SystemLogService {
    int createLog(SystemLog systemLog);

    int deleteLog(long logId);
}
