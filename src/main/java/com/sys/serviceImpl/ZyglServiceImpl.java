package com.sys.serviceImpl;

import com.sys.mapper.ZyglMapper;
import com.sys.model.Zygl;
import com.sys.service.ZyglService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class ZyglServiceImpl implements ZyglService {
    @Autowired
    private ZyglMapper zyglMapper;
    @Override
    public List<Zygl> getZyglList(Map requestparamMap) {
        return zyglMapper.getZyglList(requestparamMap);
    }

    @Override
    public Zygl getZyglById(int id) {
        return zyglMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insertZygl(Zygl zygl) {
        return zyglMapper.insertSelective(zygl);
    }

    @Override
    public int delZygl(int id) {
        return zyglMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int upZygl(Zygl zygl) {
        return zyglMapper.updateByPrimaryKeySelective(zygl);
    }
}
