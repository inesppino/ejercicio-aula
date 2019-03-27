package ejercicio01DAO;

import java.util.Collection;

import com.curso.java.oo.ejercicio01oo.model.Aula;

public interface IAulaDAO {
	
	//creacion de aula nueva
	void createAula(Aula aula);
	
	//almacen de aulas
	Collection<Aula> getAulas();
	
	//actualizar aula existente
	void updateAula(Aula aula);
	
	//borrar aula existente por su nombre
	void deleteAula(Aula aula);
	
	//
	Aula getAulas(String nombre);

}
