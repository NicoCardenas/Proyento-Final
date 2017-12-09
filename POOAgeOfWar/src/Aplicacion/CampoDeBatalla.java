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
		tropa.setY(Window.porcentaje(Window.ALTO, 0.52));
		if (tropa.getUsuario().getTipo() == 1) {
			tropa.setVelX(1);
			tropa.setX(Window.porcentaje(Window.ANCHO, 0.05));
			if (tablero[0] == null) {
				tablero[0] = tropa;
				handler.addObject(tropa);
			}
		}else {
			tropa.setVelX(-1);
			tropa.setX(Window.porcentaje(Window.ANCHO, 0.95)-56);
			if (tablero[tablero.length-1] == null) {
				tablero[tablero.length-1] = tropa;
				handler.addObject(tropa);
			}
		}
	}
	
	public void colicionador() {
		Soldado[] temp = new Soldado[10];
		boolean colision = false;
		for (int i = 0; i < tablero.length; i++) {
			if (tablero[i] != null) {
				if (tablero[i].getSalud() <= 0) {
					handler.removeObject(tablero[i]);
					tablero[i] = null;
					return;
				}
				
				if (tablero[i].getUsuario().getTipo() == 1) {
					
					if(i+1 < tablero.length && tablero[i+1] == null) {
						tablero[i].setVelX(1);
						temp[i+1] = tablero[i];
						colision = false;
						
					}else if (i+1 < tablero.length && tablero[i].getUsuario().getTipo() == tablero[i+1].getUsuario().getTipo()){
						tablero[i].setVelX(0);	
					}else {
						tablero[i].damage(tablero[i+1].getAtaque());
						tablero[i].setVelX(0);
						colision = true;
					}
				}else{
					
					if(0 < i-1 && tablero[i-1] == null) {
						tablero[i].setVelX(-1);
						temp[i-1] = tablero[i];
						colision = false;
					}else if (0 < i-1 && tablero[i].getUsuario().getTipo() == tablero[i-1].getUsuario().getTipo()){
						tablero[i].setVelX(0);
					}else {
						tablero[i].damage(tablero[i-1].getAtaque());
						tablero[i].setVelX(0);
						colision = true;
					}					
				}
			}
			//System.out.print(tablero[i]+" ");
		}
		//System.out.println();
		if (!colision) tablero = temp.clone();
	}

}
