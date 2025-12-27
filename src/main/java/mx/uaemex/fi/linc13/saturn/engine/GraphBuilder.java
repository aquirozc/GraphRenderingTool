package mx.uaemex.fi.linc13.saturn.engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

import mx.uaemex.fi.linc13.saturn.data.Graph;
import mx.uaemex.fi.linc13.saturn.data.Graph.Vertex;
import mx.uaemex.fi.linc13.saturn.data.Graph.Edge;

public class GraphBuilder{

    private static final Pattern pattern = Pattern.compile("[a-zA-z],[a-zA-z]");

    public static Graph generateNewGraph(String input){
        String[] parts = input.replaceAll("\\s+", "").split("\\(|\\)");

        HashMap<Character,Vertex> map = new HashMap<>();
        List<Edge> list = new ArrayList<>();

        for (String part : parts){
            if(part.equals("")){
                continue;
            }

            if(part.length() != 3 & !pattern.matcher(part).matches()){
                throw new IllegalArgumentException("Input string was not in the correct format");
            }

            Vertex A = map.computeIfAbsent(part.charAt(0), c -> new Vertex(c));
            Vertex B = map.computeIfAbsent(part.charAt(2), c -> new Vertex(c));
            list.add(new Graph.Edge(A,B));
        }

        return new Graph(List.of(map.values().toArray(Graph.Vertex[]::new)), list);
    }

}
