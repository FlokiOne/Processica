package com.example.Processica.domain.request.usecase;

import com.example.Processica.data.repository.RequestRepository;
import com.example.Processica.data.repository.StatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RemoveUseCase {

    private final RequestRepository requestRepository;
    private final StatsRepository statsRepository;

    @Autowired
    RemoveUseCase(RequestRepository requestRepository, StatsRepository statsRepository) {
        this.requestRepository = requestRepository;
        this.statsRepository = statsRepository;
    }

    public String removeRequest(String requestId) {
        this.requestRepository.deleteById(requestId);
        this.statsRepository.deleteAllByRequest(requestId);
        return requestId;
    }
}
