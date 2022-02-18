package com.testecafe.testecafecolab.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testecafe.testecafecolab.model.CafeModel;
import com.testecafe.testecafecolab.repository.CafeRepository;
import com.testecafe.testecafecolab.service.CafeServices;



@RestController
@RequestMapping("/testecafe/colaborador")
@CrossOrigin("*")
public class CafeController {
	
	
	private @Autowired CafeRepository repositorio;
	private @Autowired CafeServices servicos;
	
	
	
	
	@GetMapping ("/todescolaboradores")
	public ResponseEntity <List<CafeModel>> pegarTodes(){
	
		List<CafeModel> objetoLista = repositorio.findAll();
		
		if (objetoLista.isEmpty()) {
			return ResponseEntity.status(204).build();
		}
		else {
			return ResponseEntity.status(200).body(objetoLista);
		}
	}
	
	
	@PostMapping("/salvar")
	public ResponseEntity<Object> salvar(@Valid @RequestBody CafeModel novoColaborador) {
		Optional <Object> objetoOptional = servicos.cadastrarColaborador(novoColaborador);
		
		
		
		if (objetoOptional.isEmpty()) {
			return ResponseEntity.status(400).build();
			
		}else {
			return ResponseEntity.status(201).body(objetoOptional.get());
		}
		
	}
	
	
	@DeleteMapping ("/deletar/{idColaborador}")
	public void deletarColaboradorPorcpf(@PathVariable(value = "idColaborador") Long idColaborador) {
		repositorio.deleteById(idColaborador);
	}
	
	
	
	@PutMapping ("/atualizar")
	public ResponseEntity<CafeModel> atualizar (@Valid @RequestBody CafeModel colaboradoratt){
	
		return ResponseEntity.status(201).body(repositorio.save(colaboradoratt));
}
	
	
	@GetMapping ("/pegarid/{id_colaborador}")
	
	public ResponseEntity <CafeModel> buscarPorId (@PathVariable (value = "id_colaborador") Long idColaborador){ 
		Optional <CafeModel> objetoUsuarios = repositorio.findById(idColaborador);
		
		if(objetoUsuarios.isPresent()) 
		{
			return ResponseEntity.status(200).body (objetoUsuarios.get());
		}
		else 
		{
			return ResponseEntity.status(204).build();
		}
			
}


		@GetMapping ("/pegarcolaborador/{nome}")
		public ResponseEntity <List<CafeModel>> buscaPorTema(@PathVariable(value = "nome") String cpf){
			List<CafeModel> objetoLista = repositorio.findByNomeColaboradorContainingIgnoreCase(cpf);
	
			if(objetoLista.isEmpty()) {
		return ResponseEntity.status(204).build();
			}
			else {
		return ResponseEntity.status(200).body(objetoLista);
			}
}
	
	
	
	

}
