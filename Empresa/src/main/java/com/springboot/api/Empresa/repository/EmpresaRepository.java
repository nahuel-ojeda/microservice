package com.springboot.api.Empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.api.Empresa.entity.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

	Empresa findByCodigo(int codigo);
	Empresa findByRazonSocial(String razonSocial);
	
}
