package com.springboot.api.Empleados.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.api.Empleados.dto.EmpleadoDto;
import com.springboot.api.Empleados.exception.CustomException;
import com.springboot.api.Empleados.service.EmpleadoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/empleados")
@Slf4j
public class EmpleadoController {

	@Autowired
	private EmpleadoService empleadoService;

	@ApiOperation(value = "Lista de Empleados", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ok"),
			@ApiResponse(code = 401, message = "no autorizado para este recurso"),
			@ApiResponse(code = 403, message = "el acceso al recurso perdido"),
			@ApiResponse(code = 404, message = "recurso no encontrado"), })
	@GetMapping("/getAll")
	public ResponseEntity<List<EmpleadoDto>> getAll() throws CustomException{
		List<EmpleadoDto> response = empleadoService.findAll();
		log.info("Request: {} " + response);
		return new ResponseEntity<List<EmpleadoDto>>(response, HttpStatus.OK);
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////	

	@ApiOperation(value = "Empleado por id", response = EmpleadoDto.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ok"),
			@ApiResponse(code = 401, message = "no autorizado para este recurso"),
			@ApiResponse(code = 403, message = "el acceso al recurso perdido"),
			@ApiResponse(code = 404, message = "recurso no encontrado"), })
	@GetMapping("/{id}")
	public ResponseEntity<EmpleadoDto> getbyId(@PathVariable Long id)throws CustomException {
		log.info("Request: {} " + id);
		return new ResponseEntity<EmpleadoDto>(empleadoService.getById(id), HttpStatus.OK);
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////

	@GetMapping("/dni/{valor}")
	public ResponseEntity<EmpleadoDto> getByDni(@PathVariable("valor") int dni)throws CustomException{
		return new ResponseEntity<EmpleadoDto>(empleadoService.getByDni(dni), HttpStatus.OK);
	}
	
	@GetMapping("/apellido/{valor}")
	public ResponseEntity<EmpleadoDto> getByApellido(@PathVariable("valor") String apellido)throws CustomException{
		return new ResponseEntity<EmpleadoDto>(empleadoService.getByApellido(apellido), HttpStatus.OK);
	} 
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////

	@ApiOperation(value = "Guardar Empleado", response = EmpleadoDto.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ok"),
			@ApiResponse(code = 401, message = "no autorizado para este recurso"),
			@ApiResponse(code = 403, message = "el acceso al recurso perdido"),
			@ApiResponse(code = 404, message = "recurso no encontrado"), })
	@PostMapping("/save")
	public ResponseEntity<EmpleadoDto> save(@NotNull @RequestBody EmpleadoDto empleadoDto) throws CustomException{
		log.info("Request: {} " + empleadoDto);
		return new ResponseEntity<EmpleadoDto>(empleadoService.save(empleadoDto), HttpStatus.CREATED);
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////

	@ApiOperation(value = "Actualizar Empleado", response = EmpleadoDto.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ok"),
			@ApiResponse(code = 401, message = "no autorizado para este recurso"),
			@ApiResponse(code = 403, message = "el acceso al recurso perdido"),
			@ApiResponse(code = 404, message = "recurso no encontrado"), })
	@PutMapping("/{id}")
	public ResponseEntity<EmpleadoDto> update(@NotNull @PathVariable long id,
			@NotNull @RequestBody EmpleadoDto empleadoDto) throws CustomException{
		log.info("Request: {} " + id + empleadoDto);
		return new ResponseEntity<EmpleadoDto>(empleadoService.update(id, empleadoDto), HttpStatus.OK);
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////

	@ApiOperation(value = "Borrar Empleado", response = EmpleadoDto.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ok"),
			@ApiResponse(code = 401, message = "no autorizado para este recurso"),
			@ApiResponse(code = 403, message = "el acceso al recurso perdido"),
			@ApiResponse(code = 404, message = "recurso no encontrado"), })
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) throws CustomException{
		log.info("Request: {} " + id);
		empleadoService.delete(id);
		log.info("Response Void");
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
}
