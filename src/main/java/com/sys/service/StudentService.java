package com.sys.service;

import com.sys.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface StudentService {
    List<Student> getStudentList(Map requestparamMap);

    Student getStudentByIdcard(int idcard);

    Student getStudentById(int id);

    int insertStudent(Student student);

    int delStudent(int id);

    int upStudent(Student student);

    List<Student> getStudentByZid(int zid);

    List<Student> getStudentByCid(int cid);

    Student getStudentBylast();
}
