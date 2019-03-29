package com.curso.java.oo.ejercicio01oo.model;

import org.springframework.stereotype.Component;

@Component
public class Profesor extends Persona {
	private Boolean malaLeche;

	public Boolean getMalaLeche() {
		return malaLeche;
	}

	public void setMalaLeche(Boolean malaLeche) {
		this.malaLeche = malaLeche;
	}


}
