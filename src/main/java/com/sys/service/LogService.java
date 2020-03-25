package com.sys.service;

import com.sys.model.Log;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LogService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(Log record);

    Log selectByPrimaryKey(Integer id);

    List<Log> getlogList();

    int updateByPrimaryKeySelective(Log record);
}
