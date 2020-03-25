package com.sys.serviceImpl;

import com.sys.mapper.TzglMapper;
import com.sys.model.Tzgl;
import com.sys.service.TzglService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class TzglServiceImpl implements TzglService {
    @Autowired
    private TzglMapper mapper;
    @Override
    public List<Tzgl> getTzglList() {
        return mapper.getTzglList();
    }

    @Override
    public Tzgl getTzglByid(int id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int insertTzgl(Tzgl tzgl) {
        return mapper.insertSelective(tzgl);
    }

    @Override
    public int delTzgl(int id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int upTzgl(Tzgl tzgl) {
        return mapper.updateByPrimaryKeySelective(tzgl);
    }
}
