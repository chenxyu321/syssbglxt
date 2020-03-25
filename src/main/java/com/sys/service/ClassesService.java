package com.sys.service;

import com.sys.model.Classes;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface ClassesService {
    List<Classes> getClassesList(Map requestparamMap);

    Classes getClassesById(int id);

    List<Classes> getClassesByTeacher(int tid);

    int insertClasses(Classes classes);

    int delClasses(int id);

    int upClasses(Classes classes);
}
