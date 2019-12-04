package br.com.meias.apirest.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.meias.apirest.dto.MeiaDTO;
import br.com.meias.apirest.model.Meia;

public interface MeiaRepositoryCustom {
	
	Page<Meia> consultaFiltro(MeiaDTO meia ,Pageable pageable);
	
	public Meia findById(int id);
}
