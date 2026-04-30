package com.veiculo.repository;
// Pega as camadas e reflete no banco

//  Cliente -- Obejto DTO {JSON} --> Controller --> Service - corversa com --> Entidade --> Repository ---> Banco de Dados 
//                                                    |--> coverte em entidade ou seja é aqui que uso o MAPPER ---> recebe um DTO e converte em entidade para con versar com repository.                                                      
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.veiculo.entity.Fabricante;

@Repository
public interface FabricanteRepository extends JpaRepository <Fabricante, Long> {

    
}