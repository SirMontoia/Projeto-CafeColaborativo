package com.testecafe.testecafecolab.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testecafe.testecafecolab.model.CafeModel;
import com.testecafe.testecafecolab.repository.CafeRepository;



@Service
public class CafeServices {

	
	private @Autowired CafeRepository repositorio;

	public Optional<?> alterarColaborador(CafeModel attcolaborador) {
		return repositorio.findById(attcolaborador.getIdColaborador()).map(colaboradorexistente -> {

			colaboradorexistente.setNomeColaborador(attcolaborador.getNomeColaborador());
			colaboradorexistente.setCpf(attcolaborador.getCpf());
			colaboradorexistente.setOpcao1(attcolaborador.getOpcao1());
			colaboradorexistente.setOpcao2(attcolaborador.getOpcao2());

			return Optional.ofNullable(repositorio.save(colaboradorexistente));

		}).orElseGet(() -> {
			return Optional.empty();
		});
	}
	
	
	public Optional<Object> cadastrarColaborador(CafeModel cadastroColaborador) {
		return repositorio.findByCpfContainingIgnoreCase(cadastroColaborador.getCpf()).map(usuarioExistente -> {
			return Optional.empty();
		}).orElseGet(() -> {
			
			
		return repositorio.findByOpcao1ContainingIgnoreCase(cadastroColaborador.getOpcao1()).map(usuarioExistente -> {
			return Optional.empty();
		}).orElseGet(() -> {
			
			
			return repositorio.findByOpcao2ContainingIgnoreCase(cadastroColaborador.getOpcao2()).map(usuarioExistente ->{
				return Optional.empty();
			}).orElseGet(() ->{
				
				return Optional.ofNullable(repositorio.save(cadastroColaborador));
			
			});
			});
		});
	}
	
	
	
}
