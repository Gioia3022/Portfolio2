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


                addVertex(lineValues[0], lineValues[1], lineValues[2]);

                boolean isAlreadyHere = false;
                for (int i = 0; i < this.m_node.size(); i++) {
                    if (Objects.equals(this.m_node.get(i).getName(), lineValues[0])) {
                        isAlreadyHere = true;
                    }
                }
                if (isAlreadyHere == false) {
                    addNode(lineValues[0]);
                }

                boolean isAlreadyHere1 = false;
                for (int i = 0; i < this.m_node.size(); i++) {
                    if (Objects.equals(this.m_node.get(i).getName(), lineValues[1])) {
                        isAlreadyHere1 = true;
                    }
                }
                if (isAlreadyHere1 == false) {

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

        for (int j = 0; j < this.m_node.size(); j++) {
            System.out.println(this.m_node.get(j).getName());
        }
        for (int i = 0; i < this.m_vertex.size(); i++)
            System.out.println(this.m_vertex.get(i).getStart().getName() + "-->" + this.m_vertex.get(i).getWeight() + "-->" + this.m_vertex.get(i).getEnd().getName());
    }

    public void MSTPrims(){

        int[] distance = new int[this.m_node.size()];
        int[] predecessor = new int[this.m_node.size()];

        ArrayList<Pair> listOfPairs = new ArrayList<>(); //?
        Heap<Pair> Q = new Heap<>();

        Arrays.fill(distance, Integer.MAX_VALUE); //all distances are infinite
        Arrays.fill(predecessor, -1); //no nodes has any predecessor

        if (this.m_node.size() > 0)
            distance[0] = 0;
        for (int i = 0; i < this.m_node.size(); i++) {
            listOfPairs.add(new Pair(distance[i], i));
            Q.insert(listOfPairs.get(i));
        }

        int MST = 0;

        while (!Q.isEmpty()){

            Pair u = Q.extractMin(); //we put the smallest element in u
            System.out.println(u.distance);

            for (int i = 0; i < this.m_node.size(); i++){ //for each node
/*
                if(matrixedgegraph[u.index][i] == 1 && matrixweightgraph[u.index][i] < distance[i]){
                    distance[i] = matrixweightgraph[u.index][i];
                    predecessor[i] = u.index;
                    int position=Q.getPosition(listOfPairs.get(i));
                    listOfPairs.get(i).distance = matrixweightgraph[u.index][i];
                    Q.decreasekey(position);
                }*/
            }
            MST += distance[u.index];



        }
        System.out.println("Minimum spaning tree distance");

        for (int i = 0; i < this.m_node.size(); i++) {
            System.out.println(i+ "parent "+ predecessor[i]+ "to  "+i+" weight "+ distance[i] );
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