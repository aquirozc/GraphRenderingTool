package mx.uaemex.fi.linc13.saturn.data;

import java.util.List;

public class Graph{

    public final List<Vertex> vertexes;
    public final List<Edge> edges;

    public Graph(List<Vertex> vertexes, List<Edge> edges){
        this.vertexes = vertexes;
        this.edges = edges;
    }

    public static class Edge{
        public final Vertex A;
        public final Vertex B;

        public Edge(Vertex A, Vertex B){
            this.A = A;
            this.B = B;
        }
    }

    public static class Vertex{

        public final char label;

        private double[] pos = new double[]{0,0};
        private double[] disp = new double[]{0,0};

        public Vertex(char label){
            this.label = label;
        }

        public double getPosX(){
            return pos[0];
        }

        public double getPosY(){
            return pos[1];
        }

        public double getDispX(){
            return disp[0];
        }

        public double getDispY(){
            return disp[1];
        }

        public void updatePos(double x, double y){
            pos[0] = x;
            pos[1] = y;
        }

        public void updateDisp(double x, double y){
            disp[0] = x;
            disp[1] = y;
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof Vertex && ((Vertex)(obj)).label == this.label;
        }

    }

}
