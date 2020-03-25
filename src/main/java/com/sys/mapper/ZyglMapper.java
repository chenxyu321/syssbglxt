package com.sys.mapper;

import com.sys.model.Zygl;

import java.util.List;
import java.util.Map;

public interface ZyglMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Zygl record);

    int insertSelective(Zygl record);

    Zygl selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Zygl record);

    int updateByPrimaryKey(Zygl record);

    List<Zygl> getZyglList(Map requestparamMap);
}