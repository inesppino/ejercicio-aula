package ejercicio01NEGOCIO;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.curso.java.oo.ejercicio01oo.model.Alumno;
import com.curso.java.oo.ejercicio01oo.model.Aula;
import com.curso.java.oo.ejercicio01oo.model.Persona;
import com.curso.java.oo.ejercicio01oo.model.Profesor;
import com.curso.java.oo.ejercicio01oo.model.PuestoDeTrabajo;

import ejercicio01DAO.IAulaDAO;

public class AulaLN {
	// llama a la interfaz
	private IAulaDAO aulaDao;

	public AulaLN(IAulaDAO aulaDao) {
		super();
		this.aulaDao = aulaDao;
	}

	// Crear un aula
	public Aula darDeAltaUnAula(Aula aula) {
		this.aulaDao.createAula(aula);
		return this.aulaDao.getAulas(aula.getNombre());
	}	

	// Eliminar aula
	public void eliminarUnAula(Aula aula) {
		aulaDao.deleteAula(aula);
	}

	// Lista de alumnos por aula
	public Collection<Alumno> listaDeAlumnosPorAulaEspecifica(String nombre) {
		Aula aula = this.aulaDao.getAulas(nombre);
		Set<PuestoDeTrabajo> puestos = aula.getPuestosDeAlumnos();
		Collection<Alumno> listaAlumnos = new LinkedList<Alumno>();
		Iterator<PuestoDeTrabajo> iterador = puestos.iterator();
		while (iterador.hasNext()) {
			PuestoDeTrabajo puestoActual = iterador.next();
			if (puestoActual.getPersona() != null) {
				Persona personilla = puestoActual.getPersona();
				if (personilla instanceof Alumno) {
					listaAlumnos.add((Alumno) puestoActual.getPersona());
				}
			}
		}
		return listaAlumnos;
	}

	// Lista de profesores por aula
	public Collection<Profesor> listaDeProfesoresPorAulaEspecifica(String nombre) {
		Aula aula = this.aulaDao.getAulas(nombre);
		PuestoDeTrabajo puestoProfesor = aula.getPuestoDelProfesor();
		Set<PuestoDeTrabajo> puestos = aula.getPuestosDeAlumnos();
		Collection<Profesor> listaProfesores = new LinkedList<Profesor>();
		Iterator<PuestoDeTrabajo> iterador = puestos.iterator();
		while (iterador.hasNext()) {
			PuestoDeTrabajo puestoActual = iterador.next();
			if(puestoActual.getPersona() != null) {
				Persona personilla = puestoActual.getPersona();
				if(personilla instanceof Profesor) {
					listaProfesores.add((Profesor) puestoActual.getPersona());
				}
			}
		}
		
		listaProfesores.add((Profesor) puestoProfesor.getPersona());
		
		return listaProfesores;
	}

	// Asignar alumno a aula
	public void AsignarAlumnoAAula(String nombre, Alumno alumno) {
		Aula aula = this.aulaDao.getAulas(nombre);
		Set<PuestoDeTrabajo> puesto = aula.getPuestosDeAlumnos();
		Iterator<PuestoDeTrabajo> iterador = puesto.iterator();
		while(iterador.hasNext()) {
			PuestoDeTrabajo puestoActual = iterador.next();
			if(puestoActual.getPersona() == null && puestoActual.isOrdenador()) {
				puestoActual.setPersona(alumno);
			}
		}
	}
	
	//Listar todas las aulas
	public List<Aula> listadoDeTodasLasAulas(){
		List<Aula> listadoAulas = this.aulaDao.getAulas();
		return listadoAulas;
	}
	

}
