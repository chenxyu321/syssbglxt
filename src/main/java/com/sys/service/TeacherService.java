package com.sys.service;

import com.sys.model.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface TeacherService {
    List<Teacher> getTeacherList(Map requestparamMap);

    Teacher getTeacherByIdcard(int idcard);

    Teacher getTeacherById(int id);

    int insertTeacher(Teacher teacher);

    int delTeacher(int id);

    int upTeacher(Teacher teacher);

    Teacher getteacherlast();
}
