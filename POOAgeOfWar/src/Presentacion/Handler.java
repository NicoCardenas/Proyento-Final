package Presentacion;

import java.awt.Graphics;
import java.util.LinkedList;

import Aplicacion.GameObject;

public class Handler {
	
	LinkedList<GameObject> objetos = new LinkedList<GameObject>();
	
	/**
	 * Metodo para actualizar datos
	 */
	public void tick() {
		for (GameObject gameObject : objetos) {
			GameObject tempObjeto = gameObject;
			
			tempObjeto.tick();
		}
	}
	
	/**
	 * Metodo para renderizar
	 * @param g Graficos
	 */
	public void render(Graphics g) {
		for (GameObject gameObject : objetos) {
			GameObject tempObjeto = gameObject;
			
			tempObjeto.render(g);
		}
	}
	
	/**
	 * Metodo para agregar un elemento
	 * @param objeto Objeto para agregar
	 */
	public void addObject(GameObject objeto) {
		this.objetos.add(objeto);
	}

	/**
	 * Metodo para eliminar un objeto
	 * @param objeto Objeto para eliminar
	 */
	public void removeObject(GameObject objeto) {
		this.objetos.remove(objeto);
	}
}
