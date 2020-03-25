package com.sys.mapper;

import com.sys.model.Sysbgl;

import java.util.List;
import java.util.Map;

public interface SysbglMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Sysbgl record);

    int insertSelective(Sysbgl record);

    Sysbgl selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Sysbgl record);

    int updateByPrimaryKey(Sysbgl record);

    List<Sysbgl> getSysbglList(Map requestparamMap);

    List<Sysbgl> getSysbglByky();

    Sysbgl getSysbglByBh(String bh);

    List<Sysbgl> getSysbglBySysid(int sysid);
}