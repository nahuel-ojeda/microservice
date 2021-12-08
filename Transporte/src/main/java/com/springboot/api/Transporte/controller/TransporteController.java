package com.springboot.api.Transporte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.api.Transporte.dto.TransporteDto;
import com.springboot.api.Transporte.exception.CustomException;
import com.springboot.api.Transporte.service.TransporteService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/transporte")
@Slf4j
public class TransporteController {

	@Autowired
	private TransporteService transporteService;
	
	@ApiOperation(value = "Lista completa de transporte", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ok"),
			@ApiResponse(code = 401, message = "no autorizado para este recurso"),
			@ApiResponse(code = 403, message = "el acceso al recurso perdido"),
			@ApiResponse(code = 404, message = "recurso no encontrado"), })
	@GetMapping("/getAll")
	ResponseEntity<List<TransporteDto>> getAll()throws CustomException {
		List<TransporteDto> reponse = transporteService.findAll();
		log.info("Request: {} " + reponse);
		return new ResponseEntity<List<TransporteDto>>(reponse, HttpStatus.OK);
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	@ApiOperation(value = "Lista de transporte por cantidad de ruedas", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ok"),
			@ApiResponse(code = 401, message = "no autorizado para este recurso"),
			@ApiResponse(code = 403, message = "el acceso al recurso perdido"),
			@ApiResponse(code = 404, message = "recurso no encontrado"), })
	@GetMapping("/cantidadDeRuedas")
	public ResponseEntity<List<TransporteDto>> cantidadDeRuedas(@RequestParam int cantidadDeRuedas)throws CustomException {
		log.info("Request: {} " + cantidadDeRuedas);
		return new ResponseEntity<List<TransporteDto>>(transporteService.getByCantidadDeRuedas(cantidadDeRuedas), HttpStatus.OK);
	}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	@ApiOperation(value = "Transporte por fecha de fabricacion", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ok"),
			@ApiResponse(code = 401, message = "no autorizado para este recurso"),
			@ApiResponse(code = 403, message = "el acceso al recurso perdido"),
			@ApiResponse(code = 404, message = "recurso no encontrado"), })
	@GetMapping("/fechaDeFabricacion")
	public ResponseEntity <TransporteDto> fechaDeFabricacion(@RequestParam String fechaDeFabricacion)throws CustomException {
		log.info("Request: {} " + fechaDeFabricacion);
		return new ResponseEntity<TransporteDto>(transporteService.getByFechaDeFabricacion(fechaDeFabricacion), HttpStatus.OK);
	}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@GetMapping("/codigo/{valor}")
	public ResponseEntity<TransporteDto> getByCodigo(@PathVariable("valor") int codigo) throws CustomException {
		return new ResponseEntity<TransporteDto>(transporteService.getByCodigo(codigo), HttpStatus.OK);
	}
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@ApiOperation(value = "Transporte por marca", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ok"),
			@ApiResponse(code = 401, message = "no autorizado para este recurso"),
			@ApiResponse(code = 403, message = "el acceso al recurso perdido"),
			@ApiResponse(code = 404, message = "recurso no encontrado"), })
	@GetMapping("/marca/{valor}")
	public ResponseEntity<TransporteDto> marca(@PathVariable("valor") String marca)throws CustomException {
		log.info("Request: {}" +marca);
		return new ResponseEntity<TransporteDto>(transporteService.getByMarca(marca), HttpStatus.OK);
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@ApiOperation(value = "Lista de transporte por tipo", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ok"),
			@ApiResponse(code = 401, message = "no autorizado para este recurso"),
			@ApiResponse(code = 403, message = "el acceso al recurso perdido"),
			@ApiResponse(code = 404, message = "recurso no encontrado"), })
	@GetMapping("/tipo")
	public ResponseEntity<List<TransporteDto>> tipo(@RequestParam String tipo)throws CustomException {
		log.info("Request: {}" + tipo);
		return new ResponseEntity<List<TransporteDto>>(transporteService.getByTipo(tipo), HttpStatus.OK);
	}
}
