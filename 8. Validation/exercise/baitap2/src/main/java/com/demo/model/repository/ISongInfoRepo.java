package com.demo.model.repository;

import com.demo.model.bean.SongInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISongInfoRepo extends JpaRepository<SongInfo,Integer> {
}
