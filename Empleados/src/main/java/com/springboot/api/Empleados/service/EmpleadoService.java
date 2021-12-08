package com.springboot.api.Empleados.service;

import java.util.List;

import com.springboot.api.Empleados.dto.EmpleadoDto;
import com.springboot.api.Empleados.exception.CustomException;

public interface EmpleadoService {

	public List<EmpleadoDto> findAll()throws CustomException;
	
	public EmpleadoDto save(EmpleadoDto empleadoDto)throws CustomException;
	
	public EmpleadoDto getById(Long id)throws CustomException;
	
	void delete (Long id)throws CustomException;
	
	public EmpleadoDto update (Long id, EmpleadoDto empleadoDto)throws CustomException;
	
	public EmpleadoDto getByDni(int dni)throws CustomException;
	
	public EmpleadoDto getByApellido(String apellido)throws CustomException;
	
}
