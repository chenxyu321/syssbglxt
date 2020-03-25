package com.sys.serviceImpl;

import com.sys.mapper.TeacherMapper;
import com.sys.model.Teacher;
import com.sys.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper mapper;
    @Override
    public List<Teacher> getTeacherList(Map requestparamMap) {
        return mapper.getTeacherList(requestparamMap);
    }

    @Override
    public Teacher getTeacherByIdcard(int idcard) {
        return mapper.getTeacherByIdcard(idcard);
    }

    @Override
    public Teacher getTeacherById(int id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int insertTeacher(Teacher teacher) {
        return mapper.insertSelective(teacher);
    }

    @Override
    public int delTeacher(int id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int upTeacher(Teacher teacher) {
        return mapper.updateByPrimaryKeySelective(teacher);
    }

    @Override
    public Teacher getteacherlast() {
        return mapper.getTeacherByLast();
    }
}
