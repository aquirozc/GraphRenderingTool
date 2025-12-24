package mx.uaemex.fi.linc13.saturn.presentation;

import java.util.stream.IntStream;
import javax.swing.JFrame;
import javax.swing.JTable;
import mx.uaemex.fi.linc13.saturn.data.Graph;
import mx.uaemex.fi.linc13.saturn.data.MatrixType;

public class MatrixFrame extends JFrame{

    public MatrixFrame(String title, Graph graph, MatrixType type){
        switch (type) {
            case MatrixType.ADJACENCY_MATRIX -> {
                Integer[][] matrix = createZerosMatrix(graph.vertexes.size(),graph.vertexes.size());
                for(int e = 0; e<graph.edges.size(); e++){
                    int i = graph.edges.get(e).A.label-97;
                    int j = graph.edges.get(e).B.label-97;
                    matrix[i][j]= 1;
                    matrix[j][i] = 1;
                }
                JTable table = new JTable(matrix, this.getVertexesHeader(graph));
                table.setRowHeight(35);
                this.add(table);
                this.pack();
            }

            case MatrixType.INCIDENCE_MATRIX -> {
                Object[][] matrix = createZerosMatrix(graph.vertexes.size(),graph.edges.size());
                for(int e = 0; e<graph.edges.size(); e++){
                    matrix[graph.edges.get(e).A.label-97][e]= 1;
                    matrix[graph.edges.get(e).B.label-97][e] = 1;
                }
                JTable table = new JTable(matrix, this.getEdgesHeader(graph));
                table.setRowHeight(35);
                this.add(table);
                this.pack();
            }

            case MatrixType.VALENCIAN_MATRIX ->{
                Integer[][] matrix = createZerosMatrix(1,graph.vertexes.size());
                for(int e = 0; e<graph.edges.size(); e++){
                    int i = graph.edges.get(e).A.label-97;
                    int j = graph.edges.get(e).B.label-97;
                    matrix[0][j] += 1;
                    matrix[0][i] += 1;
                }
                JTable table = new JTable(matrix, this.getVertexesHeader(graph));
                table.setRowHeight(35);
                this.add(table);
                this.pack();
            }
        }
        this.setTitle(title);
        this.setLocationRelativeTo(null);
    }

    private Integer[][] createZerosMatrix(int n, int m){
        Integer[][] matrix = new Integer[n][m];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = 0;
            }
        }
        return matrix;
    }

    private String[] getVertexesHeader(Graph graph){
        return graph.vertexes.stream()
                    .map(v -> v.label + "")
                    .toArray(String[]::new);
    }

    private String[] getEdgesHeader(Graph graph){
        return IntStream.range(0, graph.edges.size())
                        .mapToObj(i -> "E" + (++i))
                        .toArray(String[]::new);
    }

}
