package com.sys.service;

import com.sys.model.Syxxb;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface SyxxbService {
    List<Syxxb> getSyxxbList(Map requestparamMap);

    List<Syxxb> getSyxxbByTid(int tid);

    List<Syxxb> getSyxxbByCid(int cid);

    Syxxb getSyxxbById(int id);

    int insertSyxxb(Syxxb syxxb);

    int delSyxxb(int id);

    int upSyxxb(Syxxb syxxb);
}
