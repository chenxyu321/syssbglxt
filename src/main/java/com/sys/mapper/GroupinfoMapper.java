package com.sys.mapper;

import com.sys.model.Groupinfo;

import java.util.List;

public interface GroupinfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Groupinfo record);

    int insertSelective(Groupinfo record);

    Groupinfo selectByPrimaryKey(Integer id);

    List<Groupinfo> getgroupinfoList();

    int updateByPrimaryKeySelective(Groupinfo record);

    int updateByPrimaryKey(Groupinfo record);
}