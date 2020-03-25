package com.sys.mapper;

import com.sys.model.Xxtg;

import java.util.List;
import java.util.Map;

public interface XxtgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Xxtg record);

    int insertSelective(Xxtg record);

    Xxtg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Xxtg record);

    int updateByPrimaryKey(Xxtg record);

    List<Xxtg> getxxtglist(Map requestparamMap);
}