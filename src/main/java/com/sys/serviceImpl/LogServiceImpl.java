package com.sys.serviceImpl;

import com.sys.mapper.LogMapper;
import com.sys.model.Log;
import com.sys.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class LogServiceImpl implements LogService {
    @Autowired
    private LogMapper mapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(Log record) {
        return mapper.insertSelective(record);
    }

    @Override
    public Log selectByPrimaryKey(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Log> getlogList() {
        return mapper.getlogList();
    }

    @Override
    public int updateByPrimaryKeySelective(Log record) {
        return mapper.updateByPrimaryKeySelective(record);
    }
}
