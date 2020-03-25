package com.sys.service;

import com.sys.model.Users;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface UsersService {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer id);

    List<Users> getuserList(Map requestparamMap);

    int getusernum();

    int updateByPrimaryKeySelective(Users record);

    Users getusersByusername(String username);
}
