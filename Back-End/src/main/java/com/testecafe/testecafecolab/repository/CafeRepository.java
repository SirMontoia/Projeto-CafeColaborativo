package com.testecafe.testecafecolab.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testecafe.testecafecolab.model.CafeModel;

@Repository
public interface CafeRepository extends JpaRepository <CafeModel, Long> {

	public Optional<CafeModel> findByCpfContainingIgnoreCase (String cpf);
	public Optional<CafeModel> findByOpcao1ContainingIgnoreCase (String cpf);
	public Optional<CafeModel> findByOpcao2ContainingIgnoreCase (String cpf);
	public List<CafeModel> findByNomeColaboradorContainingIgnoreCase (String cpf);
	
	
	
}
