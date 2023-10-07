package com.gus.cursosapi.controller;

import com.gus.cursosapi.dto.RegistroEstudantesResponse;
import com.gus.cursosapi.service.EstudanteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("estudantes")
public class EstudanteController {

    private final EstudanteService estudanteService;

    @PostMapping("upload")
    public ResponseEntity<RegistroEstudantesResponse> registrarEstudantes(@RequestParam("file") MultipartFile arquivo) {
        estudanteService.registrarEstudantes(arquivo);
        var resposta = RegistroEstudantesResponse
                .builder()
                .jobUUID(UUID.randomUUID().toString())
                .mensagem("O processo foi iniciado com sucesso")
                .build();
        return ResponseEntity.ok(resposta);
    }
}
