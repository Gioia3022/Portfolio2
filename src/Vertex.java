import java.util.ArrayList;

public class Vertex {

    ArrayList<Node> edges = new ArrayList<>() ;
    int distance;
    //Vertex prev = null;

    public Vertex(Node a, Node b, int w){
        this.edges.add(0, a);
        this.edges.add(1, b);
        this.distance = w;
    }

    Node getStart(){return this.edges.get(0); }
    Node getEnd(){return this.edges.get(1); }
    Integer getWeight(){return this.distance; }

}
