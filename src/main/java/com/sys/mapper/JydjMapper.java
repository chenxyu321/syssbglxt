package com.sys.mapper;

import com.sys.model.Jydj;

import java.util.List;

public interface JydjMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Jydj record);

    int insertSelective(Jydj record);

    Jydj selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Jydj record);

    int updateByPrimaryKey(Jydj record);

    List<Jydj> getJydjList();

    Jydj getJydjBySbid(int sbid);

    List<Jydj> getJydjByUid(int uid);

    List<Jydj> getJydjByZtid(int ztid);
}