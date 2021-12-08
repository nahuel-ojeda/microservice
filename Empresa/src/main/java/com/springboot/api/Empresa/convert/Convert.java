package com.springboot.api.Empresa.convert;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.springboot.api.Empresa.dto.EmpresaDto;
import com.springboot.api.Empresa.entity.Empresa;

@Component
public class Convert {

	public EmpresaDto entityAdto(Empresa empresa) {
		
		EmpresaDto dto = new EmpresaDto();
		dto.setId(empresa.getId());
		dto.setCodigo(empresa.getCodigo());
		dto.setRazonSocial(empresa.getRazonSocial());
		dto.setTipoProducto(empresa.getTipoProducto());
		return dto;
	}

	public List<EmpresaDto> listaEntityAdto(List<Empresa> empresa){
		return empresa.stream().map(x ->entityAdto(x)).collect(Collectors.toList());
	}
	
	public Empresa dtoAentity(EmpresaDto dto) {
		
		Empresa Ee = new Empresa();
		Ee.setId(dto.getId());
		Ee.setCodigo(dto.getCodigo());
		Ee.setRazonSocial(dto.getRazonSocial());
		Ee.setTipoProducto(dto.getTipoProducto());
		return Ee;
	}
	
	public List<Empresa> listaDtoAentity(List<EmpresaDto> dto){
		return dto.stream().map(x -> dtoAentity(x)).collect(Collectors.toList());
	}
	
}
