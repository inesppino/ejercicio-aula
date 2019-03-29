package com.curso.java.oo.ejercicio01oo.model;

import org.springframework.stereotype.Component;

@Component
public class Alumno extends Persona {
	private Boolean subvencionado;

	public Boolean getSubvencionado() {
		return subvencionado;
	}

	public void setSubvencionado(Boolean subvencionado) {
		this.subvencionado = subvencionado;
	}

}
