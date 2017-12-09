package Presentacion;

import java.awt.Graphics;
import java.util.LinkedList;

import Aplicacion.GameObject;

public class Handler {
	
	LinkedList<GameObject> objetos = new LinkedList<GameObject>();
	
	public void tick() {
		for (GameObject gameObject : objetos) {
			GameObject tempObjeto = gameObject;
			
			tempObjeto.tick();
		}
	}
	
	public void render(Graphics g) {
		for (GameObject gameObject : objetos) {
			GameObject tempObjeto = gameObject;
			
			tempObjeto.render(g);
		}
	}
	
	public void addObject(GameObject objeto) {
		this.objetos.add(objeto);
	}

	public void removeObject(GameObject objeto) {
		this.objetos.remove(objeto);
	}
}
