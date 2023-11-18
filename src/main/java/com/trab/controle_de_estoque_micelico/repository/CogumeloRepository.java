package com.trab.controle_de_estoque_micelico.repository;

import com.avn2.estoque_cogumelos.Cogumelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CogumeloRepository extends JpaRepository<Cogumelo, Long> {
}
