package com.sys.serviceImpl;

import com.sys.mapper.StudentMapper;
import com.sys.model.Student;
import com.sys.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper mapper;
    @Override
    public List<Student> getStudentList(Map requestparamMap) {
        return mapper.getStudentList(requestparamMap);
    }

    @Override
    public Student getStudentByIdcard(int idcard) {
        return mapper.getStudentByIdcard(idcard);
    }

    @Override
    public Student getStudentById(int id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int insertStudent(Student student) {
        return mapper.insertSelective(student);
    }

    @Override
    public int delStudent(int id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int upStudent(Student student) {
        return mapper.updateByPrimaryKeySelective(student);
    }

    @Override
    public List<Student> getStudentByZid(int zid) {
        return mapper.getStudentByZid(zid);
    }

    @Override
    public List<Student> getStudentByCid(int cid) {
        return mapper.getStudentByCid(cid);
    }

    @Override
    public Student getStudentBylast() {
        return mapper.getStudentByLast();
    }
}
