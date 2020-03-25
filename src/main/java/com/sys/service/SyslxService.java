package com.sys.service;

import com.sys.model.Syslx;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface SyslxService {
    List<Syslx> getSyslxList(Map requestparamMap);

    Syslx getSyslxById(int id);

    int insertSyslx(Syslx syslx);

    int delSyslx(int id);

    int upSyslx(Syslx syslx);
}
