package ejercicio01DAO;

import java.util.List;

import com.curso.java.oo.ejercicio01oo.model.Aula;

public interface IAulaDAO {
	
	//creacion de aula nueva
	void createAula(Aula aula);
	
	//almacen de aulas
	List<Aula> getAulas();
	
	//actualizar aula existente
	void updateAula(Aula aula);
	
	//borrar aula existente por su nombre
	void deleteAula(Aula aula);
	
	//obtener aula por nombre
	Aula getAulas(String nombre);

}
