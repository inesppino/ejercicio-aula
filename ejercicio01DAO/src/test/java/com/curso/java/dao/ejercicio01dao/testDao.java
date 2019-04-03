package com.curso.java.dao.ejercicio01dao;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.curso.java.oo.ejercicio01oo.model.Aula;

import ejercicio01DAO.AulaMemoryListDAO;

public class testDao {

	@Before
	public void setUp() throws Exception {
		
	}
	
	@Test
	public void testCreateAula() {
		Aula aula = new Aula();
		AulaMemoryListDAO aulaDao = new AulaMemoryListDAO();
		aulaDao.setListadoDeAulas(new ArrayList<Aula>());
		aulaDao.createAula(aula);
		assertTrue(aulaDao.getListadoDeAulas().size() == 1);
		aulaDao.createAula(null);
		assertTrue(aulaDao.getListadoDeAulas().size() == 1);
	}
	
	@Test
	public void testDeleteAula() {
		Aula aula = new Aula();
		AulaMemoryListDAO aulaDao = new AulaMemoryListDAO();
		aulaDao.setListadoDeAulas(new ArrayList<Aula>());
		aulaDao.createAula(aula);
		aulaDao.deleteAula(aula);
		assertTrue(aulaDao.getListadoDeAulas().size() == 0);

	}
	
	@Test
	public void testGetAulas() {
		Aula aula = new Aula();
		AulaMemoryListDAO aulaDao = new AulaMemoryListDAO();
		aulaDao.setListadoDeAulas(new ArrayList<Aula>());
		aulaDao.createAula(aula);
		Aula aulaEnLista = aulaDao.getAulas(aula.getNombre());
		assertTrue(aulaEnLista.equals(aula));
		
	}
	
	
	//FALTA EL UPDATE CON EL ID?
//	public void updateAula(Aula aula) {
//		int i = 0;
//		boolean encontradaAula = false;
//		while (i < listadoDeAulas.size() && !encontradaAula) {
//			if (listadoDeAulas.get(i).getNombre() == aula.getNombre()) {
//				listadoDeAulas.set(i, aula);
//				encontradaAula = true;
//			}
//			i++;
//		}
//
//	}

}

	

