package com.springboot.api.Empresa.service;

import java.util.List;

import com.springboot.api.Empresa.dto.EmpresaDto;
import com.springboot.api.Empresa.exception.CustomException;

public interface EmpresaService {

	public List<EmpresaDto> findAll() throws CustomException;
	
	public EmpresaDto save(EmpresaDto empresaDto)throws CustomException;
	
	public EmpresaDto getById(Long id)throws CustomException;
	
	void delete (Long id)throws CustomException;
	
	public EmpresaDto update(Long id, EmpresaDto empresaDto)throws CustomException;
	
	public EmpresaDto getbyCodigo(int codigo)throws CustomException;
	
	public EmpresaDto getByRazonSocial(String razonSocial)throws CustomException;
	
}
