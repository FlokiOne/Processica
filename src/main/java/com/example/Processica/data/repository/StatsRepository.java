package com.example.Processica.data.repository;

import com.example.Processica.data.entity.EStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StatsRepository extends JpaRepository<EStats, String> {

    @Query("SELECT s FROM EStats s " +
            "WHERE s.entry = 1 " +
            "AND (:requestId IS NULL OR s.request.id = :requestId)")
    List<EStats> findAllUnique(String requestId);

    @Query("SELECT s FROM EStats s " +
            "WHERE s.request.id = :requestId")
    List<EStats> findAllByRequest(String requestId);

    @Query("SELECT s FROM EStats s " +
            "WHERE s.word = :word")
    List<EStats> findAllByWord(String word);

    @Transactional
    @Modifying
    @Query("DELETE FROM EStats e " +
            "WHERE e.request.id = :requestId ")
    void deleteAllByRequest(@Param("requestId") String requestId);

}
