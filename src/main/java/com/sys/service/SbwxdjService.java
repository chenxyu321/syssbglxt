package com.sys.service;

import com.sys.model.Sbwxdj;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface SbwxdjService {
    List<Sbwxdj> getSbwxdjList(Map requestparamMap);

    Sbwxdj getSbwxdjById(int id);

    List<Sbwxdj> getSbwxdjByZtid(int ztid);

    Sbwxdj getSbwxdjBySbid(int sbid);

    int insertSbwxdj(Sbwxdj sbwxdj);

    int delSbwxdj(int id);

    int upSbwxdj(Sbwxdj sbwxdj);
}
