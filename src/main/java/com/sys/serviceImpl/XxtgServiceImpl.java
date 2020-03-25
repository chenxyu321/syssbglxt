package com.sys.serviceImpl;

import com.sys.mapper.XxtgMapper;
import com.sys.model.Xxtg;
import com.sys.service.XxtgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class XxtgServiceImpl implements XxtgService {
    @Autowired
    private XxtgMapper xxtgMapper;
    @Override
    public List<Xxtg> getXxtgList(Map requestparamMap) {
        return xxtgMapper.getxxtglist(requestparamMap);
    }

    @Override
    public Xxtg getXxtgById(int id) {
        return xxtgMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delxxtg(int id) {
        return xxtgMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertxxtg(Xxtg record) {
        return xxtgMapper.insertSelective(record);
    }

    @Override
    public int upxxgt(Xxtg record) {
        return xxtgMapper.updateByPrimaryKeySelective(record);
    }
}
