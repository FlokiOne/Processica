package com.example.Processica.domain.stats;

import com.example.Processica.domain.stats.usecase.GetStatsUseCase;
import com.example.Processica.presentation.dto.RsStats;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatsServiceImpl implements StatsService{

    private final GetStatsUseCase getStatsUseCase;

    StatsServiceImpl (GetStatsUseCase getStatsUseCase) {
        this.getStatsUseCase = getStatsUseCase;
    }

    @Override
    public RsStats getById(String statsId) {
        return this.getStatsUseCase.getById(statsId);
    }

    @Override
    public List<RsStats> getAll() {
        return this.getStatsUseCase.getAll();
    }

    @Override
    public List<RsStats> getByRequest(String requestId) {
        return this.getStatsUseCase.getAllByRequest(requestId);
    }

    @Override
    public List<RsStats> findByWord(String word) {
        return this.getStatsUseCase.getAllByWord(word);
    }

    @Override
    public List<RsStats> getUnique(String requestId) {
        return this.getStatsUseCase.getAllUnique(requestId);
    }
}
