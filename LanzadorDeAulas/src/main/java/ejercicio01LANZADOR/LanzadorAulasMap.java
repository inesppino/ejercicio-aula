package ejercicio01LANZADOR;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.curso.java.oo.ejercicio01oo.model.Alumno;
import com.curso.java.oo.ejercicio01oo.model.Aula;
import com.curso.java.oo.ejercicio01oo.model.Profesor;
import com.curso.java.oo.ejercicio01oo.model.PuestoDeTrabajo;

import ejercicio01DAO.AulaMemoryMapDAO;
import ejercicio01NEGOCIO.AulaLN;

public class LanzadorAulasMap {

	public static void main(String[] args) {
		PuestoDeTrabajo puesto1 = new PuestoDeTrabajo(true);
		PuestoDeTrabajo puesto2 = new PuestoDeTrabajo(true);
		PuestoDeTrabajo puestoDeProfesor1 = new PuestoDeTrabajo(true);
		Set<PuestoDeTrabajo> puestoDeAlumno = new HashSet<PuestoDeTrabajo>();
		Aula aula1 = new Aula("Ada", true, true, puestoDeAlumno);
		Aula aula2 = new Aula("Dorkas", true, true, puestoDeAlumno);
		Alumno alumno1 = new Alumno();
		Alumno alumno2 = new Alumno();
		Alumno alumno3 = new Alumno();
		Profesor profesor1 = new Profesor();
		profesor1.setNombre("ruben");
		profesor1.setMalaLeche(false);
		alumno1.setNombre("ines");
		alumno2.setNombre("enrique");
		alumno3.setNombre("david");
		alumno1.setSubvencionado(true);
		alumno2.setSubvencionado(false);
		alumno3.setSubvencionado(true);
		puesto1.setPersona(alumno1);
		puesto2.setPersona(alumno2);
		puestoDeProfesor1.setPersona(profesor1);
		puestoDeAlumno.add(puesto1);
		puestoDeAlumno.add(puesto2);
		aula1.setPuestoDelProfesor(puestoDeProfesor1);
		
		AulaLN negocio = new AulaLN(new AulaMemoryMapDAO());
		negocio.darDeAltaUnAula(aula1);
		negocio.darDeAltaUnAula(aula2);
		
		negocio.AsignarAlumnoAAula("Dorkas", alumno3);
		negocio.listaDeAlumnosPorAulaEspecifica("Dorkas");
		negocio.listaDeProfesoresPorAulaEspecifica("Ada");
		List<Aula> listadoDeTodasLasAulas = negocio.listadoDeTodasLasAulas();
		for(int i = 0; i< listadoDeTodasLasAulas.size(); i++) {
			Aula aulaobtenida = listadoDeTodasLasAulas.get(i);
			System.out.println(aulaobtenida);
		}
		negocio.eliminarUnAula(aula1);
		
	}

}
