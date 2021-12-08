package com.springboot.api.Empresa.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.api.Empresa.exception.CustomException;
import com.springboot.api.Empresa.dto.EmpresaDto;
import com.springboot.api.Empresa.service.EmpresaService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/empresas")
@Validated
@Slf4j
public class EmpresaController {

	@Autowired
	private EmpresaService empresaService;

	@ApiOperation(value = "Lista de empresas", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ok"),
			@ApiResponse(code = 401, message = "no autorizado para este recurso"),
			@ApiResponse(code = 403, message = "el acceso al recurso perdido"),
			@ApiResponse(code = 404, message = "recurso no encontrado"), })
	@GetMapping("/getAll")
	public ResponseEntity<List<EmpresaDto>> getAll() throws CustomException {
		List<EmpresaDto> response = empresaService.findAll();
		log.info("Request: {} " + response);
		return new ResponseEntity<List<EmpresaDto>>(response, HttpStatus.OK);
	}

////////////////////////////////////////////////////////////////////////////////////////////////////

	@ApiOperation(value = "Empresa por id", response = EmpresaDto.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ok"),
			@ApiResponse(code = 401, message = "no autorizado para este recurso"),
			@ApiResponse(code = 403, message = "el acceso al recurso perdido"),
			@ApiResponse(code = 404, message = "recurso no encontrado"), })
	@GetMapping("/{id}")
	public ResponseEntity<EmpresaDto> getById(@PathVariable Long id) throws CustomException {
		log.info("Request: {} " + id);
		return new ResponseEntity<EmpresaDto>(empresaService.getById(id), HttpStatus.OK);
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////	

	@ApiOperation(value = "Empresa por codigo", response = EmpresaDto.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ok"),
			@ApiResponse(code = 401, message = "no autorizado para este recurso"),
			@ApiResponse(code = 403, message = "el acceso al recurso perdido"),
			@ApiResponse(code = 404, message = "recurso no encontrado"), })
	@GetMapping("/codigo/{valor}")
	public ResponseEntity<EmpresaDto> getByCodigo(@PathVariable("valor") int codigo) throws CustomException {
		return new ResponseEntity<EmpresaDto>(empresaService.getbyCodigo(codigo), HttpStatus.OK);
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////	

	@ApiOperation(value = "Razon social", response = EmpresaDto.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ok"),
			@ApiResponse(code = 401, message = "no autorizado para este recurso"),
			@ApiResponse(code = 403, message = "el acceso al recurso perdido"),
			@ApiResponse(code = 404, message = "recurso no encontrado"), })
	@GetMapping("/razonSocial/{valor}")
	public ResponseEntity<EmpresaDto> razonSocial(@PathVariable("valor") String razonSocial) throws CustomException {
		return new ResponseEntity<EmpresaDto>(empresaService.getByRazonSocial(razonSocial), HttpStatus.OK);
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////	

	@ApiOperation(value = "Guardar Empresa", response = EmpresaDto.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ok"),
			@ApiResponse(code = 401, message = "no autorizado para este recurso"),
			@ApiResponse(code = 403, message = "el acceso al recurso perdido"),
			@ApiResponse(code = 404, message = "recurso no encontrado"), })
	@PostMapping("/save")
	public ResponseEntity<EmpresaDto> save(@NotNull @RequestBody EmpresaDto empresaDto) throws CustomException {
		log.info("Request: {} " + empresaDto);
		return new ResponseEntity<EmpresaDto>(empresaService.save(empresaDto), HttpStatus.CREATED);
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////	

	@ApiOperation(value = "Actulizar Empresa", response = EmpresaDto.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ok"),
			@ApiResponse(code = 401, message = "no autorizado para este recurso"),
			@ApiResponse(code = 403, message = "el acceso al recurso perdido"),
			@ApiResponse(code = 404, message = "recurso no encontrado"), })
	@PutMapping("/{id}")
	public ResponseEntity<EmpresaDto> update(@NotNull @PathVariable Long id,
			@NotNull @RequestBody EmpresaDto empresaDto) throws CustomException {
		log.info("Request: {} " + id + empresaDto);
		return new ResponseEntity<EmpresaDto>(empresaService.update(id, empresaDto), HttpStatus.OK);
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////	

	@ApiOperation(value = "Borrar Empresa", response = EmpresaDto.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ok"),
			@ApiResponse(code = 401, message = "no autorizado para este recurso"),
			@ApiResponse(code = 403, message = "el acceso al recurso perdido"),
			@ApiResponse(code = 404, message = "recurso no encontrado"), })
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) throws CustomException {
		log.info("Request: {} " + id);
		empresaService.delete(id);
		log.info("Request void");
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}

}
