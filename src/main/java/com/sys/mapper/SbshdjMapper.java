package com.sys.mapper;

import com.sys.model.Sbshdj;

import java.util.List;

public interface SbshdjMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Sbshdj record);

    int insertSelective(Sbshdj record);

    Sbshdj selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Sbshdj record);

    int updateByPrimaryKey(Sbshdj record);

    List<Sbshdj> getSbshdjList();

    Sbshdj getSbshdjBySbid(int sbid);

    List<Sbshdj> getSbshdjByUid(int uid);

    List<Sbshdj> getSbshdjByZtid(int ztid);
}