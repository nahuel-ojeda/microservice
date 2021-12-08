package com.spring.api.Logistica.feignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.api.Logistica.dto.TransporteDto;

@FeignClient(name = "Transporte", url = "http://localhost:8083")
public interface TransporteClient {

	@RequestMapping(method = RequestMethod.GET, value= "/transporte/getAll")
	List<TransporteDto>getAll();
	
	@RequestMapping(method = RequestMethod.GET, value= "/transporte/codigo/{valor}")
	TransporteDto getByCodigo(@PathVariable("valor") int codigo);
	
	@RequestMapping(method = RequestMethod.GET, value= "/transporte/marca/{valor}")
	TransporteDto getByMarca(@PathVariable("valor") String marca);
}
