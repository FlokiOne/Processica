package com.example.Processica.domain.mapper;

import com.example.Processica.data.entity.ERequest;
import com.example.Processica.data.entity.EStats;
import com.example.Processica.presentation.dto.RsRequest;
import com.example.Processica.presentation.dto.RsStats;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    private final ModelMapper modelMapper;

    @Autowired
    Mapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public RsRequest requestToDTO(ERequest request) {
        return modelMapper.map(request, RsRequest.class);
    }

    public RsStats statsToDTO(EStats stats) {
        return modelMapper.map(stats, RsStats.class);
    }
}
