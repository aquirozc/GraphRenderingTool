package mx.uaemex.fi.ico.md.saturn.representacionMatricialDeGrafos.visual;

import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

import java.awt.Color;

import java.awt.Font;
import java.awt.GridLayout;

public class PanelPresentacion  extends JPanel{

    private JLabel tittle;

    private JLabel etiquetaVacia;

    private JLabel fechaCompilación;

    public PanelPresentacion(){


        this.tittle = new JLabel();
        tittle.setText("<html>  Herramienta de<br/> representación<br/> de Grafos</html>");
        tittle.setFont(new Font("Segoe UI Light", 0, 32));
        tittle.setForeground(Color.WHITE);

        etiquetaVacia = new JLabel("");

        this.fechaCompilación = new JLabel("<html>  Compilado el 06 de diciembre de 2022<br/>Stable Release<br/> 20112.saturnmain.milestone5.20221206</html>");
        fechaCompilación.setFont(new Font("Segoe UI",0,12));
        fechaCompilación.setForeground(Color.WHITE);

        this.setLayout(new GridLayout(3,1));
        this.setBorder(BorderFactory.createEmptyBorder(20,15,0,120));
        this.setBackground(new Color(1,64,81));
        this.add(tittle);
        this.add(etiquetaVacia);
        this.add(fechaCompilación);
        
    
    }

}