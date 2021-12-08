package com.springboot.api.Empresa.dto;

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
public class EmpresaDto {

	
	private Long id;
	
	@NotNull
	@NotEmpty
	@Size(min = 2, message = "EL campo codigo debe tener al menos 2 digitos")
	int codigo;
	
	@NotNull
	@NotEmpty
	@Size(min = 2, message = "EL campo razon social debe tener al menos 2 digitos")
	String razonSocial;
	
	@NotNull
	@NotEmpty
	@Size(min = 2, message = "EL campo tipo de producto debe tener al menos 2 digitos")
	String tipoProducto;
}
