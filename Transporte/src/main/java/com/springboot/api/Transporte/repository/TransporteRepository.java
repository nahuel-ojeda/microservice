package com.springboot.api.Transporte.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.api.Transporte.entity.Transporte;

@Repository
public interface TransporteRepository extends JpaRepository<Transporte, Long> {

	List<Transporte> findByCantidadDeRuedas(int cantidadDeRuedas);
	
	List<Transporte> findByTipo(String tipo);
	
	Transporte findByCodigo(int codigo);
	
	Transporte findByFechaDeFabricacion(String fechaDeFabricacion);
	
	Transporte findByMarca(String marca);
	
	
}
