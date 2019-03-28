package ejercicio01DAO;

import java.util.ArrayList;
import java.util.List;

import com.curso.java.oo.ejercicio01oo.model.Aula;

public class AulaMemoryListDAO implements IAulaDAO {

	private List<Aula> listadoDeAulas;
	
	public AulaMemoryListDAO() {
		super();
		this.listadoDeAulas = new ArrayList<Aula>();
	}
	
	public void createAula(Aula aula) {
		if(!listadoDeAulas.contains(aula)) {
			listadoDeAulas.add(aula);
			System.out.println("El aula" + aula + "ha sido agregada");
		}
	}

	public List<Aula> getAulas() {
		return listadoDeAulas;
	}

	public void updateAula(Aula aula) {
		int i = 0;
		boolean encontradaAula = false;
		while (i < listadoDeAulas.size() && !encontradaAula) {
			if (listadoDeAulas.get(i).getNombre() == aula.getNombre()) {
				listadoDeAulas.set(i, aula);
				encontradaAula = true;
			}
			i++;
		}

	}

	public void deleteAula(Aula aula) {
		if(listadoDeAulas.contains(aula)) {
		listadoDeAulas.remove(aula);
		System.out.println("El aula" + aula + "ha sido borrada");
		}
	}

	public Aula getAulas(String nombre) {
		Aula aula = null;
		int i = 0;
		boolean encontradaAula = false;
		while (i < listadoDeAulas.size() && !encontradaAula) {
			if (listadoDeAulas.get(i).getNombre() == nombre) {
				aula = listadoDeAulas.get(i);
				encontradaAula = true;
			} i++;
		}
		return aula;
	}
	
}
