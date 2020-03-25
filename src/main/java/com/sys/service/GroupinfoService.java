package com.sys.service;

import com.sys.model.Groupinfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GroupinfoService {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(Groupinfo record);

    Groupinfo selectByPrimaryKey(Integer id);

    List<Groupinfo> getgroupinfoList();

    int updateByPrimaryKeySelective(Groupinfo record);
}
