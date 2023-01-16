package mx.uaemex.fi.ico.md.saturn.representacionMatricialDeGrafos.model;

import java.util.List;

public class Grafo{

    private Object [] [] matrizAdyacencia;
    private Object [] [] matrizIncidencia;
    private Object [] [] matrizCuadrada;
    private Object [] [] valoresDeValencia;
    
    public Grafo (int noVertices, int noAristas){

        // Crea e inicializa las matrices 
        matrizAdyacencia = new Object [noVertices] [noVertices];
        matrizIncidencia = new Object [noVertices] [noAristas];
        matrizCuadrada = new Object [noVertices] [noAristas];
        valoresDeValencia = new Object [noVertices] [1];
        inicializarMatrices(noVertices, noAristas);

    }

    public Object [] [] getMatrizAdyacencia(){
        return matrizAdyacencia;
    }

    public Object [] [] getMatrizIncidencia(){
        return matrizIncidencia;
    }
    
    public Object [] [] getMatrizCuadrada(){
    	return matrizCuadrada;
    }
    
    public Object [][] getMatrizValores(){
    	return valoresDeValencia;
    }
    
    public int getMatrizAdyacenciaLength(){
        return matrizAdyacencia.length;
    }

    public int[] getMatrizIncidenciaVectorLength(){
        int[] dimensionesMatrizIncidencia = {matrizIncidencia.length,matrizIncidencia[0].length};
        return dimensionesMatrizIncidencia;
    }
    
    public int getMatrizValoresLength (){
    	return valoresDeValencia[0].length;
    }


    public void inicializarMatrices(int noVertices, int noAristas){
        
        //Inicializa la matriz de adyacencia
        for (int i = 0;i < noVertices;i++){
            for(int j = 0; j < noVertices;j++){
                matrizAdyacencia[i][j] = 0;
            }
        }
        //Inicializa la matriz de incidencia
        for (int i = 0;i < noVertices;i++){
            for(int j = 0; j < noAristas;j++){
                matrizIncidencia[i][j] = 0;
            }
        }

    }
    //

    public void llenarMatrices(List <Integer> intervaloRecorrido,String cadenaEntrada){

        Object[] arregloPosiciones = intervaloRecorrido.toArray();

        for(int k = 1, m = 0; k < arregloPosiciones.length/2; k++,m++){
            int i = (int)cadenaEntrada.charAt((int)arregloPosiciones[2*k]+1)-96-1;
            int j = (int)cadenaEntrada.charAt((int)arregloPosiciones[2*k+1]-1)-96-1;

            matrizAdyacencia[i][j]=1;
            matrizAdyacencia[j][i]=1;
            matrizIncidencia[i][m]=1;
            matrizIncidencia[j][m]=1;
        }
        productoMatriz();
        diagonalPrincipal();
    }

    public void debugImprimirMatrices(int noVertices, int noAristas){
        System.out.println("Matriz de adyacencia: ");
        //Imprime la matriz de adyacencia
        for (int i = 0;i < noVertices;i++){
            System.out.println();
            for(int j = 0; j < noVertices;j++){
                
                System.out.print(matrizAdyacencia[i][j]);
            }
        }
        //Imprime la matriz de incidencia
        System.out.println();
        System.out.println("Matriz de incidencia: ");
        for (int i = 0;i < noVertices;i++){
            System.out.println();
            for(int j = 0; j < noAristas;j++){
                System.out.print(matrizIncidencia[i][j]);;
            }
        }
        
    }
    
   
    public void productoMatriz() {
    for(int a = 0; a < matrizAdyacencia.length; a++) {
    	for (int i = 0; i < matrizAdyacencia.length; i++) {
    		int suma = 0;   
    		for (int j = 0; j < matrizAdyacencia[0].length; j++) {
    			int x = (int) matrizAdyacencia [a][j];
    			int y = (int) matrizAdyacencia [j][i];
    			suma += x*y;  
    		}
    		matrizCuadrada[i][a] = suma;
    	}
    }
  }
    
    public void diagonalPrincipal() {

        valoresDeValencia = new Object[1][matrizCuadrada.length];

    	for (int i = 0; i < matrizCuadrada.length; i++) {
            
                valoresDeValencia[0][i] = matrizCuadrada[i][i];

        }
    	
    }
 }

