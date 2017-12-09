package Aplicacion;

import Presentacion.Handler;
import Presentacion.Window;

public class CampoDeBatalla {
	
	Soldado[] tablero;
	Usuario usuario1;
	Usuario usuario2;
	Handler handler;

	public CampoDeBatalla(Handler handler) {
		tablero = new Soldado[10];
		this.handler = handler;
	}
	
	public void addSoldado(Soldado tropa) {
		tropa.setY(Window.porcentaje(Window.ALTO, 0.65));
		if (tropa.getUsuario().getTipo() == 0) {
			tropa.setVelX(1);
			tropa.setX(Window.porcentaje(Window.ANCHO, 0.07));
			if (tablero[0] == null) {
				tablero[0] = tropa;
				handler.addObject(tropa);
			}
		}else {
			tropa.setVelX(-1);
			tropa.setX(Window.porcentaje(Window.ANCHO, 0.93)-56);
			if (tablero[tablero.length-1] == null) {
				tablero[tablero.length-1] = tropa;
				handler.addObject(tropa);
			}
		}
	}
	
	public void colicionador() {
		Soldado[] temp = new Soldado[10];	
		for (int i = 0; i < tablero.length; i++) {
			if (tablero[i].getSalud() <= 0)
				tablero[i] = null;
			if (tablero[i] != null && tablero[i].getUsuario().getTipo() == 0) {
				if(i+1 < tablero.length && tablero[i+1] == null) {
					tablero[i].setVelX(1);
					temp[i+1] = tablero[i];
				}else if (i+1 < tablero.length && tablero[i].getUsuario().getTipo() == tablero[i+1].getUsuario().getTipo()){
					tablero[i].setVelX(0);
				}else {
					tablero[i].damage(tablero[i+1].getAtaque());
					tablero[i].setVelX(0);
				}
			}else if (tablero[i] != null){
				if(0 < i-1 && tablero[i-1] == null) {
					tablero[i].setVelX(-1);
					temp[i-1] = tablero[i];
				}else if (0 < i-1 && tablero[i].getUsuario().getTipo() == tablero[i-1].getUsuario().getTipo()){
					tablero[i].setVelX(0);
				}else {
					tablero[i].damage(tablero[i-1].getAtaque());
					tablero[i].setVelX(0);
				}
			}
		}
		tablero = temp.clone();
	}

}
