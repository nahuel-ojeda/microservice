package com.springboot.api.Empresa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.api.Empresa.exception.CustomException;
import com.springboot.api.Empresa.convert.Convert;
import com.springboot.api.Empresa.dto.EmpresaDto;
import com.springboot.api.Empresa.entity.Empresa;
import com.springboot.api.Empresa.repository.EmpresaRepository;
import com.springboot.api.Empresa.service.EmpresaService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmpresaServiceImpl implements EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;

	@Autowired
	private Convert convert;

	@Override
	public List<EmpresaDto> findAll() throws CustomException {
		log.info("Response.....");
		List<Empresa> response = empresaRepository.findAll();
		log.info("Response: {}" + response);
		return convert.listaEntityAdto(response);
	}

	@Override
	public EmpresaDto save(EmpresaDto empresaDto) throws CustomException {
		log.info("Request Repository: {}" + empresaDto);
		Empresa empresa = convert.dtoAentity(empresaDto);
		empresa = empresaRepository.save(empresa);
		return convert.entityAdto(empresa);
	}

	@Override
	public EmpresaDto getById(Long id) throws CustomException {
		log.info("Request Repository: {}" + id);
		Optional<Empresa> optional = empresaRepository.findById(id);
		Empresa empresa = optional.get();
		return convert.entityAdto(empresa);
	}

	@Override
	public void delete(Long id) throws CustomException {
		log.info("Request Response" + id);
		empresaRepository.deleteById(id);
		log.info("borrado.....");
	}

	@Override
	public EmpresaDto update(Long id, EmpresaDto empresaDto) throws CustomException {
		log.info("Request Response" + id + empresaDto);
		if (empresaRepository.findById(id).isPresent()) {
			Empresa empresa = empresaRepository.findById(id).get();
			empresa.setCodigo(empresaDto.getCodigo());
			empresa.setRazonSocial(empresa.getRazonSocial());
			empresa.setTipoProducto(empresaDto.getTipoProducto());

			Empresa update = empresaRepository.save(empresa);
			return convert.entityAdto(update);
		} else {
			return null;
		}
	}

	@Override
	public EmpresaDto getbyCodigo(int codigo) throws CustomException {
		log.info("Request Response" + codigo);
		Empresa empresa = empresaRepository.findByCodigo(codigo);
		return convert.entityAdto(empresa);
	}

	@Override
	public EmpresaDto getByRazonSocial(String razonSocial) throws CustomException {
		log.info("Request Response" + razonSocial);
		Empresa empresa = empresaRepository.findByRazonSocial(razonSocial);
		return convert.entityAdto(empresa);
	}
}
