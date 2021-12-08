package com.springboot.api.Transporte.convert;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.springboot.api.Transporte.dto.TransporteDto;
import com.springboot.api.Transporte.entity.Transporte;

@Component
public class Convert {

	public TransporteDto entityAdto(Transporte transporte) {

		TransporteDto dto = new TransporteDto();
		dto.setId(transporte.getId());
		dto.setCodigo(transporte.getCodigo());
		dto.setCantidadDeRuedas(transporte.getCantidadDeRuedas());
		dto.setFechaDeFabricacion(transporte.getFechaDeFabricacion());
		dto.setMarca(transporte.getMarca());
		dto.setTipo(transporte.getTipo());
		return dto;
	}

	public List<TransporteDto> listaEntityAdto(List<Transporte> transporte) {
		return transporte.stream().map(x -> entityAdto(x)).collect(Collectors.toList());
	}

	public Transporte dtoAentity(TransporteDto dto) {

		Transporte Te = Transporte.builder().id(dto.getId()).codigo(dto.getCodigo())
				.cantidadDeRuedas(dto.getCantidadDeRuedas()).fechaDeFabricacion(dto.getFechaDeFabricacion())
				.marca(dto.getMarca()).tipo(dto.getTipo()).build();
		return Te;
	}
	
	public List<Transporte> listaDtoAentity(List<TransporteDto> dto){
		return dto.stream().map(x -> dtoAentity(x)).collect(Collectors.toList());
	}

	
}
