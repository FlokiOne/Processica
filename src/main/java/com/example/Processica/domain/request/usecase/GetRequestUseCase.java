package com.example.Processica.domain.request.usecase;

import com.example.Processica.data.entity.ERequest;
import com.example.Processica.data.repository.RequestRepository;
import com.example.Processica.domain.mapper.Mapper;
import com.example.Processica.presentation.dto.RsRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GetRequestUseCase {

    private final RequestRepository repository;
    private final Mapper mapper;

    private static final Logger logger = LoggerFactory.getLogger(GetRequestUseCase.class);

    @Autowired
    GetRequestUseCase(RequestRepository repository, Mapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<RsRequest> getAll() {
        return this.repository.findAll().stream().map(this.mapper::requestToDTO).collect(Collectors.toList());
    }

    public RsRequest getById(String requestId) {
            ERequest request = this.repository.findById(requestId).get();
            return this.mapper.requestToDTO(request);
    }

}
