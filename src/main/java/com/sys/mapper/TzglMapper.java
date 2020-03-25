package com.sys.mapper;

import com.sys.model.Tzgl;

import java.util.List;

public interface TzglMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Tzgl record);

    int insertSelective(Tzgl record);

    Tzgl selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Tzgl record);

    int updateByPrimaryKey(Tzgl record);

    List<Tzgl> getTzglList();
}