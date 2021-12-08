package com.spring.api.Logistica.feignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.api.Logistica.dto.EmpleadoDto;

@FeignClient(name = "Empleados", url = "http://localhost:8081")
public interface EmpleadoClient {

	@RequestMapping(method = RequestMethod.GET, value= "/empleados/getAll")
	List<EmpleadoDto>getAll();
	
	@RequestMapping(method = RequestMethod.GET, value= "/empleados/dni/{valor}")
	EmpleadoDto getByDni(@PathVariable("valor") int codigo);
	
	@RequestMapping(method = RequestMethod.GET, value= "/empleados/apellido/{valor}")
	EmpleadoDto getByApellido(@PathVariable("valor") String razonSocial);
	
}
