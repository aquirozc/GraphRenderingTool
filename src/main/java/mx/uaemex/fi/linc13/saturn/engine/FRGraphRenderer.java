package mx.uaemex.fi.linc13.saturn.engine;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import mx.uaemex.fi.linc13.saturn.data.Graph;
import mx.uaemex.fi.linc13.saturn.data.Graph.Edge;
import mx.uaemex.fi.linc13.saturn.data.Graph.Vertex;

public class FRGraphRenderer {

    private static Random random = ThreadLocalRandom.current();

    public static void computeVertexPositions(Graph graph, int w, int h){
        double temp = w/10;
        double k = Math.sqrt((w*h)/graph.vertexes.size());
        graph.vertexes.forEach(v -> v.updatePos(random.nextInt(w), random.nextInt(h)));

        for(int i = 0; i < 50; i++){
            for (Vertex v : graph.vertexes){
                v.updateDisp(0, 0);

                for(Vertex u : graph.vertexes){
                    if(!v.equals(u)){
                        double d1 = v.getPosX() - u.getPosX();
                        double d2 = v.getPosY() - u.getPosY();
                        double dlen = Math.sqrt(d1*d1 + d2*d2);

                        v.updateDisp(v.getDispX() + (d1/dlen)*(k*k/dlen), v.getDispY() + (d2/dlen)*(k*k/dlen));
                    }
                }
            }

            for(Edge e : graph.edges){
                double d1 = e.A.getPosX() - e.B.getPosX();
                double d2 = e.A.getPosY() - e.B.getPosY();
                double dlen = Math.sqrt(d1*d1 + d2*d2);

                e.A.updateDisp(e.A.getDispX() - (d1/dlen)*(dlen*dlen/k), e.A.getDispY() - (d2/dlen)*(dlen*dlen/k));
                e.B.updateDisp(e.B.getDispX() + (d1/dlen)*(dlen*dlen/k), e.B.getDispY() + (d2/dlen)*(dlen*dlen/k));
            }

            for(Vertex v : graph.vertexes){
                double d1 = v.getDispX();
                double d2 = v.getDispY();
                double dlen = Math.sqrt(d1*d1 + d2*d2);
                double min = Math.min(dlen, temp);

                if (dlen > 0) {
                    v.updatePos(
                        v.getPosX() + v.getDispX() / dlen * min,
                        v.getPosY() + v.getDispY() / dlen * min
                    );
                }

                v.updatePos(Math.min(w, Math.max(0, v.getPosX())), Math.min(h, Math.max(0, v.getPosY())));
            }

            temp = Math.max(temp * (1 - 0.065), 1);
        }
    }

}
