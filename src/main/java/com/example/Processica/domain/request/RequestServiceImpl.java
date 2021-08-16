package com.example.Processica.domain.request;

import com.example.Processica.domain.request.usecase.GetRequestUseCase;
import com.example.Processica.domain.request.usecase.RemoveUseCase;
import com.example.Processica.domain.request.usecase.SaveUseCase;
import com.example.Processica.presentation.dto.RsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestServiceImpl implements RequestService {

    private final GetRequestUseCase getRequestUseCase;
    private final RemoveUseCase removeUseCase;
    private final SaveUseCase saveUseCase;

    @Autowired
    RequestServiceImpl(GetRequestUseCase getRequestUseCase, RemoveUseCase removeUseCase, SaveUseCase saveUseCase) {
        this.getRequestUseCase = getRequestUseCase;
        this.removeUseCase = removeUseCase;
        this.saveUseCase = saveUseCase;
    }

    @Override
    public List<RsRequest> getAll() {
        return this.getRequestUseCase.getAll();
    }

    @Override
    public RsRequest getById(String requestId) {
        return this.getRequestUseCase.getById(requestId);
    }

    @Override
    public RsRequest save(String payload) {
        return this.saveUseCase.save(payload);
    }

    @Override
    public String remove(String requestId) {
        return this.removeUseCase.removeRequest(requestId);
    }

}
