package com.demo.model.service;

import com.demo.model.bean.SongInfo;
import com.demo.model.repository.ISongInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SongInfoService implements ISongInfoService {
    @Autowired
    ISongInfoRepo iSongInfoRepo;
    @Override
    public List<SongInfo> findAll() {
        return iSongInfoRepo.findAll();
    }

    @Override
    public SongInfo findById(int id) {
        return iSongInfoRepo.findById(id).get();
    }

    @Override
    public void save(SongInfo songInfo) {
       iSongInfoRepo.save(songInfo);
    }
}
