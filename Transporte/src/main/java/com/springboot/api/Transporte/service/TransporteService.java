package com.springboot.api.Transporte.service;

import java.util.List;

import com.springboot.api.Transporte.dto.TransporteDto;
import com.springboot.api.Transporte.exception.CustomException;

public interface TransporteService {

	List<TransporteDto> findAll()throws CustomException ;
	List<TransporteDto> getByCantidadDeRuedas(int cantidadDeRuedas)throws CustomException ;
	List<TransporteDto> getByTipo(String tipo)throws CustomException ;
	
	TransporteDto getByCodigo(int codigo)throws CustomException ;
	TransporteDto getByFechaDeFabricacion(String fechaDeFabricacion)throws CustomException ;
	TransporteDto getByMarca(String marca)throws CustomException ;
	
	
}
