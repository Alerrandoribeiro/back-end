package com.veiculo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veiculo.Mapper.FabricanteMapper;
import com.veiculo.dto.FabricanteDTO;
import com.veiculo.entity.Fabricante;
import com.veiculo.repository.FabricanteRepository;

@Service
public class FabricanteService {
    
    @Autowired
    private FabricanteRepository repository;

    public FabricanteDTO criar(FabricanteDTO dto){
      
        Fabricante salvo = repository.save(FabricanteMapper.toEntity(dto)); // tipo entidade
        return FabricanteMapper.toDTO(salvo); // convertendo para DTO
    }
}
