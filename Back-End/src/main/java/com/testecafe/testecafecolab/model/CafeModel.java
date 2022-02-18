package com.testecafe.testecafecolab.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

@Entity
public class CafeModel {
	
	private @Id @GeneratedValue (strategy = GenerationType.IDENTITY) Long IdColaborador;
	private @NotBlank String nomeColaborador;
	private @NotBlank @CPF @Size(min = 11, max = 11) String cpf;
	private @NotBlank String opcao1;
	private @NotBlank String opcao2;
	
	
	public Long getIdColaborador() {
		return IdColaborador;
	}
	public void setIdColaborador(Long idColaborador) {
		IdColaborador = idColaborador;
	}
	public String getNomeColaborador() {
		return nomeColaborador;
	}
	public void setNomeColaborador(String nomeColaborador) {
		this.nomeColaborador = nomeColaborador;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getOpcao1() {
		return opcao1;
	}
	public void setOpcao1(String opcao1) {
		this.opcao1 = opcao1;
	}
	public String getOpcao2() {
		return opcao2;
	}
	public void setOpcao2(String opcao2) {
		this.opcao2 = opcao2;
	}

}
