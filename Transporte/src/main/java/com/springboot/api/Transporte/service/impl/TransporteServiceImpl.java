package com.springboot.api.Transporte.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.api.Transporte.convert.Convert;
import com.springboot.api.Transporte.dto.TransporteDto;
import com.springboot.api.Transporte.entity.Transporte;
import com.springboot.api.Transporte.exception.CustomException;
import com.springboot.api.Transporte.repository.TransporteRepository;
import com.springboot.api.Transporte.service.TransporteService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TransporteServiceImpl implements TransporteService {

	@Autowired
	private TransporteRepository transporteRepository;

	@Autowired
	private Convert convert;

	@Override
	public List<TransporteDto> findAll() throws CustomException {
		log.info("Response.......");
		List<Transporte> response = transporteRepository.findAll();
		log.info("Response" + response);
		return convert.listaEntityAdto(response);
	}

	@Override
	public List<TransporteDto> getByCantidadDeRuedas(int cantidadDeRuedas) throws CustomException {
		log.info("Request Repository: {}" + cantidadDeRuedas);
		List<Transporte> response = transporteRepository.findByCantidadDeRuedas(cantidadDeRuedas);
		log.info("Response" + response);
		return convert.listaEntityAdto(response);
	}

	@Override
	public TransporteDto getByCodigo(int codigo) throws CustomException {
		log.info("Request Response" + codigo);
		Transporte Transporte = transporteRepository.findByCodigo(codigo);
		return convert.entityAdto(Transporte);
	}

	@Override
	public TransporteDto getByFechaDeFabricacion(String fechaDeFabricacion) throws CustomException {
		log.info("Request Repository: {}" + fechaDeFabricacion);
		Transporte response = transporteRepository.findByFechaDeFabricacion(fechaDeFabricacion);
		log.info("Response" + response);
		return convert.entityAdto(response);
	}

	@Override
	public TransporteDto getByMarca(String marca) throws CustomException {
		log.info("Request Repository: {}" + marca);
		Transporte response = transporteRepository.findByMarca(marca);
		log.info("Response" + response);
		return convert.entityAdto(response);
	}

	@Override
	public List<TransporteDto> getByTipo(String tipo) throws CustomException {
		log.info("Request Repository: {}" + tipo);
		List<Transporte> response = transporteRepository.findByTipo(tipo);
		log.info("Response" + response);
		return convert.listaEntityAdto(response);
	}

}
