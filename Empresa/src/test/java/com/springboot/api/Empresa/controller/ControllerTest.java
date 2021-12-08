package com.springboot.api.Empresa.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyLong;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.springboot.api.Empresa.dto.EmpresaDto;
import com.springboot.api.Empresa.exception.CustomException;
import com.springboot.api.Empresa.service.impl.EmpresaServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ControllerTest {

	@InjectMocks
	private EmpresaController controller;

	@Mock
	private EmpresaServiceImpl serviceImpl;

	private EmpresaDto dto;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);

		dto = EmpresaDto.builder().id(1l).codigo(101).razonSocial("empresa").tipoProducto("producto").build();
	}

	@Test
	void getAllTest() throws CustomException {
		ResponseEntity<List<EmpresaDto>> response = controller.getAll();
		List<EmpresaDto> lista = new ArrayList<EmpresaDto>();
		lista.add(dto);
		Mockito.when(serviceImpl.findAll()).thenReturn(lista);
		List<EmpresaDto> getAll = serviceImpl.findAll();
		
		assertTrue(getAll.equals(lista));
		assertEquals(response.getStatusCode(), HttpStatus.OK);
		assertEquals(lista, getAll);
		
	}
	
	@Test
	void getById() throws CustomException {
		ResponseEntity<EmpresaDto> response = controller.getById(anyLong());
		Mockito.when(serviceImpl.getById(anyLong())).thenReturn(dto);
		EmpresaDto empresaId = serviceImpl.getById(anyLong());
		
		assertTrue(empresaId.equals(dto));
		assertEquals(response.getStatusCode(), HttpStatus.OK);
		assertEquals(this.dto.getId(), empresaId.getId());
	}
	
	@Test
	void getByCodigoTest() throws CustomException {
		ResponseEntity<EmpresaDto> response = controller.getByCodigo(101);
		Mockito.when(serviceImpl.getbyCodigo(101)).thenReturn(dto);
		EmpresaDto empresaCodigo = serviceImpl.getbyCodigo(101);
		
		assertTrue(empresaCodigo.equals(dto));
		assertEquals(response.getStatusCode(), HttpStatus.OK);
		assertEquals(this.dto.getCodigo(), empresaCodigo.getCodigo());
	}
	
	@Test
	void getRazonSocialTest() throws CustomException {
		ResponseEntity<EmpresaDto> response = controller.razonSocial("empresa");
		Mockito.when(serviceImpl.getByRazonSocial("empresa")).thenReturn(dto);
		EmpresaDto razonSocial = serviceImpl.getByRazonSocial("empresa");
		
		assertTrue(razonSocial.equals(dto));
		assertEquals(response.getStatusCode(), HttpStatus.OK);
		assertEquals(this.dto.getRazonSocial(), razonSocial.getRazonSocial());
	}
	
	@Test
	void saveTest() throws CustomException {
		ResponseEntity<EmpresaDto> response = controller.save(dto);
		Mockito.when(serviceImpl.save(dto)).thenReturn(dto);
		EmpresaDto saveDto = serviceImpl.save(dto);
		
		assertTrue(saveDto.equals(dto));
		assertNotNull(saveDto);
		assertEquals(response.getStatusCode(), HttpStatus.CREATED);
		assertEquals(this.dto.getId(), saveDto.getId());
	}
	
	
	@Test
	void updateTest()throws CustomException {
		ResponseEntity<EmpresaDto> response = controller.update(1l, dto);
		Mockito.when(serviceImpl.update(1l, dto)).thenReturn(dto);
		EmpresaDto empresaUpdate = serviceImpl.update(1l, dto);
		
		assertTrue(empresaUpdate.equals(dto));
		assertEquals(response.getStatusCode(), HttpStatus.OK);
		assertEquals(this.dto.getId(), empresaUpdate.getId());
	}
	
	@Test
	void deleteByIdTest()throws CustomException {
		/*
		ResponseEntity<Void> response = controller.deleteById(1l);
		EmpresaDto empresaDelete = serviceImpl.delete(null);
		
		assertEquals(response.getStatusCode(), HttpStatus.ACCEPTED);
		assertEquals(this.dto.getId(), null);
		*/
	}

}
