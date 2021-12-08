package com.spring.api.Logistica.service;

import java.util.List;

import com.spring.api.Logistica.dto.EmpleadoDto;
import com.spring.api.Logistica.dto.EmpresaDto;
import com.spring.api.Logistica.dto.TransporteDto;
import com.spring.api.Logistica.exception.CustomException;

public interface LogisticaService {

	public List<EmpresaDto> listaEmpresas() throws CustomException;

	public EmpresaDto getByCodigoEmpresa(int codigo) throws CustomException;

	public EmpresaDto getByRazonSocial(String razonSocial) throws CustomException;

//////////////////////////////////////////////////////////////////////////////////

	public List<EmpleadoDto> listaEmpleados() throws CustomException;

	public EmpleadoDto getByDni(int dni) throws CustomException;

	public EmpleadoDto getByApellido(String apellido) throws CustomException;

/////////////////////////////////////////////////////////////////////////////////

	public List<TransporteDto> listaTransporte() throws CustomException;
	
	public TransporteDto getByCodigoVehiculo(int codigo) throws CustomException;
	
	public TransporteDto getByMarca(String marca)throws CustomException;
	
}
