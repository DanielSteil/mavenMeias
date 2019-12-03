package br.com.meias.apirest.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.meias.apirest.model.Meia;
import br.com.meias.apirest.repository.MeiaRepository;
import br.com.meias.apirest.service.MeiaService;
import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/apiMeia")
@Api(value = "ApiRest Meia")
@CrossOrigin(origins = "*")
public class MeiaController {
	
	@Inject
	MeiaService ms;

	@GetMapping("/meias")
	public List<Meia> buscaTodas(){
		return ms.findAll();
	}
	
	@PostMapping("/meia")
	public Meia salvaMeia(Meia meia) {
		return ms.save(meia);
	}
	
	
}
