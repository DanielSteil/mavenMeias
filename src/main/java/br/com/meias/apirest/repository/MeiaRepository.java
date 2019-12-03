package br.com.meias.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.meias.apirest.model.Meia;

@Repository
public interface MeiaRepository extends JpaRepository<Meia, Integer>, MeiaRepositoryCustom{

}
