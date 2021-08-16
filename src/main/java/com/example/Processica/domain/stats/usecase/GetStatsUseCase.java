package com.example.Processica.domain.stats.usecase;

import com.example.Processica.data.entity.EStats;
import com.example.Processica.data.repository.StatsRepository;
import com.example.Processica.domain.mapper.Mapper;
import com.example.Processica.presentation.dto.RsStats;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GetStatsUseCase {

    private final StatsRepository repository;
    private final Mapper mapper;

    private static final Logger logger = LoggerFactory.getLogger(com.example.Processica.domain.request.usecase.GetRequestUseCase.class);

    @Autowired
    GetStatsUseCase(StatsRepository repository, Mapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public RsStats getById(String statsId) {
        EStats stats = this.repository.findById(statsId)
                .orElseThrow(NullPointerException::new);
        return this.mapper.statsToDTO(stats);
    }

    public List<RsStats> getAll() {
        return this.repository.findAll().stream().map(this.mapper::statsToDTO).collect(Collectors.toList());
    }

    public List<RsStats> getAllUnique(String requestId) {
        return this.repository.findAllUnique(requestId).stream().map(this.mapper::statsToDTO).collect(Collectors.toList());
    }

    public List<RsStats> getAllByRequest(String requestId) {
        return this.repository.findAllByRequest(requestId).stream().map(this.mapper::statsToDTO).collect(Collectors.toList());
    }

    public List<RsStats> getAllByWord(String word) {
        return this.repository.findAllByWord(word).stream().map(this.mapper::statsToDTO).collect(Collectors.toList());
    }
}
