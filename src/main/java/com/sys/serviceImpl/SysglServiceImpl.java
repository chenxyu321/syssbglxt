package com.sys.serviceImpl;

import com.sys.mapper.SysglMapper;
import com.sys.model.Sysgl;
import com.sys.service.SysglService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class SysglServiceImpl implements SysglService {
    @Autowired
    private SysglMapper mapper;
    @Override
    public List<Sysgl> getSysglList(Map requestparamMap) {
        return mapper.getSysglList(requestparamMap);
    }

    @Override
    public List<Sysgl> getSysglByteacher(int tid) {
        return mapper.getSysglByteacher(tid);
    }

    @Override
    public Sysgl getSysglById(int id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public Sysgl getSysglByBh(String bh) {
        return mapper.getSysglByBh(bh);
    }

    @Override
    public List<Sysgl> getSysglBySfyy(int sfyy) {
        return mapper.getSysglBySfyy(sfyy);
    }

    @Override
    public List<Sysgl> getSysglByKysys(int tid) {
        return mapper.getSysglByKysys(tid);
    }

    @Override
    public int insertSysgl(Sysgl sysgl) {
        return mapper.insertSelective(sysgl);
    }

    @Override
    public int delSysgl(int id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int UpSysgl(Sysgl sysgl) {
        return mapper.updateByPrimaryKeySelective(sysgl);
    }
}
