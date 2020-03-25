package com.sys.service;

import com.sys.model.Jydj;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JydjService {
    List<Jydj> getJydjList();

    Jydj getJydjById(int id);

    Jydj getJydjBySbid(int sbid);

    List<Jydj> getJydjByUid(int uid);

    List<Jydj> getJydjByZtid(int ztid);

    int insertJydj(Jydj jydj);

    int delJydj(int id);

    int upJydj(Jydj jydj);
}
