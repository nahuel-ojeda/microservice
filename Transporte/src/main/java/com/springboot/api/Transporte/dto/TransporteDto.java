package com.springboot.api.Transporte.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransporteDto {

	private Long id;
	
	@NotNull
	@NotEmpty
	@Size(min = 2, message = "EL campo codigo debe tener al menos 2 digitos")
	int codigo;
	
	@NotNull
	@NotEmpty
	@Size(min = 2, message = "EL campo codigo debe tener al menos 2 digitos")
	int cantidadDeRuedas;
	
	@NotNull
	@NotEmpty
	@Size(min = 2, message = "EL campo codigo debe tener al menos 2 digitos")
    String fechaDeFabricacion;
    
	@NotNull
	@NotEmpty
	@Size(min = 2, message = "EL campo codigo debe tener al menos 2 digitos")
    String marca;
	
	@NotNull
	@NotEmpty
	@Size(min = 2, message = "EL campo codigo debe tener al menos 2 digitos")
    String tipo;
}
