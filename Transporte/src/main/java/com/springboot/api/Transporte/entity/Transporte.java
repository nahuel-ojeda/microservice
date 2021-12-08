package com.springboot.api.Transporte.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "transporte")
public class Transporte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "codigo")
	private int codigo;
	
	@Column(name = "cantidad_de_ruedas")
	private int cantidadDeRuedas;
	
	@Column(name = "fecha_de_fabicacaion")
	private String fechaDeFabricacion;
	
	@Column(name = "marca")
	private String marca;
	
	@Column(name = "tipo")
	private String tipo;
	
}
