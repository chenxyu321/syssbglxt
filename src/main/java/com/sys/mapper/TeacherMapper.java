package com.sys.mapper;

import com.sys.model.Teacher;

import java.util.List;
import java.util.Map;

public interface TeacherMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);

    List<Teacher> getTeacherList(Map requestparamMap);

    Teacher getTeacherByIdcard(int idcard);

    Teacher getTeacherByLast();
}