package ejercicio01LANZADOR;

import java.util.HashSet;
import java.util.Set;

import com.curso.java.oo.ejercicio01oo.model.Alumno;
import com.curso.java.oo.ejercicio01oo.model.Aula;
import com.curso.java.oo.ejercicio01oo.model.PuestoDeTrabajo;

import ejercicio01NEGOCIO.AulaLN;

public class LanzadorAulasList {

	public static void main(String[] args) {
		PuestoDeTrabajo puesto1 = new PuestoDeTrabajo(true);
		PuestoDeTrabajo puesto2 = new PuestoDeTrabajo(true);
		Set<PuestoDeTrabajo> puestoDeAlumno = new HashSet<PuestoDeTrabajo>();
		Alumno alumno1 = new Alumno();
		Alumno alumno2 = new Alumno();
		alumno1.setNombre("inés");
		alumno2.setNombre("enrique");
		alumno1.setSubvencionado(true);
		alumno2.setSubvencionado(false);
		puesto1.setPersona(alumno1);
		puesto2.setPersona(alumno2);
		puestoDeAlumno.add(puesto1);
		puestoDeAlumno.add(puesto2);
		Aula aula1 = new Aula("Ada", true, true, puestoDeAlumno);
		AulaLN ideaNegocio = newAulaLN(new AulaMemoryListDAO)
	}

}
