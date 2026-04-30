package com.veiculo.Mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.veiculo.dto.FabricanteDTO;
import com.veiculo.entity.Fabricante;

// Camada para facilitar, camada que faz conversões de entidades para DTO ou vice-versa.
public final class FabricanteMapper {

    private FabricanteMapper() {} // Se der erro pode ser aqui

    public static FabricanteDTO toDTO(Fabricante entity) {
        if (entity == null) return null;

        return new FabricanteDTO(
            entity.getId(),
            entity.getNome(),
            entity.getPaisOrigem()
        );
    }

    public static Fabricante toEntity(FabricanteDTO dto) {
        if (dto == null) return null;

        Fabricante f = new Fabricante();
        f.setId(dto.getId());
        f.setNome(dto.getNome());
        f.setPaisOrigem(dto.getPaisOrigem());

        return f;
    }

    public static List<FabricanteDTO> toDtoList(List<Fabricante> list) {
        return list == null
                ? List.of()
                : list.stream()
                      .map(FabricanteMapper::toDTO)
                      .collect(Collectors.toList());
    }

    public static List<Fabricante> toEntityList(List<FabricanteDTO> list) {
        return list == null
                ? List.of()
                : list.stream()
                      .map(FabricanteMapper::toEntity)
                      .collect(Collectors.toList());
    }
}