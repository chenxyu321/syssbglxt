package com.sys.mapper;

import com.sys.model.Sysgl;

import java.util.List;
import java.util.Map;

public interface SysglMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Sysgl record);

    int insertSelective(Sysgl record);

    Sysgl selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Sysgl record);

    int updateByPrimaryKey(Sysgl record);

    List<Sysgl> getSysglList(Map requestparamMap);

    List<Sysgl> getSysglByKysys(int tid);

    Sysgl getSysglByBh(String bh);

    List<Sysgl> getSysglByteacher(int tid);

    List<Sysgl> getSysglBySfyy(int sfyy);

}