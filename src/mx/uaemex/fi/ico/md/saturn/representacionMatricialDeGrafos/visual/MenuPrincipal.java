package mx.uaemex.fi.ico.md.saturn.representacionMatricialDeGrafos.visual;

import mx.uaemex.fi.ico.md.saturn.representacionMatricialDeGrafos.controller.Controlador;

import java.awt.GridLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class MenuPrincipal extends JPanel{

    private JLabel tituloEncabezado;
    private JLabel op1;
    private JLabel op2;
    private JLabel op3;
    private JLabel op4;
    private JLabel op5;
    private JLabel op6;
    private JComboBox <String> menuDesplegable;
    private JButton botonSiguiente;

    public MenuPrincipal(Controlador oyenteAcción){
        
        Font fuenteNormal = new Font ("Segoe UI",0,14);
        Font fuenteGrande = new Font ("Segoe UI",0,18);

        tituloEncabezado = new JLabel("Escoge una opción: ");
        tituloEncabezado.setFont(fuenteGrande);

        op1 = new JLabel("1.- Editar grafo  ");
        op1.setFont(fuenteNormal);
        op2 = new JLabel("2.- Mostrar matriz de adyacencia  ");
        op2.setFont(fuenteNormal);
        op3 = new JLabel("3.- Mostrar matriz de incidencia  ");
        op3.setFont(fuenteNormal);
        op4 = new JLabel ("4.- Mostrar matriz de A^2    ");
        op4.setFont(fuenteNormal);
        op5 = new JLabel("5.- Mostrar valencia de los nodos ");
        op5.setFont(fuenteNormal);
        op6 = new JLabel("6.- Creditos del programa     ");
        op6.setFont(fuenteNormal);
        


        String[] listaOpciones= {"Opción 1","Opción 2","Opción 3", "Opción 4", "Opción 5", "Opción 6"};

        menuDesplegable = new JComboBox<String>(listaOpciones);
        menuDesplegable.setFont(fuenteNormal);

        botonSiguiente = new JButton("Aceptar");
        botonSiguiente.setFont(fuenteNormal);
        botonSiguiente.addActionListener(oyenteAcción);

        this.setLayout(new GridLayout(9,1));
        this.add(tituloEncabezado);
        this.add(op1);
        this.add(op2);
        this.add(op3);
        this.add(op4);
        this.add(op5);
        this.add(op6);
        this.add(menuDesplegable);
        this.add(botonSiguiente);
        
        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            }
        catch (Exception e){}
       
    }    
    
    public JComboBox<String> getComboBox() {
    	return menuDesplegable;
    }
}
