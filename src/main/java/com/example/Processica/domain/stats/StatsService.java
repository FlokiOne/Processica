package com.example.Processica.domain.stats;

import com.example.Processica.presentation.dto.RsStats;

import java.util.List;

public interface StatsService {
    RsStats getById(String statsId);

    List<RsStats> getAll();

    List<RsStats> findByWord(String requestId);

    List<RsStats> getByRequest(String requestId);

    List<RsStats> getUnique(String requestId);
}
