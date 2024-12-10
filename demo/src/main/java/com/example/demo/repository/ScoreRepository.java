package com.example.demo.repository;

import com.example.demo.obj.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {
    @Query("SELECT s FROM Score s JOIN FETCH s.student JOIN FETCH s.subject")
    List<Score> findAllInfo();
}
