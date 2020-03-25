package com.sys.serviceImpl;

import com.sys.mapper.SbshdjMapper;
import com.sys.model.Sbshdj;
import com.sys.service.SbshdjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class SbshdjServiceImpl implements SbshdjService {
    @Autowired
    private SbshdjMapper mapper;
    @Override
    public List<Sbshdj> getSbshdjList() {
        return mapper.getSbshdjList();
    }

    @Override
    public Sbshdj getSbshdjBySbid(int sbid) {
        return mapper.getSbshdjBySbid(sbid);
    }

    @Override
    public Sbshdj getSbshdjById(int id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Sbshdj> getSbshdjByUid(int uid) {
        return mapper.getSbshdjByUid(uid);
    }

    @Override
    public List<Sbshdj> getSbshdjByZtid(int ztid) {
        return mapper.getSbshdjByZtid(ztid);
    }

    @Override
    public int InsertSbshdj(Sbshdj sbshdj) {
        return mapper.insertSelective(sbshdj);
    }

    @Override
    public int delSbshdj(int id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int upSbshdj(Sbshdj sbshdj) {
        return mapper.updateByPrimaryKeySelective(sbshdj);
    }
}
