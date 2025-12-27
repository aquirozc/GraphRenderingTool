package mx.uaemex.fi.linc13.saturn.app;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import mx.uaemex.fi.linc13.saturn.data.MatrixType;
import mx.uaemex.fi.linc13.saturn.engine.FRGraphRenderer;
import mx.uaemex.fi.linc13.saturn.engine.GraphBuilder;
import mx.uaemex.fi.linc13.saturn.presentation.GraphFrame;
import mx.uaemex.fi.linc13.saturn.presentation.MatrixFrame;
import mx.uaemex.fi.linc13.saturn.presentation.Menu;
import mx.uaemex.fi.linc13.saturn.data.Graph;

public class Controller{

    private Graph graph = null;

    public Controller(boolean resizable){
        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }catch (Exception e){}

        JFrame frame = new JFrame("Herramienta de representación de grafos");
        frame.setContentPane(new Menu(this));
        frame.setSize(680,420);
        frame.setResizable(resizable);
        frame.setLocationRelativeTo( null );
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private boolean isGraphNull(){
        if(graph == null){
            JOptionPane.showMessageDialog(null, "No hay grafos para mostrar", "Error Fatal", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        return false;
    }

    public void onButtonPress(String option){
        switch (option) {
			case "Opción 1" -> {
			    try{
					this.graph = GraphBuilder.generateNewGraph(JOptionPane.showInputDialog(null, "Por favor digite el grafo de la siguiente forma:\n(a,b)(b,c)(c,a)"));
					graph = graph.vertexes.size() == 0 ? null : graph;
				}catch(IllegalArgumentException e){
				    JOptionPane.showMessageDialog(null, "La entrada no tiene el formato correcto", "Error Fatal", JOptionPane.ERROR_MESSAGE);
				}catch(NullPointerException e){}
			}

			case "Opción 2" -> {
			    if(isGraphNull()){
					return;
				}
			    new MatrixFrame("Matriz de adyacencia", graph, MatrixType.ADJACENCY_MATRIX).setVisible(true);
			}

			case "Opción 3" -> {
                if(isGraphNull()){
                    return;
                }
			    new MatrixFrame("Matriz de incidencia", graph, MatrixType.INCIDENCE_MATRIX).setVisible(true);
			}

			case "Opción 4" -> {
			    if(isGraphNull()){
					return;
				}
				FRGraphRenderer.computeVertexPositions(graph, 500, 500);
				new GraphFrame(graph).setVisible(true);
			}

			case "Opción 5" -> {
                if(isGraphNull()){
                    return;
                }
			    new MatrixFrame("Valores de Valencia", graph, MatrixType.VALENCIAN_MATRIX).setVisible(true);
			}

			case "Opción 6" -> {
			    JOptionPane.showMessageDialog(null, "Universidad Autónoma del Estado de México\nIngeniería en Computación\nLINC13 Matemáticas Discretas\n\nDesarrollado por:\nAlejandro Quiroz Carmona\nEsdraz Victoria Aragón\nJesús Elías Oros García", "Creditos del programa", JOptionPane.INFORMATION_MESSAGE);
			}
		}

    }

}
