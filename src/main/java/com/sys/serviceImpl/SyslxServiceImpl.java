package com.sys.serviceImpl;

import com.sys.mapper.SyslxMapper;
import com.sys.model.Syslx;
import com.sys.service.SyslxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class SyslxServiceImpl implements SyslxService {
    @Autowired
    private SyslxMapper mapper;
    @Override
    public List<Syslx> getSyslxList(Map requestparamMap) {
        return mapper.getSyslxList(requestparamMap);
    }

    @Override
    public Syslx getSyslxById(int id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int insertSyslx(Syslx syslx) {
        return mapper.insertSelective(syslx);
    }

    @Override
    public int delSyslx(int id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int upSyslx(Syslx syslx) {
        return mapper.updateByPrimaryKeySelective(syslx);
    }
}
