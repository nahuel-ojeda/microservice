package com.springboot.api.Empleados.convert;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.springboot.api.Empleados.dto.EmpleadoDto;
import com.springboot.api.Empleados.entity.Empleado;

@Component
public class Convert {

	public EmpleadoDto entityAdto(Empleado empleado) {
		EmpleadoDto dto = new EmpleadoDto();
		dto.setId(empleado.getId());
		dto.setNombre(empleado.getNombre());
		dto.setApellido(empleado.getApellido());
		dto.setDni(empleado.getDni());
		dto.setEdad(empleado.getEdad());
		dto.setTurno(empleado.getTurno());
		return dto;
	}

	public List<EmpleadoDto> listaEntityAdto(List<Empleado> empleado) {
		return empleado.stream().map(x -> entityAdto(x)).collect(Collectors.toList());
	}

	public Empleado dtoAEntitity(EmpleadoDto dto) {

		Empleado emp = Empleado.builder().id(dto.getId()).nombre(dto.getNombre()).apellido(dto.getApellido())
				.dni(dto.getDni()).edad(dto.getEdad()).turno(dto.getTurno()).build();
		return emp;
	}
	
	public List<Empleado> listaDtoAentity(List<EmpleadoDto> dto){
		return dto.stream().map(x -> dtoAEntitity(x)).collect(Collectors.toList());
	}
}
