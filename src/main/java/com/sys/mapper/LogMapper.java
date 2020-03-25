package com.sys.mapper;

import com.sys.model.Log;

import java.util.List;

public interface LogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Log record);

    int insertSelective(Log record);

    Log selectByPrimaryKey(Integer id);

    List<Log> getlogList();

    int updateByPrimaryKeySelective(Log record);

    int updateByPrimaryKey(Log record);
}