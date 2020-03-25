package com.sys.serviceImpl;

import com.sys.mapper.MenuMapper;
import com.sys.model.Menu;
import com.sys.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper mapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(Menu record) {
        return mapper.insertSelective(record);
    }

    @Override
    public List<Menu> getmenuList() {
        return mapper.getmenuList();
    }

    @Override
    public List<Menu> getfdmmenuList() {
        return mapper.getfdmmenuList();
    }

    @Override
    public List<Menu> getmenubyfdm(int fdm) {
        return mapper.getmenubyfdm(fdm);
    }

    @Override
    public Menu selectByPrimaryKey(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Menu record) {
        return mapper.updateByPrimaryKeySelective(record);
    }
}
