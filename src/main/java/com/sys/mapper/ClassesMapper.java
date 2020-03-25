package com.sys.mapper;
import com.sys.model.Classes;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface ClassesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Classes record);

    int insertSelective(Classes record);

    Classes selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Classes record);

    int updateByPrimaryKey(Classes record);

    List<Classes> getClassesList(Map requestparamMap);

    List<Classes> getClassesByTeacher(int tid);
}