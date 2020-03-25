package com.sys.service;

import com.sys.model.Sysbgl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface SysbglService {
    List<Sysbgl> getSysbglList(Map requestparamMap);

    Sysbgl getSysbglByBh(String bh);

    Sysbgl getSysbglById(int id);

    List<Sysbgl> getSysbglBySysid(int sysid);

    List<Sysbgl> getSysbglByky();

    int insertSysbgl(Sysbgl sysbgl);

    int delSysbgl(int id);

    int upSysbgl(Sysbgl sysbgl);
}
