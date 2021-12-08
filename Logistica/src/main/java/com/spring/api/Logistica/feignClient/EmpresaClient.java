package com.spring.api.Logistica.feignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.api.Logistica.dto.EmpresaDto;

@FeignClient(name ="Empresas",url = "http://localhost:8082")
public interface EmpresaClient {
	
	@RequestMapping(method = RequestMethod.GET, value = "/empresas/getAll")
	List<EmpresaDto>getAll();
	
	@RequestMapping(method = RequestMethod.GET, value= "/empresas/codigo/{valor}")
	EmpresaDto getByCodigo(@PathVariable("valor") int codigo);
	
	@RequestMapping(method = RequestMethod.GET, value= "/empresas/razonSocial/{valor}")
	EmpresaDto getByRazonSocial(@PathVariable("valor") String razonSocial);
}
