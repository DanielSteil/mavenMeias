package br.com.meias.apirest.service;


import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import br.com.meias.apirest.model.Meia;
import br.com.meias.apirest.repository.MeiaRepository;

@Service
public class MeiaService {
 
	@Inject
	private MeiaRepository mr;
	
	public Meia save(Meia meia) {
		return mr.save(meia);
	}
	
	public List<Meia> findAll(){
		return mr.findAll();
	}		
	
	public void delete(Meia meia){
		mr.deleteById(meia.getId());
	}
	
	public Meia update(Meia meia) {
		return mr.save(meia);
	}
}
