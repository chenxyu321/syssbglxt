package com.sys.serviceImpl;

import com.sys.mapper.UsersMapper;
import com.sys.model.Users;
import com.sys.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper mapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(Users record) {
        return mapper.insertSelective(record);
    }

    @Override
    public Users selectByPrimaryKey(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Users> getuserList(Map requestparamMap) {
        return mapper.getuserList(requestparamMap);
    }

    @Override
    public int getusernum() {
        return mapper.getusernum();
    }

    @Override
    public int updateByPrimaryKeySelective(Users record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Users getusersByusername(String username) {
        return mapper.getusersByusername(username);
    }
}
