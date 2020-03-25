package com.sys.service;

import com.sys.model.Tzgl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TzglService {
    List<Tzgl> getTzglList();

    Tzgl getTzglByid(int id);

    int insertTzgl(Tzgl tzgl);

    int delTzgl(int id);

    int upTzgl(Tzgl tzgl);
}
