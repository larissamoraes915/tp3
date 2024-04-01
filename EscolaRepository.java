package br.edu.infnet.larissa.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.larissa.model.domain.Escola;

@Repository
public interface EscolaRepository extends JpaRepository<Escola, Integer> {

}