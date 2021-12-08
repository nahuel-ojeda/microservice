package com.spring.api.Logistica.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TransporteDto {

	private Long id;
	private int codigo;
	private int cantidadDeRuedas;
	private String fechaDeFabricacion;
	private String marca;
	private String tipo;
	
}
