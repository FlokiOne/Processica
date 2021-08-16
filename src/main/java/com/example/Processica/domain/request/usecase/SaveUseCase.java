package com.example.Processica.domain.request.usecase;

import com.example.Processica.data.entity.ERequest;
import com.example.Processica.data.entity.EStats;
import com.example.Processica.data.repository.RequestRepository;
import com.example.Processica.data.repository.StatsRepository;
import com.example.Processica.domain.mapper.Mapper;
import com.example.Processica.presentation.dto.RsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Component
public class SaveUseCase {

    private final RequestRepository requestRepository;
    private final StatsRepository statsRepository;
    private final Mapper mapper;

    @Autowired
    SaveUseCase(RequestRepository requestRepository, StatsRepository statsRepository, Mapper mapper) {
        this.requestRepository = requestRepository;
        this.statsRepository = statsRepository;
        this.mapper = mapper;
    }

    public RsRequest save(String payload) {
        ERequest request = this.requestRepository.save(new ERequest(payload));
        Map<String, Integer> words = new HashMap<>();
        String currentText = payload.replaceAll("[!?,]", " ").toLowerCase(Locale.ROOT);
        for (String word : currentText.split("\\s+")) {
            Integer count = words.get(word);
            if (count == null) {
                count = 0;
            }
            words.put(word, count + 1);
        }
        words.forEach((word, count) -> this.statsRepository.save(new EStats(request, word, count)));
        return this.mapper.requestToDTO(request);
    }

}
