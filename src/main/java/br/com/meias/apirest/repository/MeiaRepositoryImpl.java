package br.com.meias.apirest.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.querydsl.jpa.impl.JPAQuery;

import br.com.meias.apirest.model.Meia;

public class MeiaRepositoryImpl implements MeiaRepositoryCustom{

	
	@PersistenceContext
	EntityManager em;
	
	private QMeia meia = QMeia.meia;
	
	@Override
	public Meia findById(int id) {
		return null;
	}

	@Override
	public Page<Meia> consultaFiltro(Meia meiaFiltro, Pageable pageable) {
		JPAQuery<Meia> query = new JPAQuery<Meia>(em);
		query.from(meia);
		
		long totalAvaliacoes = 0;
		// FILTRO APLICAÇÃO
		if (meiaFiltro.getModelo() != null && !meiaFiltro.getModelo().equals("")) query.where(meia.eq(meiaFiltro.getModelo()));
		// FILTRO NOTA
		if (meiaFiltro.getPreco() != 0) query.where(meia.preco.eq(meiaFiltro.getPreco()));
		// FILTRO USUARIO
		if (meiaFiltro.getStatus() != null && !meiaFiltro.getStatus().equals("")) query.where(meia.usuario.eq(meiaFiltro.getStatus()));
		// FILTRO DATA
		if (meiaFiltro.getTamanho() != 0) query.where(meia.dataAvaliacao.eq(meiaFiltro.getTamanho()));
		
		totalAvaliacoes = query.fetchCount();
		query.limit(pageable.getPageSize());
		query.offset(pageable.getPageSize() * pageable.getPageNumber());
		
//		query.select(Projections.constructor(AvaliacaoShort.class, avaliacao.aplicacao, avaliacao.usuario));

		return new PageImpl<Meia>(query.fetch(),pageable, totalAvaliacoes);
	}

}
