package com.sys.serviceImpl;

import com.sys.mapper.SysbglMapper;
import com.sys.model.Sysbgl;
import com.sys.service.SysbglService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class SysbglServiceImpl implements SysbglService {
    @Autowired
    private SysbglMapper mapper;
    @Override
    public List<Sysbgl> getSysbglList(Map requestparamMap) {
        return mapper.getSysbglList(requestparamMap);
    }

    @Override
    public Sysbgl getSysbglByBh(String bh) {
        return mapper.getSysbglByBh(bh);
    }

    @Override
    public Sysbgl getSysbglById(int id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Sysbgl> getSysbglBySysid(int sysid) {
        return mapper.getSysbglBySysid(sysid);
    }

    @Override
    public List<Sysbgl> getSysbglByky() {
        return mapper.getSysbglByky();
    }

    @Override
    public int insertSysbgl(Sysbgl sysbgl) {
        return mapper.insertSelective(sysbgl);
    }

    @Override
    public int delSysbgl(int id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int upSysbgl(Sysbgl sysbgl) {
        return mapper.updateByPrimaryKeySelective(sysbgl);
    }
}
