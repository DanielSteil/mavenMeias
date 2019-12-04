package br.com.meias.apirest.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.querydsl.jpa.impl.JPAQuery;

import br.com.meias.apirest.dto.MeiaDTO;
import br.com.meias.apirest.model.Meia;
import br.com.meias.apirest.model.QMeia;

public class MeiaRepositoryImpl implements MeiaRepositoryCustom{

	
	@PersistenceContext
	EntityManager em;
	
	private QMeia meia = QMeia.meia;
	
	@Override
	public Meia findById(int id) {
		return null;
	}

	@Override
	public Page<Meia> consultaFiltro(MeiaDTO meiaFiltro, Pageable pageable) {
		JPAQuery<Meia> query = new JPAQuery<Meia>(em);
		query.from(meia);
		
		long totalMeias = 0;
		// FILTRO MODELO
		if (meiaFiltro.getModelo() != null && !meiaFiltro.getModelo().equals("")) query.where(meia.modelo.eq(meiaFiltro.getModelo()));
		// FILTRO PRECO
		if (meiaFiltro.getPreco() != 0) query.where(meia.preco.eq(meiaFiltro.getPreco()));
		// FILTRO STATUS
		if (meiaFiltro.getStatus() != null && !meiaFiltro.getStatus().equals("")) query.where(meia.status.eq(meiaFiltro.getStatus()));
		// FILTRO TAMANHO
		if (meiaFiltro.getTamanho() != 0) query.where(meia.tamanho.eq(meiaFiltro.getTamanho()));
		
		totalMeias = query.fetchCount();
		query.limit(pageable.getPageSize());
		query.offset(pageable.getPageSize() * pageable.getPageNumber());
		
//		query.select(Projections.constructor(AvaliacaoShort.class, avaliacao.aplicacao, avaliacao.usuario));

		return new PageImpl<Meia>(query.fetch(),pageable, totalMeias);
	}

}
