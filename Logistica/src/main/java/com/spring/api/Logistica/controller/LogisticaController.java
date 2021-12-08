package com.spring.api.Logistica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.api.Logistica.dto.EmpleadoDto;
import com.spring.api.Logistica.dto.EmpresaDto;
import com.spring.api.Logistica.dto.TransporteDto;
import com.spring.api.Logistica.exception.CustomException;
import com.spring.api.Logistica.service.LogisticaService;

@RestController
@RequestMapping("/logistica")
public class LogisticaController {

	@Autowired
	private LogisticaService logisticaService;
	
	@GetMapping("/empresas")
	public ResponseEntity<List<EmpresaDto>> empresas() throws CustomException {
		return new ResponseEntity<List<EmpresaDto>>(logisticaService.listaEmpresas(), HttpStatus.OK);
	}

	@GetMapping("/empresas/codigo/{valor}")
	public ResponseEntity<EmpresaDto> empresaCodigo(@PathVariable("valor") int codigo) throws CustomException {
		return new ResponseEntity<EmpresaDto>(logisticaService.getByCodigoEmpresa(codigo), HttpStatus.OK);
	}

	@GetMapping("/empresas/razonSocial/{valor}")
	public ResponseEntity<EmpresaDto> empresaRazonSocial(@PathVariable("valor") String razonSocial)
			throws CustomException {
		return new ResponseEntity<EmpresaDto>(logisticaService.getByRazonSocial(razonSocial), HttpStatus.OK);
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@GetMapping("/empleados")
	public ResponseEntity<List<EmpleadoDto>> empleados() throws CustomException {
		return new ResponseEntity<List<EmpleadoDto>>(logisticaService.listaEmpleados(), HttpStatus.OK);
	}

	@GetMapping("/empleados/dni/{valor}")
	public ResponseEntity<EmpleadoDto> dni(@PathVariable("valor") int dni) throws CustomException {
		return new ResponseEntity<EmpleadoDto>(logisticaService.getByDni(dni), HttpStatus.OK);
	}

	@GetMapping("/empleados/apellido/{valor}")
	public ResponseEntity<EmpleadoDto> apellido(@PathVariable("valor") String apellido) throws CustomException {
		return new ResponseEntity<EmpleadoDto>(logisticaService.getByApellido(apellido), HttpStatus.OK);
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@GetMapping("/transporte")
	public ResponseEntity<List<TransporteDto>> Transporte() throws CustomException {
		return new ResponseEntity<List<TransporteDto>>(logisticaService.listaTransporte(), HttpStatus.OK);
	}

	@GetMapping("/transporte/codigo/{valor}")
	public ResponseEntity<TransporteDto> transporteCodigo(@PathVariable("valor") int codigo) throws CustomException {
		return new ResponseEntity<TransporteDto>(logisticaService.getByCodigoVehiculo(codigo), HttpStatus.OK);
	}

	@GetMapping("/transporte/marca/{valor}")
	public ResponseEntity<TransporteDto> marca(@PathVariable("valor") String marca) throws CustomException {
		return new ResponseEntity<TransporteDto>(logisticaService.getByMarca(marca), HttpStatus.OK);
	}

}
