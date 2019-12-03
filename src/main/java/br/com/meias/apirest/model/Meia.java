package br.com.meias.apirest.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter@Setter
@NoArgsConstructor@AllArgsConstructor
@Table(name = "meia")
public class Meia implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "meia_sequence", sequenceName = "meia_seq", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "meia_sequence")
	private int id;
	
	@Column(nullable = false)
	private int tamanho;
	
	@Column(nullable = false)
	private double preco;
	
	@Column(nullable = false)
	private String modelo;
	
	@Column(nullable = false)
	private String status;
	
	@Column(nullable = false)
	private int qnt_estq;
}
