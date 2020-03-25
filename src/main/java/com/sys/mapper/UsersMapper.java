package com.sys.mapper;

import com.sys.model.Users;

import java.util.List;
import java.util.Map;

public interface UsersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer id);

    List<Users> getuserList(Map requestparamMap);

    int getusernum();

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    Users getusersByusername(String username);
}