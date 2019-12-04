package br.com.meias.apirest.dto;

import java.io.Serializable;

import br.com.meias.apirest.model.Meia;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MeiaDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	
	private int id;
	private int tamanho;
	private double preco;
	private String modelo;
	private String status;
	private int qnt_estq;
	
	public static MeiaDTO fromEntity(Meia meia) {
	    // @formatter:off
		MeiaDTO dto = new MeiaDTO()
			.withId(meia.getId())
	        .withTamanho(meia.getTamanho())
	        .withPreco(meia.getPreco())
	        .withModelo(meia.getModelo())
	        .withStatus(meia.getStatus())
	        .withQnt_estq(meia.getQnt_estq());
	    // @formatter:on
	    return dto;
	}
	
	MeiaDTO withId(int id) {
		this.id = id;
		return this;
	}
	
	MeiaDTO withTamanho(int tamanho) {
		this.tamanho = tamanho;
		return this;
	}
	
	MeiaDTO withPreco(double preco) {
		this.preco = preco;
		return this;
	}
	
	MeiaDTO withModelo(String modelo) {
		this.modelo = modelo;
		return this;
	}
	
	MeiaDTO withStatus(String status) {
		this.status = status;
		return this;
	}
	
	MeiaDTO withQnt_estq(int qnt_estq) {
		this.qnt_estq = qnt_estq;
		return this;
	}
}
