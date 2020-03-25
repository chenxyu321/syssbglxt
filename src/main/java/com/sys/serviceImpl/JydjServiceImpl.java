package com.sys.serviceImpl;

import com.sys.mapper.JydjMapper;
import com.sys.model.Jydj;
import com.sys.service.JydjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class JydjServiceImpl implements JydjService {
    @Autowired
    private JydjMapper mapper;
    @Override
    public List<Jydj> getJydjList() {
        return mapper.getJydjList();
    }

    @Override
    public Jydj getJydjById(int id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public Jydj getJydjBySbid(int sbid) {
        return mapper.getJydjBySbid(sbid);
    }

    @Override
    public List<Jydj> getJydjByUid(int uid) {
        return mapper.getJydjByUid(uid);
    }

    @Override
    public List<Jydj> getJydjByZtid(int ztid) {
        return mapper.getJydjByZtid(ztid);
    }

    @Override
    public int insertJydj(Jydj jydj) {
        return mapper.insertSelective(jydj);
    }

    @Override
    public int delJydj(int id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int upJydj(Jydj jydj) {
        return mapper.updateByPrimaryKey(jydj);
    }
}
