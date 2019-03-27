package ejercicio01DAO;

import java.util.Collection;
import java.util.List;

import com.curso.java.oo.ejercicio01oo.model.Aula;

public class AulaStorageDAO implements IAulaDAO {
	
	//listado de aulas vacio donde se agrega el aula
	private List<Aula> listadoDeAulas;
	
	//lama a la funcion de la interfaz y lo añade a la lista 
	public void createAula(Aula aula) {
		listadoDeAulas.add(aula);
		System.out.println("El aula" + aula + "ha sido agregado");
	}

	public Collection<Aula> getAulas() {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateAula(Aula aula) {
		// TODO Auto-generated method stub
		
	}

	public void deleteAula(Aula aula) {
		// TODO Auto-generated method stub
		
	}

	public Aula getAulas(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}
	


}
