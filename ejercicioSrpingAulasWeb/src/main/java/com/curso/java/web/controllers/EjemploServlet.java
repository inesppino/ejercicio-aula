package com.curso.java.web.controllers;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.curso.java.oo.ejercicio01oo.model.Alumno;
import com.curso.java.oo.ejercicio01oo.model.Aula;
import com.curso.java.oo.ejercicio01oo.model.Profesor;
import com.curso.java.oo.ejercicio01oo.model.PuestoDeTrabajo;

import ejercicio01NEGOCIO.AulaLN;

/**
 * Servlet implementation class EjemploServlet
 */
@WebServlet({ "/aulas"})
public class EjemploServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ApplicationContext context;
	
	
	
	@Override
	public void init() throws ServletException {
		
		ApplicationContext applicationContext = WebApplicationContextUtils
			.getRequiredWebApplicationContext(getServletContext());
		this.context = applicationContext;
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EjemploServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PuestoDeTrabajo puesto1 = context.getBean(PuestoDeTrabajo.class);
		PuestoDeTrabajo puesto2 = context.getBean(PuestoDeTrabajo.class);

		Alumno alumno1 = context.getBean(Alumno.class);
		Alumno alumno2 = context.getBean(Alumno.class);
		alumno1.setNombre("ines");
		alumno2.setNombre("enrique");

		Aula aula1 = context.getBean(Aula.class);
		aula1.setNombre("Ada");
		for(int i = 0; i< 11 ;i++) {
			aula1.getPuestosDeAlumnos().add(context.getBean(PuestoDeTrabajo.class));
		}
	
		Aula aula2 = context.getBean(Aula.class);
		aula2.setNombre("Dorkas");
		
		Aula aula3 = context.getBean(Aula.class);
		aula3.setNombre("Easley");
		
		PuestoDeTrabajo puestoDelProfesor = context.getBean(PuestoDeTrabajo.class);
		Profesor profesor = context.getBean(Profesor.class);
		puestoDelProfesor.setPersona(profesor);
		
		aula1.setPuestoDelProfesor(puestoDelProfesor);

		
		AulaLN ideaNegocio = context.getBean(AulaLN.class);
		ideaNegocio.darDeAltaUnAula(aula1);
		ideaNegocio.darDeAltaUnAula(aula2);
		ideaNegocio.darDeAltaUnAula(aula3);
		List<Aula> listadoDeTodasLasAulas = ideaNegocio.listadoDeTodasLasAulas();
		System.out.println(listadoDeTodasLasAulas);
	
		ideaNegocio.AsignarAlumnoAAula("Ada", alumno1);
		ideaNegocio.AsignarAlumnoAAula("Ada", alumno2);
		
		Collection<Alumno> listaDeAlumnosPorAulaEspecifica = ideaNegocio.listaDeAlumnosPorAulaEspecifica("Ada");
		System.out.println(listaDeAlumnosPorAulaEspecifica);

		ideaNegocio.eliminarUnAula(aula3);
		System.out.println(ideaNegocio.listadoDeTodasLasAulas());
		
		Iterator<Alumno> alumnos = listaDeAlumnosPorAulaEspecifica.iterator();
		Iterator<Aula> aulas = listadoDeTodasLasAulas.iterator();
		
		request.setAttribute("mensajeAlumno1", alumnos.next());
		request.setAttribute("mensajeAlumno2", alumnos.next());
		request.setAttribute("mensajeAula1", aulas.next());
		request.setAttribute("mensajeAula2", aulas.next());
		
		
		getServletContext().getRequestDispatcher("/WEB-INF/jsps/saludar.jsp").forward(request, response);
	}

}
