package com.curso.java.oo.ejercicio01oo.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Alumno extends Persona {
	private Boolean subvencionado;

	public Boolean getSubvencionado() {
		return subvencionado;
	}

	public void setSubvencionado(Boolean subvencionado) {
		this.subvencionado = subvencionado;
	}

}
