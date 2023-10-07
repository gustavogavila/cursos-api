package com.gus.cursosapi.service;

import com.gus.cursosapi.domain.Estudante;
import com.gus.cursosapi.repository.EstudanteRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EstudanteService {

    String[] HEADERS = {"nome", "email", "cursos_ids"};
    private final EstudanteRepository estudantesRepository;

    public void registrarEstudantes(MultipartFile arquivo) {

        try {
            Reader in = new InputStreamReader(arquivo.getInputStream());
            CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                    .setHeader(HEADERS)
                    .setSkipHeaderRecord(true)
                    .build();

            List<Estudante> novosEstudantes = new ArrayList<>();

            Iterable<CSVRecord> linhas = csvFormat.parse(in);

            for (CSVRecord linha : linhas) {
                novosEstudantes.add(
                        new Estudante(null, linha.get("nome"), linha.get("email"), OffsetDateTime.now(), List.of())
                );
            }

            estudantesRepository.saveAll(novosEstudantes);

        } catch (IOException e) {
            throw new RuntimeException("falha ao processar arquivo CSV");
        }
    }
}
