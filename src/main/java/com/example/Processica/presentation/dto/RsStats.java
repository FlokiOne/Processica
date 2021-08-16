package com.example.Processica.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RsStats {
    private String statsId;
    private String requestId;
    private String word;
    private Integer entry;
}
