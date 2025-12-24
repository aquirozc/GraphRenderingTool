package mx.uaemex.fi.linc13.saturn.engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mx.uaemex.fi.linc13.saturn.data.Graph;

public class GraphBuilder{

    public static Graph generateNewGraph(String input){
        String[] parts = input.replaceAll("\\s+", "").split("\\(|\\)");

        HashMap<Character,Graph.Vertex> map = new HashMap<>();
        List<Graph.Edge> list = new ArrayList<>();

        for (String part : parts){
            if(part.equals("")){
                continue;
            }

            Graph.Vertex A = map.computeIfAbsent(part.charAt(0), c -> new Graph.Vertex(c));
            Graph.Vertex B = map.computeIfAbsent(part.charAt(2), c -> new Graph.Vertex(c));
            list.add(new Graph.Edge(A,B));
        }

        return new Graph(List.of(map.values().toArray(Graph.Vertex[]::new)), list);
    }

}
