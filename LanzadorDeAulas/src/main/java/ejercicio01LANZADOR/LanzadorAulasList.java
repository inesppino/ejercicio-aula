package ejercicio01LANZADOR;

import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.curso.java.oo.ejercicio01oo.model.Alumno;
import com.curso.java.oo.ejercicio01oo.model.Aula;
import com.curso.java.oo.ejercicio01oo.model.Profesor;
import com.curso.java.oo.ejercicio01oo.model.PuestoDeTrabajo;

import ejercicio01NEGOCIO.AulaLN;

public class LanzadorAulasList {
	
	public static ApplicationContext context;
	
	static {
		context = new ClassPathXmlApplicationContext("beanLanzador.xml");
	}
	
	public static void main(String[] args) {
		PuestoDeTrabajo puesto1 = context.getBean(PuestoDeTrabajo.class);
		PuestoDeTrabajo puesto2 = context.getBean(PuestoDeTrabajo.class);
		PuestoDeTrabajo puestoDelProfesor = context.getBean(PuestoDeTrabajo.class);
		Set<PuestoDeTrabajo> puestoDeAlumno = context.getBean(Set.class);
		Set<PuestoDeTrabajo> puestos2 = context.getBean(Set.class);
		Alumno alumno1 = context.getBean(Alumno.class);
		Alumno alumno2 = context.getBean(Alumno.class);
		alumno1.setNombre("ines");
		alumno2.setNombre("enrique");

		Aula aula1 = context.getBean(Aula.class);
		aula1.setNombre("Ada");
		for(int i = 0; i< 10 ;i++) {
			aula1.getPuestosDeAlumnos().add(context.getBean(PuestoDeTrabajo.class));
		}
		
		Aula aula2 = context.getBean(Aula.class);
		aula2.setNombre("Dorkas");
		
		Profesor profesor = context.getBean(Profesor.class);
		AulaLN ideaNegocio = context.getBean(AulaLN.class);
		puesto1.setPersona(alumno1);
		puesto2.setPersona(alumno2);
		puestoDelProfesor.setPersona(profesor);
		puestoDeAlumno.add(puesto1);
		puestoDeAlumno.add(puesto2);
		aula1.setPuestoDelProfesor(puestoDelProfesor);
		aula1.getPuestosDeAlumnos().add(puesto1);
		aula1.getPuestosDeAlumnos().add(puesto2);
		System.out.println(ideaNegocio.darDeAltaUnAula(aula1));
		System.out.println(ideaNegocio.darDeAltaUnAula(aula2));
		System.out.println(ideaNegocio.listadoDeTodasLasAulas());
		
		System.out.println(ideaNegocio.listaDeAlumnosPorAulaEspecifica("Ada"));

		ideaNegocio.eliminarUnAula(aula2);
		System.out.println(ideaNegocio.listadoDeTodasLasAulas());
		
	}

}
