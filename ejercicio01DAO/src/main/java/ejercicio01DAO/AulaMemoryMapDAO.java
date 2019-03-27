package ejercicio01DAO;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.curso.java.oo.ejercicio01oo.model.Aula;

public class AulaMemoryMapDAO implements IAulaDAO {
	private Map<String, Aula> mapDeAulas;

	public void createAula(Aula aula) {
		if(!mapDeAulas.containsKey(aula.getNombre())) {
			mapDeAulas.put(aula.getNombre(), aula);
			System.out.println("El aula" + aula + "ha sido agregada");
		}
	}

	public List<Aula> getAulas() {
		List<Aula> listadoDeAulas = new LinkedList<Aula>();
		for (int i = 0; i<mapDeAulas.size(); i++) {
			listadoDeAulas.get(i);
		}
		return listadoDeAulas;
	}

	public void updateAula(Aula aula) {
		if(mapDeAulas.containsKey(aula.getNombre())) {
			mapDeAulas.put(aula.getNombre(), aula);
		}
	}

	public void deleteAula(Aula aula) {
		if(mapDeAulas.containsKey(aula.getNombre())) {
			mapDeAulas.remove(aula.getNombre(), aula);
			System.out.println("El aula" + aula + "ha sido eliminada");
		}
		
	}

	public Aula getAulas(String nombre) {
		return mapDeAulas.get(nombre);
	}

}
