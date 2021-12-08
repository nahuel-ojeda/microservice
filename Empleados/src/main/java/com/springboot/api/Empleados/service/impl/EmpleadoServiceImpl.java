package com.springboot.api.Empleados.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.api.Empleados.convert.Convert;
import com.springboot.api.Empleados.dto.EmpleadoDto;
import com.springboot.api.Empleados.entity.Empleado;
import com.springboot.api.Empleados.exception.CustomException;
import com.springboot.api.Empleados.repository.EmpleadoRepository;
import com.springboot.api.Empleados.service.EmpleadoService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmpleadoServiceImpl implements EmpleadoService {

	@Autowired
	private EmpleadoRepository empleadoRepository;

	@Autowired
	private Convert convert;

	@Override
	public List<EmpleadoDto> findAll() throws CustomException {

		log.info("Response.....");
		List<Empleado> response = empleadoRepository.findAll();
		log.info("Response: {}" + response);
		return convert.listaEntityAdto(response);

	}

	@Override
	public EmpleadoDto save(EmpleadoDto empleadoDto) throws CustomException {
		log.info("Request Repository: {}" + empleadoDto);
		Empleado empleado = convert.dtoAEntitity(empleadoDto);
		empleado = empleadoRepository.save(empleado);
		return convert.entityAdto(empleado);
	}

	@Override
	public EmpleadoDto getById(Long id) throws CustomException {

		log.info("Request Repository: {}" + id);
		Optional<Empleado> optional = empleadoRepository.findById(id);
		Empleado empleado = optional.get();
		return convert.entityAdto(empleado);
	}

	@Override
	public void delete(Long id) throws CustomException {
		empleadoRepository.deleteById(id);
	}

	@Override
	public EmpleadoDto update(Long id, EmpleadoDto empleadoDto) throws CustomException {
		log.info("Request Response" + id + empleadoDto);
		if (empleadoRepository.findById(id).isPresent()) {
			Empleado empleado = empleadoRepository.findById(id).get();
			empleado.setApellido(empleadoDto.getApellido());
			empleado.setNombre(empleadoDto.getNombre());
			empleado.setDni(empleadoDto.getDni());
			empleado.setEdad(empleadoDto.getEdad());
			empleado.setTurno(empleado.getTurno());
			Empleado update = empleadoRepository.save(empleado);

			return convert.entityAdto(update);
		} else {
			return null;
		}
	}

	@Override
	public EmpleadoDto getByDni(int dni) throws CustomException {
			log.info("Request Response" + dni);
			Empleado empleado = empleadoRepository.findByDni(dni);
			return convert.entityAdto(empleado);
	}

	@Override
	public EmpleadoDto getByApellido(String apellido) throws CustomException {
			log.info("Request Response" + apellido);
			Empleado empleado = empleadoRepository.findByApellido(apellido);
			return convert.entityAdto(empleado);
	}

}
