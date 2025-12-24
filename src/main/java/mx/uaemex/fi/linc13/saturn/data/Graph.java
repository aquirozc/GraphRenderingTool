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

        private int[] pos = new int[]{0,0};
        private int[] disp = new int[]{0,0};

        public Vertex(char label){
            this.label = label;
        }

        public void updatePos(int x, int y){
            pos[0] = x;
            pos[1] = y;
        }

        public void updateDisp(int x, int y){
            disp[0] = x;
            disp[1] = y;
        }
    }

}
