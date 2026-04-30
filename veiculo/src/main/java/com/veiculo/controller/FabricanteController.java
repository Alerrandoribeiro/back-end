package com.veiculo.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.veiculo.dto.FabricanteDTO;
import com.veiculo.service.FabricanteService;

@RestController
@RequestMapping("/api/fabricantes")
public class FabricanteController {
    
    @Autowired
    private FabricanteService service;

    @PostMapping
    public ResponseEntity<FabricanteDTO> criar(@RequestBody FabricanteDTO dto){
         
        // chama o service para criar
        FabricanteDTO criado = service.criar(dto);

       
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(criado.getId())
            .toUri();

        return ResponseEntity.created(location).body(criado);
    }
}