package com.sys.mapper;

import com.sys.model.Syslx;

import java.util.List;
import java.util.Map;

public interface SyslxMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Syslx record);

    int insertSelective(Syslx record);

    Syslx selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Syslx record);

    int updateByPrimaryKey(Syslx record);

    List<Syslx> getSyslxList(Map requestparamMap);
}