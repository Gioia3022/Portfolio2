import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


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

                for(int i = 0; i < this.m_node.size(); i++) {
                    for (int j = 0; j < this.m_node.size(); j++) {
                        addVertex(lineValues[0], i, lineValues[1], j, lineValues[2]);
                    }
                }

                boolean isAlreadyHere = false;
                for (int i = 0; i < this.m_node.size(); i++) {
                    if (Objects.equals(this.m_node.get(i).getName(), lineValues[0])) {
                        isAlreadyHere = true;
                    }
                }
                for (int i = 0; i < this.m_node.size(); i++) {
                    if (isAlreadyHere == false) {
                        addNode(lineValues[0], i);
                    }
                }

                boolean isAlreadyHere1 = false;
                for (int i = 0; i < this.m_node.size(); i++) {
                    if (Objects.equals(this.m_node.get(i).getName(), lineValues[1])) {
                        isAlreadyHere1 = true;
                    }
                }
                for (int i = 0; i < this.m_node.size(); i++) {
                    if (isAlreadyHere == false) {
                        addNode(lineValues[1], i);
                    }
                }


            });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    void addNode(String city, int i) {
        Node c = new Node(city, i);
        this.m_node.add(c);
    }

    void addVertex(String city1, int i1, String city2, int i2, String distance) {
        Node c = new Node(city1, i1);
        Node c2 = new Node(city2, i2);
        int dis = Integer.parseInt(distance);
        Vertex v = new Vertex(c, c2, dis);
        this.m_vertex.add(v);
    }

    void displayTxt() {

        for (int j = 0; j < this.m_node.size(); j++) {
            System.out.println(this.m_node.get(j).getName());
        }
        for (int i = 0; i < this.m_vertex.size(); i++)
            System.out.println(this.m_vertex.get(i).getStart().getName() + "-->" + this.m_vertex.get(i).getWeight() + "-->" + this.m_vertex.get(i).getEnd().getName());
    }

    //We convert our list of weight to use in Prims
    int[][] convertListToArrayWeight(int[][] matrixweightgraph){
        System.out.println("we in " +this.m_vertex.size());
        //We put every vertex's weight in our int array
        for(int i = 0; i < this.m_vertex.size(); i++){ //we don't get in the for bc m_vertex is empty
            System.out.println("we get in the for");
            matrixweightgraph[this.m_vertex.get(i).getStart().getNumber()][this.m_vertex.get(i).getEnd().getNumber()] = this.m_vertex.get(i).getWeight();
            matrixweightgraph[this.m_vertex.get(i).getEnd().getNumber()][this.m_vertex.get(i).getStart().getNumber()] = this.m_vertex.get(i).getWeight();
            System.out.println(this.m_vertex.get(i).getWeight());
        }
        return matrixweightgraph;
    }

    //We create a 2D board of our vertices
    int[][] convertListToArrayVertex(int[][] matrixvertexgraph){

        //We put in a 2D board whether the vertex exists or not
        for(int i = 0; i < this.m_vertex.size(); i++){

            matrixvertexgraph[this.m_vertex.get(i).getStart().getNumber()][this.m_vertex.get(i).getEnd().getNumber()] = 1;
            matrixvertexgraph[this.m_vertex.get(i).getEnd().getNumber()][this.m_vertex.get(i).getStart().getNumber()] = 1;

        }
        return matrixvertexgraph;
    }

    public void MSTPrims(int[][] matrixvertexgraph, int[][] matrixweightgraph){

        int[] distance = new int[matrixvertexgraph.length];
        int[] predecessor = new int[matrixvertexgraph.length];

        ArrayList<Pair> listOfPairs = new ArrayList<>(); //?
        Heap<Pair> Q = new Heap<>();

        Arrays.fill(distance, Integer.MAX_VALUE); //all distances are infinite
        Arrays.fill(predecessor, -1); //no nodes has any predecessor

        if (matrixvertexgraph.length > 0)
            distance[0] = 0;
            //our source doesn't have a predecessor
        for (int i = 0; i < matrixvertexgraph.length; i++) {
            listOfPairs.add(new Pair(distance[i], i));
            Q.insert(listOfPairs.get(i));
        }

        int MST = 0;

        while (!Q.isEmpty()){
            Pair u = Q.extractMin();
            //System.out.println(u.distance);
            for (int v=0; v < matrixvertexgraph.length; v++){
                if(matrixvertexgraph[u.index][v]==1 && matrixweightgraph[u.index][v]<distance[v]){
                    distance[v]=matrixweightgraph[u.index][v];
                    predecessor[v]=u.index;
                    int position=Q.getPosition(listOfPairs.get(v));
                    listOfPairs.get(v).distance=matrixweightgraph[u.index][v];
                    Q.decreasekey(position);
                }
            }
            MST+=distance[u.index];

        }
        System.out.println("Minimum spanning tree distance");


        for (int i = 0; i < matrixvertexgraph.length; i++) {
            //predecessor and distance aren't filled properly
            System.out.println("Road " + i+ ": goes from "+ predecessor[i]+ " to "+i+" and weight is: "+ distance[i] );
            //System.out.println(m_node.get(i).getName() + " -- " + distance[i] + " km --> " + predecessor[i].getName());
        }
    }


    class Pair implements Comparable<Pair> {
        Integer distance;
        Integer index;

        public Pair(Integer distance, Integer index) {
            this.distance = distance;
            this.index = index;
        }

        @Override
        public int compareTo(Pair o) {
            return this.distance.compareTo(o.distance);
        }
    }
}