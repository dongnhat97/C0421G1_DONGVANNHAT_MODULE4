package com.demo.model.service;

import com.demo.model.bean.SongInfo;

import java.util.List;

public interface ISongInfoService {
    List<SongInfo> findAll();

    SongInfo findById(int id);

    void save(SongInfo songInfo);
}
