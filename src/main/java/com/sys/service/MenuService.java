package com.sys.service;

import com.sys.model.Menu;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MenuService {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(Menu record);

    List<Menu> getmenuList();

    List<Menu> getfdmmenuList();

    List<Menu> getmenubyfdm(int fdm);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);
}
