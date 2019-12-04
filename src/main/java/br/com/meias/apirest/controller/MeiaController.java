package br.com.meias.apirest.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.meias.apirest.model.Meia;
import br.com.meias.apirest.service.MeiaService;

@RestController
@RequestMapping("apiMeia")
public class MeiaController {
	
	@Inject
	MeiaService ms;

	@GetMapping("/meias")
	public List<Meia> buscaTodas(){
		return ms.findAll();
	}
	
	@PostMapping("/meia")
	public Meia salvaMeia(@RequestBody Meia meia) {
		return ms.save(meia);
	}
	
	@DeleteMapping("/meia")
	public void deletaMeia(@RequestBody Meia meia) {
		ms.delete(meia);
	}
	
	@PutMapping("/meia")
	public Meia atualizaMeia(@RequestBody Meia meia) {
		return ms.update(meia);
	}
	
}
