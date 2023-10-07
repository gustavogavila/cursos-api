package com.gus.cursosapi.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegistroEstudantesResponse {
    private String jobUUID;
    private String mensagem;
}
