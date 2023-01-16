package mx.uaemex.fi.ico.md.saturn.representacionMatricialDeGrafos.controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import mx.uaemex.fi.ico.md.saturn.representacionMatricialDeGrafos.model.EntradaUsuario;
import mx.uaemex.fi.ico.md.saturn.representacionMatricialDeGrafos.model.Grafo;
import mx.uaemex.fi.ico.md.saturn.representacionMatricialDeGrafos.visual.MenuPrincipal;
import mx.uaemex.fi.ico.md.saturn.representacionMatricialDeGrafos.visual.PanelPresentacion;
import mx.uaemex.fi.ico.md.saturn.representacionMatricialDeGrafos.visual.VentanaTabla;

public class Controlador implements ActionListener{
	
	private EntradaUsuario analizadorCadena;
	private Grafo grafoObjetivo;
	private JFrame ventanaPrincipal;
	private MenuPrincipal panelR;
	private String cadenaEntrada;
	private PanelPresentacion panelL;
	private VentanaTabla ventanaTablaAdyacencia;
	private VentanaTabla ventanaTablaAdyacencia2;
	private VentanaTabla ventanaTablaIncidencia;
	private VentanaTabla ventanaValoresValencia;
	
	public Controlador() {
		
		panelL = new PanelPresentacion();
		panelR = new MenuPrincipal(this);
		
		ventanaPrincipal = new JFrame("Herramienta de representación de grafos");
		ventanaPrincipal.getContentPane().add(panelL,BorderLayout.WEST);
		ventanaPrincipal.getContentPane().add(panelR,BorderLayout.EAST);
		ventanaPrincipal.setSize(580,420);
        ventanaPrincipal.setResizable(false);
        ventanaPrincipal.setLocationRelativeTo( null );
        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}
	
	public void arrancarPrograma() {
		ventanaPrincipal.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		String opSeleccionada = (String)panelR.getComboBox().getSelectedItem();
		
		switch (opSeleccionada) {
		
			case "Opción 1" :
				
				cadenaEntrada = "(" + JOptionPane.showInputDialog(null, "Por favor digite el grafo de la siguiente forma:\n(a,b)(b,c)(c,a)") +")";
				analizadorCadena = new EntradaUsuario(cadenaEntrada);
				if(analizadorCadena.getNoParesOrdenados() > 1) {
					grafoObjetivo = new Grafo(analizadorCadena.getMaxASCII()-96, analizadorCadena.getNoParesOrdenados()-1);
					grafoObjetivo.llenarMatrices(analizadorCadena.getIntervaloRecorrido(), cadenaEntrada);
				}else {
					JOptionPane.showMessageDialog(null, "Por favor introduzca un grafo valido", "Error Fatal", JOptionPane.ERROR_MESSAGE);
					grafoObjetivo = null;
				}
				
			break;
			
			case "Opción 2" :
				
				try {
					ventanaTablaAdyacencia = new VentanaTabla(grafoObjetivo.getMatrizAdyacencia(),grafoObjetivo.getMatrizAdyacenciaLength(),true);
	                ventanaTablaAdyacencia.setVisible(true);
	                ventanaTablaAdyacencia.setTitle("Matriz de adyacencia");
	                ventanaTablaAdyacencia.setSize(grafoObjetivo.getMatrizAdyacenciaLength()*80,grafoObjetivo.getMatrizAdyacenciaLength()*35+60);
	                ventanaTablaAdyacencia.setLocationRelativeTo(null);
	            }catch(Exception exception){
	                JOptionPane.showMessageDialog(null, "No hay grafos para mostrar", "Error Fatal", JOptionPane.ERROR_MESSAGE);
	            }
				
			break;
				
			case "Opción 3" :
				
				try{
	                ventanaTablaIncidencia = new VentanaTabla(grafoObjetivo.getMatrizIncidencia(),grafoObjetivo.getMatrizIncidenciaVectorLength()[1],false);
	                ventanaTablaIncidencia.setVisible(true);
	                ventanaTablaIncidencia.setTitle("Matriz de incidencia");
	                ventanaTablaIncidencia.setSize(grafoObjetivo.getMatrizIncidenciaVectorLength()[1]*80,grafoObjetivo.getMatrizIncidenciaVectorLength()[0]*35+60);
	                ventanaTablaIncidencia.setLocationRelativeTo(null);
	           }catch(Exception exception){
	                JOptionPane.showMessageDialog(null, "No hay grafos para mostrar", "Error Fatal", JOptionPane.ERROR_MESSAGE);
	           }
				
			break;
		
			case "Opción 4" :
				
				try {
	            	ventanaTablaAdyacencia2 = new VentanaTabla(grafoObjetivo.getMatrizCuadrada(), grafoObjetivo.getMatrizAdyacenciaLength(), true);
	            	ventanaTablaAdyacencia2.setVisible(true);
	            	ventanaTablaAdyacencia2.setTitle("Matriz de Adyacencia al cuadrado");
	            	ventanaTablaAdyacencia2.setSize(grafoObjetivo.getMatrizAdyacenciaLength()*80, grafoObjetivo.getMatrizAdyacenciaLength()*35+60);
	            	ventanaTablaAdyacencia2.setLocationRelativeTo(null);
	            }catch(Exception exception){
	            	JOptionPane.showMessageDialog(null, "No hay grafos para mostrar", "Error Fatal", JOptionPane.ERROR_MESSAGE);
	            }
			break;
				
			case "Opción 5" :
				
				try{
	            	ventanaValoresValencia = new VentanaTabla(grafoObjetivo.getMatrizValores(), grafoObjetivo.getMatrizValoresLength(), true);
	            	ventanaValoresValencia.setVisible(true);
	            	ventanaValoresValencia.setTitle("Valores de Valencia");
	            	ventanaValoresValencia.setSize(grafoObjetivo.getMatrizValoresLength()*80, grafoObjetivo.getMatrizValoresLength()*25);
	            	ventanaValoresValencia.setLocationRelativeTo(null);
	            }catch(Exception exception) {
	            	JOptionPane.showMessageDialog(null, "No hay grafos para mostrar", "Error Fatal", JOptionPane.ERROR_MESSAGE);
	            }
					
			break;
					
			case "Opción 6" :
				
				JOptionPane.showMessageDialog(null, "Universidad Autónoma del Estado de México\nIngeniería en Computación\nLINC13 Matemáticas Discretas\n\nDesarrollado por:\nAlejandro Quiroz Carmona\nEsdraz Victoria Aragón\nJesús Elías Oros García", "Creditos del programa", JOptionPane.INFORMATION_MESSAGE);
					
			break;
		
		}
		
	}

}
