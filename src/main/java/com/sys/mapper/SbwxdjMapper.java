package com.sys.mapper;

import com.sys.model.Sbwxdj;

import java.util.List;
import java.util.Map;

public interface SbwxdjMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Sbwxdj record);

    int insertSelective(Sbwxdj record);

    Sbwxdj selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Sbwxdj record);

    int updateByPrimaryKey(Sbwxdj record);

    List<Sbwxdj> getSbwxdjList(Map requestparamMap);

    List<Sbwxdj> getSbwxdjByZtid(int ztid);

    Sbwxdj getSbwxdjBySbid(int sbid);
}