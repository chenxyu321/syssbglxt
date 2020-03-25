package com.sys.mapper;

import com.sys.model.Syxxb;

import java.util.List;
import java.util.Map;

public interface SyxxbMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Syxxb record);

    int insertSelective(Syxxb record);

    Syxxb selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Syxxb record);

    int updateByPrimaryKey(Syxxb record);

    List<Syxxb> getSyxxbList(Map requestparamMap);

    List<Syxxb> getSyxxbByTid(int tid);

    List<Syxxb> getSyxxbByCid(int cid);
}