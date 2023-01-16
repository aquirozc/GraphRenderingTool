package mx.uaemex.fi.ico.md.saturn.representacionMatricialDeGrafos.model;

import java.util.ArrayList;
import java.util.List;

public class EntradaUsuario{

	private int puntIzq;
	private int puntDer;
	private int maxASCII;
	private int noParesOrdenados;
	private String cadenaEntrada;
	private List <Integer> intervaloRecorrido;


	public EntradaUsuario(String cadenaEntrada){

		intervaloRecorrido = new ArrayList<Integer>();
		this.cadenaEntrada = cadenaEntrada;
		agregarLimites(0, cadenaEntrada.length()-1);
		this.calcNoParesOrdenados();
		this.calcMaxASCII();

		for (int i = 0; i < this.noParesOrdenados ; i++){
			this.actualizarPunteros(i);
			this.detectorNiveles();
		}
		
	}
	
	public List <Integer> getIntervaloRecorrido(){
		return this.intervaloRecorrido;
	}
	
	public int getMaxASCII() {
		return maxASCII;
	}
	
	public int getNoParesOrdenados() {
		return noParesOrdenados;
	}

	private void calcNoParesOrdenados(){

		int contadorNoParesOrdenados = 0;

		for (int i = 0; i < this.cadenaEntrada.length()-1;i++) {
			if(this.cadenaEntrada.charAt(i) == '(') {
				contadorNoParesOrdenados++;
			}
		}

		this.noParesOrdenados = contadorNoParesOrdenados;

	}
	
	private void calcMaxASCII() {
		for (int i = 0; i < cadenaEntrada.length()-1;i++) {
            if (cadenaEntrada.charAt(i) != ')' & cadenaEntrada.charAt(i) != ','){
                if ((int)cadenaEntrada.charAt(i) > maxASCII){
                    maxASCII=(int)cadenaEntrada.charAt(i);
                }
            }
            
        }
	}
	
	private void agregarLimites(int izq, int der) {
		
		this.intervaloRecorrido.add(izq);
		this.intervaloRecorrido.add(der);

	}
	
	private void actualizarPunteros(int contador) {
		
		puntIzq = intervaloRecorrido.get(2*contador);
		puntDer = intervaloRecorrido.get(2*contador+1);
		
	}
	
	private void detectorNiveles() {
		for(int i = puntIzq+1; i < puntDer; i++) {
			if(cadenaEntrada.charAt(i) == '(') {
				int nuevoPuntIzq = i;
				int nuevoPuntDer;
				int subNiveles = 0;
				for (int j = i + 1; j < puntDer; j++) {
					
					if(cadenaEntrada.charAt(j) == '(') {
						subNiveles++;
					}
					if(cadenaEntrada.charAt(j) == ')') {
						subNiveles--;
						if(subNiveles < 0) {
							nuevoPuntDer = j;
							agregarLimites(nuevoPuntIzq, nuevoPuntDer);
							i = nuevoPuntDer;
							subNiveles = 0;
							break;
						}
					}
				
				}
			}
		}
	}

}