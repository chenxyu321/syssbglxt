package com.sys.serviceImpl;

import com.sys.mapper.SbwxdjMapper;
import com.sys.model.Sbwxdj;
import com.sys.service.SbwxdjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class SbwxdjServiceImpl implements SbwxdjService {
    @Autowired
    private SbwxdjMapper mapper;
    @Override
    public List<Sbwxdj> getSbwxdjList(Map requestparamMap) {
        return mapper.getSbwxdjList(requestparamMap);
    }

    @Override
    public Sbwxdj getSbwxdjById(int id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Sbwxdj> getSbwxdjByZtid(int ztid) {
        return mapper.getSbwxdjByZtid(ztid);
    }

    @Override
    public Sbwxdj getSbwxdjBySbid(int sbid) {
        return mapper.getSbwxdjBySbid(sbid);
    }

    @Override
    public int insertSbwxdj(Sbwxdj sbwxdj) {
        return mapper.insertSelective(sbwxdj);
    }

    @Override
    public int delSbwxdj(int id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int upSbwxdj(Sbwxdj sbwxdj) {
        return mapper.updateByPrimaryKeySelective(sbwxdj);
    }
}
