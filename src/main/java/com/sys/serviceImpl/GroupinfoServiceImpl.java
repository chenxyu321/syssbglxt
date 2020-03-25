package com.sys.serviceImpl;

import com.sys.mapper.GroupinfoMapper;
import com.sys.model.Groupinfo;
import com.sys.service.GroupinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GroupinfoServiceImpl implements GroupinfoService {
    @Autowired
    private GroupinfoMapper mapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(Groupinfo record) {
        return mapper.insertSelective(record);
    }

    @Override
    public Groupinfo selectByPrimaryKey(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Groupinfo> getgroupinfoList() {
        return mapper.getgroupinfoList();
    }

    @Override
    public int updateByPrimaryKeySelective(Groupinfo record) {
        return mapper.updateByPrimaryKeySelective(record);
    }
}
