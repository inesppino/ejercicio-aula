package com.curso.java.oo.ejercicio01oo.model;

public class Persona {
	
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + "]";
	}

	private String nombre;

	public Persona() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Persona(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
