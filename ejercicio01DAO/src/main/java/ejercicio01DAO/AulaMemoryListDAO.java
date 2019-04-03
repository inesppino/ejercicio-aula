package ejercicio01DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.curso.java.oo.ejercicio01oo.model.Aula;


@Repository
public class AulaMemoryListDAO implements IAulaDAO {

	@Autowired
	@Qualifier("listadoDeAulas")
	private List<Aula> listadoDeAulas;
	
	public List<Aula> getListadoDeAulas() {
		return listadoDeAulas;
	}

	public void setListadoDeAulas(List<Aula> listadoDeAulas) {
		this.listadoDeAulas = listadoDeAulas;
	}
	
	public void createAula(Aula aula) {
		if(!listadoDeAulas.contains(aula) && aula != null) {
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
