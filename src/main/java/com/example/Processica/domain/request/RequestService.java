package com.example.Processica.domain.request;

import com.example.Processica.data.entity.ERequest;
import com.example.Processica.presentation.dto.RsRequest;

import java.util.List;

public interface RequestService {
    List<RsRequest> getAll();

    RsRequest getById(String requestId);

    RsRequest save(String request);

    String remove(String requestId);
}
