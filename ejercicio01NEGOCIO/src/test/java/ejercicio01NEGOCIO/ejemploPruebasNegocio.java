package ejercicio01NEGOCIO;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.curso.java.oo.ejercicio01oo.model.Alumno;
import com.curso.java.oo.ejercicio01oo.model.Aula;
import com.curso.java.oo.ejercicio01oo.model.Profesor;
import com.curso.java.oo.ejercicio01oo.model.PuestoDeTrabajo;

import ejercicio01DAO.AulaMemoryListDAO;

public class ejemploPruebasNegocio {
	
	@Before
	public void setUp() throws Exception {	
	}

	@Test
	public void testDarDeAltaUnAula() {
		Aula aula = new Aula();
		AulaLN aulaNegocio = new AulaLN();
		AulaMemoryListDAO aulaDao = new AulaMemoryListDAO();
		aulaDao.setListadoDeAulas(new ArrayList<Aula>());
		//meto el array vacio en el auladao del negocio para poder llegar a el
		aulaNegocio.setAulaDao(aulaDao);
		
		aulaNegocio.darDeAltaUnAula(aula);
		assertTrue(aulaNegocio.listadoDeTodasLasAulas().size() == 1);
		aulaNegocio.darDeAltaUnAula(null);
		assertTrue(aulaNegocio.listadoDeTodasLasAulas().size() == 1);
	}
	
	@Test
	public void testEliminarUnAula () {
		Aula aula = new Aula();
		AulaLN aulaNegocio = new AulaLN();
		AulaMemoryListDAO aulaDao = new AulaMemoryListDAO();
		aulaDao.setListadoDeAulas(new ArrayList<Aula>());
		aulaNegocio.setAulaDao(aulaDao);
		
		aulaNegocio.eliminarUnAula(aula);
		assertTrue(aulaNegocio.listadoDeTodasLasAulas().size() == 0);
	}
	
	@Test
	public void testListadoDeTodasLasAulas() {
		Aula aula = new Aula();
		AulaLN aulaNegocio = new AulaLN();
		AulaMemoryListDAO aulaDao = new AulaMemoryListDAO();
		aulaDao.setListadoDeAulas(new ArrayList<Aula>());
		aulaNegocio.setAulaDao(aulaDao);
		
		aulaNegocio.darDeAltaUnAula(aula);
		Aula aulaEnLista = aulaDao.getAulas(aula.getNombre());
		assertTrue(aulaEnLista.equals(aula));
	}

	@Test
	public void testAsignarAlumnoAAula() {
		Aula aula = new Aula();
		AulaLN aulaNegocio = new AulaLN();
		AulaMemoryListDAO aulaDao = new AulaMemoryListDAO();
		aulaDao.setListadoDeAulas(new ArrayList<Aula>());
		Set<PuestoDeTrabajo> puestoDeTrabajo = new HashSet<PuestoDeTrabajo>();
		PuestoDeTrabajo puesto1 = new PuestoDeTrabajo();

		aulaNegocio.setAulaDao(aulaDao);
		
		aula.setNombre("ZETA");
		puesto1.setOrdenador(true);
		puestoDeTrabajo.add(puesto1);
		aula.setPuestosDeAlumnos(puestoDeTrabajo);
		
		aulaNegocio.darDeAltaUnAula(aula);
		
		Alumno alumno = new Alumno();
		alumno.setNombre("alumno");
		aulaNegocio.AsignarAlumnoAAula("ZETA", alumno);
		assertTrue("El alumno ha sido asignado", aula.getPuestosDeAlumnos() != null);
	}
	
	@Test
	public void testListaDeAlumnosPorAulaEspecifica() {
		Aula aula = new Aula();
		AulaLN aulaNegocio = new AulaLN();
		AulaMemoryListDAO aulaDao = new AulaMemoryListDAO();
		aulaDao.setListadoDeAulas(new ArrayList<Aula>());
		Set<PuestoDeTrabajo> puestoDeTrabajo = new HashSet<PuestoDeTrabajo>();
		PuestoDeTrabajo puesto1 = new PuestoDeTrabajo();
		aulaNegocio.setAulaDao(aulaDao);
		
		aula.setNombre("ZETA");
		puesto1.setOrdenador(true);
		puestoDeTrabajo.add(puesto1);
		aula.setPuestosDeAlumnos(puestoDeTrabajo);
		
		aulaNegocio.darDeAltaUnAula(aula);
		
		Alumno alumno = new Alumno();
		alumno.setNombre("alumno");
		aulaNegocio.AsignarAlumnoAAula("ZETA", alumno);
		assertTrue(aulaNegocio.listaDeAlumnosPorAulaEspecifica("ZETA").size() == 1);
		
	}
	
	@Test
	public void testListaDeProfesoresPorAulaEspecifica() {
		Aula aula = new Aula();
		AulaLN aulaNegocio = new AulaLN();
		AulaMemoryListDAO aulaDao = new AulaMemoryListDAO();
		aulaDao.setListadoDeAulas(new ArrayList<Aula>());
		PuestoDeTrabajo puestodDelProfesor = new PuestoDeTrabajo();
		
		aulaNegocio.setAulaDao(aulaDao);
		
		aula.setNombre("ZETA");
		Profesor profesor = new Profesor();
		profesor.setNombre("profesor");
		puestodDelProfesor.setOrdenador(true);
		puestodDelProfesor.setPersona(profesor);
		aula.setPuestoDelProfesor(puestodDelProfesor);
		
		aulaNegocio.darDeAltaUnAula(aula);
		assertTrue(aulaNegocio.listaDeProfesoresPorAulaEspecifica("ZETA").size() == 1);
	}
	
}
