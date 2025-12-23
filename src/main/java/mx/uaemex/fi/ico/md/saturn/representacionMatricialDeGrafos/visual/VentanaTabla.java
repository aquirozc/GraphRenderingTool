package mx.uaemex.fi.ico.md.saturn.representacionMatricialDeGrafos.visual;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class VentanaTabla extends JFrame{

    public VentanaTabla(Object[][] matrizDatos, int length, boolean typeOne){

        if (typeOne == true){
        JTable tablaDatos = new JTable(matrizDatos, this.getEncabezadosAdyacencia(length));
        tablaDatos.setRowHeight(35);
        JScrollPane panelSP = new JScrollPane(tablaDatos);
        this.add(panelSP);
        this.pack();
        }else{
            JTable tablaDatos = new JTable(matrizDatos, this.getEncabezadosIncidencia(length));
            tablaDatos.setRowHeight(35);
            JScrollPane panelSP = new JScrollPane(tablaDatos);
            this.add(panelSP);
            this.pack();
        }
    }
    

    public String [] getEncabezadosAdyacencia(int length){
        String [] encabezadosAdyacencia = new String[length];
        for (int i = 0; i < length;i++){
            int codeASCII = 97+i;
            char caracterSalida = (char)codeASCII;
            encabezadosAdyacencia[i] = Character.toString(caracterSalida);
        }
        return encabezadosAdyacencia;
    }

    public String [] getEncabezadosIncidencia(int length){
        String [] encabezadosIncidencia = new String[length];
        for (int i = 0; i < length;i++){
            encabezadosIncidencia[i] = "E" + (i+1);
        }
        return encabezadosIncidencia;
    }
}


