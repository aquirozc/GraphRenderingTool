package mx.uaemex.fi.linc13.saturn.app;

import mx.uaemex.fi.linc13.saturn.data.Graph;
import mx.uaemex.fi.linc13.saturn.data.Graph.Vertex;
import mx.uaemex.fi.linc13.saturn.engine.FRGraphRenderer;
import mx.uaemex.fi.linc13.saturn.engine.GraphBuilder;
import mx.uaemex.fi.linc13.saturn.presentation.GraphFrame;

// java -cp Graph_Rendering_Tool-Milestone1_Build1.01.jar mx.uaemex.fi.linc13.saturn.app.LivePreview
public class LivePreview{

    public static final String SAMPLE_GRAPH = """
            (a,b)(b,c)(c,d)(d,a)
            (e,f)(f,g)(g,h)(h,e)
            (a,e)(b,f)(c,g)(d,h)
            (i,j)(j,k)(k,l)(l,i)
            (m,n)(n,o)(o,p)(p,m)
            (i,m)(j,n)(k,o)(l,p)
            (a,i)(b,j)(c,k)(d,l)
            (e,m)(f,n)(g,o)(h,p)
    """.trim();

    public static void main(String[] args) {
        Graph graph = GraphBuilder.generateNewGraph(SAMPLE_GRAPH);
        FRGraphRenderer.computeVertexPositions(graph, 500, 500);

        for(Vertex v : graph.vertexes){
            System.out.println(v.getPosX() + "," + v.getPosY());
        }

        new GraphFrame(graph).setVisible(true);
        new Controller();
    }
}
