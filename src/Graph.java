import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


class Graph {
    ArrayList<Node> m_node = new ArrayList<>();
    ArrayList<Vertex> m_vertex = new ArrayList<>();

    public Graph(String doc) {
        // create a Path from the String
        Path filePath = Paths.get(doc);
        // if everything is fine with the file (checks omitted for brevity), read its lines
        List<String> lines;
        try {
            lines = Files.readAllLines(filePath);
            // then handle each line:
            lines.forEach(line -> {
                // split each line by an arbitrary number of whitespaces
                String[] lineValues = line.split("\\s+");
                // and do what you want with the results, e.g. create an edge of the graph
                //System.out.println(lineValues[0] + " --" + lineValues[2] + "km--> " + lineValues[1]);

                addVertex(lineValues[0], lineValues[1], lineValues[2]);

                if (!m_node.contains(lineValues[0])) {
                    addNode(lineValues[0]);
                }
                if (!m_node.contains(lineValues[1])) {
                    addNode(lineValues[1]);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    void addNode(String city) {
        Node c = new Node(city);
        this.m_node.add(c);
    }

    void addVertex(String city1, String city2, String distance) {
        Node c = new Node(city1);
        Node c2 = new Node(city2);
        int dis = Integer.parseInt(distance);
        Vertex v = new Vertex(c, c2, dis);
        this.m_vertex.add(v);
    }

    void displayTxt() {
        for (int i = 0; i < this.m_vertex.size(); i++)
            System.out.println(this.m_vertex.get(i).getStart().getName() + "-->" + this.m_vertex.get(i).getWeight() + "-->" + this.m_vertex.get(i).getEnd().getName());
    }
}