package com.spring.api.Logistica.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.api.Logistica.dto.EmpleadoDto;
import com.spring.api.Logistica.dto.EmpresaDto;
import com.spring.api.Logistica.dto.TransporteDto;
import com.spring.api.Logistica.exception.CustomException;
import com.spring.api.Logistica.feignClient.EmpleadoClient;
import com.spring.api.Logistica.feignClient.EmpresaClient;
import com.spring.api.Logistica.feignClient.TransporteClient;
import com.spring.api.Logistica.service.LogisticaService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LogisticaServiceImpl implements LogisticaService {

	@Autowired
	private EmpresaClient empresaClient;

	@Autowired
	private EmpleadoClient empleadoClient;

	@Autowired
	private TransporteClient transporteClient;

	
	@Override
	public List<EmpresaDto> listaEmpresas() throws CustomException {
		log.info("Response.....");
		List<EmpresaDto> dto = empresaClient.getAll();
		log.info("Response:{}" + dto);
		return dto;
	}

	@Override
	public EmpresaDto getByCodigoEmpresa(int codigo) throws CustomException {
		log.info("Response.....");
		EmpresaDto dto = empresaClient.getByCodigo(codigo);
		log.info("Response:{}" + dto);
		return dto;
	}

	@Override
	public EmpresaDto getByRazonSocial(String razonSocial) throws CustomException {
		log.info("Response.....");
		EmpresaDto dto = empresaClient.getByRazonSocial(razonSocial);
		log.info("Response:{}" + dto);
		return dto;
	}
/////////////////////////////////////////////////////////////////////

	@Override
	public List<EmpleadoDto> listaEmpleados() throws CustomException {
		log.info("Response.....");
		List<EmpleadoDto> dto = empleadoClient.getAll();
		log.info("Response:{}" + dto);
		return dto;
	}

	@Override
	public EmpleadoDto getByDni(int dni) throws CustomException {
		log.info("Response.....");
		EmpleadoDto dto = empleadoClient.getByDni(dni);
		log.info("Response:{}" + dto);
		return dto;
	}

	@Override
	public EmpleadoDto getByApellido(String apellido) throws CustomException {
		log.info("Response.....");
		EmpleadoDto dto = empleadoClient.getByApellido(apellido);
		log.info("Response:{}" + dto);
		return dto;

	}

/////////////////////////////////////////////////////////////////////

	@Override
	public List<TransporteDto> listaTransporte() throws CustomException {
		log.info("Response.....");
		List<TransporteDto> dto = transporteClient.getAll();
		log.info("Response:{}" + dto);
		return dto;
	}

	@Override
	public TransporteDto getByCodigoVehiculo(int codigo) throws CustomException {
		log.info("Response.....");
		TransporteDto dto = transporteClient.getByCodigo(codigo);
		log.info("Response:{}" + dto);
		return dto;
	}

	@Override
	public TransporteDto getByMarca(String marca) throws CustomException {
		log.info("Response.....");
		TransporteDto dto = transporteClient.getByMarca(marca);
		log.info("Response:{}" + dto);
		return dto;
	}

}
