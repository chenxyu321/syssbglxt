package com.sys.service;

import com.sys.model.Sbshdj;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SbshdjService {
    List<Sbshdj> getSbshdjList();

    Sbshdj getSbshdjBySbid(int sbid);

    Sbshdj getSbshdjById(int id);

    List<Sbshdj> getSbshdjByUid(int uid);

    List<Sbshdj> getSbshdjByZtid(int ztid);

    int InsertSbshdj(Sbshdj sbshdj);

    int delSbshdj(int id);

    int upSbshdj(Sbshdj sbshdj);
}
