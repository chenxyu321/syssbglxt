package com.sys.service;

import com.sys.model.Xxtg;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface XxtgService {
    List<Xxtg> getXxtgList(Map requestparamMap);

    Xxtg getXxtgById(int id);

    int delxxtg(int id);

    int insertxxtg(Xxtg record);

    int upxxgt(Xxtg record);
}
