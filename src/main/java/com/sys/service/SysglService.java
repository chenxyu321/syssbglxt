package com.sys.service;

import com.sys.model.Sysgl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface SysglService {
    List<Sysgl> getSysglList(Map requestparamMap);

    List<Sysgl> getSysglByteacher(int tid);

    Sysgl getSysglById(int id);

    Sysgl getSysglByBh(String bh);

    List<Sysgl> getSysglBySfyy(int sfyy);

    List<Sysgl> getSysglByKysys(int tid);

    int insertSysgl(Sysgl sysgl);

    int delSysgl(int id);

    int UpSysgl(Sysgl sysgl);
}
