package com.sys.serviceImpl;

import com.sys.mapper.SyxxbMapper;
import com.sys.model.Syxxb;
import com.sys.service.SyxxbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class SyxxbServiceImpl implements SyxxbService {
    @Autowired
    private SyxxbMapper mapper;
    @Override
    public List<Syxxb> getSyxxbList(Map requestparamMap) {
        return mapper.getSyxxbList(requestparamMap);
    }

    @Override
    public List<Syxxb> getSyxxbByTid(int tid) {
        return mapper.getSyxxbByTid(tid);
    }

    @Override
    public List<Syxxb> getSyxxbByCid(int cid) {
        return mapper.getSyxxbByCid(cid);
    }

    @Override
    public Syxxb getSyxxbById(int id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int insertSyxxb(Syxxb syxxb) {
        return mapper.insertSelective(syxxb);
    }

    @Override
    public int delSyxxb(int id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int upSyxxb(Syxxb syxxb) {
        return mapper.updateByPrimaryKeySelective(syxxb);
    }
}
