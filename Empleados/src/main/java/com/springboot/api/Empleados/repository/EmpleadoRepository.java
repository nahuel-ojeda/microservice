package com.springboot.api.Empleados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.api.Empleados.entity.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

	Empleado findByDni(int dni);
	Empleado findByApellido(String apellido);
	
}
