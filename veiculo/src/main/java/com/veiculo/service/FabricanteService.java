package com.veiculo.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.veiculo.Mapper.FabricanteMapper;
import com.veiculo.dto.FabricanteDTO;
import com.veiculo.entity.Fabricante;
import com.veiculo.repository.FabricanteRepository;

import jakarta.transaction.Transactional;

@Service
public class FabricanteService {

    @Autowired
    private FabricanteRepository repository;

    public FabricanteDTO criar(FabricanteDTO dto) {

        /* if (dto.getId() != null) {
            //throw new ValidationException("id", "Novo fabricante não deve ter ID.");
        }
        if (repository.existsByNome(dto.getNome())) {
          //  throw new ResourceAlreadyExistsException("Fabricante", "nome", dto.getNome());
         */

        Fabricante salvo = repository.save(FabricanteMapper.toEntity(dto)); // tipo entidade
        return FabricanteMapper.toDTO(salvo); // convertendo para DTO
    }

    @Transactional()
    public List<FabricanteDTO> listar(){
        return FabricanteMapper.toDtoList(repository.findAll());
    }

    @Transactional()
    public FabricanteDTO buscarPorId(Long id){
        return repository.findById(id)
        .map(FabricanteMapper::toDTO)
        .orElseThrow(() -> new NoSuchElementException("Fabricante não encontrado com o id: " + id));
    }

    @Transactional()
    public FabricanteDTO atualizar(Long id, FabricanteDTO dto){
        Fabricante existente = repository.findById(id).orElseThrow(() -> new NoSuchElementException("Fabricante não encontrado com o id: " + id));
        existente.setNome(dto.getNome());
        existente.setPaisOrigem(dto.getPaisOrigem());
        return FabricanteMapper.toDTO(repository.save(existente));
    }
    
    @Transactional()
    public void deletar (Long id){

        if(!repository.existsById(id)){

            throw new NoSuchElementException("Fabricante não encontrado com o id: " + id);
        }
       repository.deleteById(id);
    }
}
