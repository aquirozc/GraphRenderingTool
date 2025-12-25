package mx.uaemex.fi.linc13.saturn.presentation;

import mx.uaemex.fi.linc13.saturn.data.Graph;
import mx.uaemex.fi.linc13.saturn.data.Graph.Edge;
import mx.uaemex.fi.linc13.saturn.data.Graph.Vertex;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;

public class GraphFrame extends JFrame {

    private final Graph graph;
    private int gainx, gainy;

    public GraphFrame(Graph graph) {
        this.graph = graph;
        setTitle("Graph Viewer");
        setSize(600, 600);

        for(Vertex v : graph.vertexes){
            gainx += v.getPosX();
            gainy += v.getPosY();
        }

        gainx = 300 - gainx/graph.vertexes.size();
        gainy = 300 - gainy/graph.vertexes.size();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        ((Graphics2D) g).setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );

        g.setColor(Color.BLACK);
        for (Edge e : graph.edges) {
            int x1 = (int)e.A.getPosX() + gainx;
            int y1 = (int)e.A.getPosY() + gainy;
            int x2 = (int)e.B.getPosX() + gainx;
            int y2 = (int)e.B.getPosY() + gainy;
            g.drawLine(x1, y1, x2, y2);
        }

        int r = 16;
        for (Vertex v : graph.vertexes) {
            int x = (int)v.getPosX() + gainx;
            int y = (int)v.getPosY() + gainy;

            g.setColor(Color.ORANGE);
            g.fillOval(x - r, y - r, 2 * r, 2 * r);

            g.setColor(Color.BLACK);
            g.drawOval(x - r, y - r, 2 * r, 2 * r);

            g.drawString(String.valueOf(v.label),x - 4,y + 4);
        }
    }
}
