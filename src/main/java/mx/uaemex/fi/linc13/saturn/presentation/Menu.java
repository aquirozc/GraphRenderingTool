package mx.uaemex.fi.linc13.saturn.presentation;

import java.awt.Color;
import java.awt.Insets;
import java.awt.Font;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import mx.uaemex.fi.linc13.saturn.app.Controller;

import static java.awt.GridBagConstraints.*;

public class Menu extends JPanel{
    private Font regular = new Font ("Segoe UI",0,14);
    private Font larger = new Font ("Segoe UI",0,18);
    private GBLayoutBuilder builder = new GBLayoutBuilder();

    public Menu(Controller controller){
        JLabel title = new JLabel("<html>  Herramienta de<br/> representación<br/> de Grafos</html>");
        title.setFont(new Font("Segoe UI Light", 0, 32));
        title.setForeground(Color.WHITE);

        JLabel background = new JLabel();
        background.setBackground(new Color(1,64,81));
        background.setOpaque(true);

        JLabel timestamp = new JLabel("<html>  Compilado el 06 de diciembre de 2022<br/>Stable Release<br/> 20112.saturnmain.milestone5.20221206</html>");
        timestamp.setFont(new Font("Segoe UI",0,12));
        timestamp.setForeground(Color.WHITE);

        JLabel header = new JLabelExt(" Escoge una opción: ", larger);
        JLabel op1 = new JLabelExt(" 1.- Editar grafo  ",regular);
        JLabel op2 = new JLabelExt(" 2.- Mostrar matriz de adyacencia  ",regular);
        JLabel op3 = new JLabelExt(" 3.- Mostrar matriz de incidencia  ", regular);
        JLabel op4 = new JLabelExt (" 4.- Dibujar Grafo (Beta)   ", regular);
        JLabel op5 = new JLabelExt(" 5.- Mostrar valencia de los nodos ", regular);
        JLabel op6 = new JLabelExt(" 6.- Creditos del programa     ", regular);

        JComboBox<String> dropdown = new JComboBox<>(new String[]{"Opción 1","Opción 2","Opción 3", "Opción 4", "Opción 5", "Opción 6"});
        dropdown.setFont(regular);

        JButton button = new JButton("Aceptar");
        button.setFont(regular);
        button.addActionListener(e -> controller.onButtonPress((String)dropdown.getSelectedItem()));

        this.setLayout(new GridBagLayout());
        this.add(title, builder.startAt(0, 0).weighty(1).gridheight(5).anchor(FIRST_LINE_START).insets(new Insets(20, 15, 0, 120)).build());
        this.add(timestamp, builder.startAt(0, 5).gridheight(4).anchor(LAST_LINE_START).marginB(24).marginL(20).build());
        this.add(background,builder.startAt(0,0).weightx(1).gridheight(9).fill(BOTH).build());
        this.add(header, builder.startAt(1, 0).weighty(1).weightx(1).build());
        this.add(op1, builder.startAt(1, 1).weighty(1).weightx(1).build());
        this.add(op2, builder.startAt(1, 2).weighty(1).weightx(1).build());
        this.add(op3, builder.startAt(1, 3).weighty(1).weightx(1).build());
        this.add(op4, builder.startAt(1, 4).weighty(1).weightx(1).build());
        this.add(op5, builder.startAt(1, 5).weighty(1).weightx(1).build());
        this.add(op6, builder.startAt(1, 6).weighty(1).weightx(1).build());
        this.add(dropdown, builder.startAt(1, 7).fill(HORIZONTAL).build());
        this.add(button, builder.startAt(1, 8).fill(HORIZONTAL).build());
    }

}
