package com.sys.service;

import com.sys.model.Zygl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface ZyglService {
    List<Zygl> getZyglList(Map requestparamMap);

    Zygl getZyglById(int id);

    int insertZygl(Zygl zygl);

    int delZygl(int id);

    int upZygl(Zygl zygl);
}
