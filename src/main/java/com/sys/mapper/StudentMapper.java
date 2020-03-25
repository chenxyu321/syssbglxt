package com.sys.mapper;

import com.sys.model.Student;

import java.util.List;
import java.util.Map;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    List<Student> getStudentList(Map requestparamMap);

    Student getStudentByIdcard(int idcard);

    List<Student> getStudentByZid(int zid);

    List<Student> getStudentByCid(int cid);

    Student getStudentByLast();
}