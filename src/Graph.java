import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Vector;


class Graph {
    Vector<Node> m_node;
    Vector<Vertex> m_vertex;

    //help

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
                System.out.println(lineValues[0] + " --" + lineValues[2] + "km--> " + lineValues[1]);
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


/*

        try {
            BufferedReader br= new BufferedReader(new FileReader(doc));
            Scanner in = new Scanner(doc);
            String s, line, unique, del=" ";
            while (in.hasNextLine()) {
                line= in.nextLine();
                String[] name= line.split(" ");
                for(int i=0; i<name.length-1; i++)
                {
                    int j=i+2;
                    while (name[i]!=name[j])
                    {
                        addNode(name[i++]);
                        System.out.println(name[i]);
                    }

                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    void addNode(String city){
        Node c = new Node(city);
        this.m_node.add(c);
    }*/

}


//import jdk.internal.net.http.common.Pair;
/*
import java.io.*;
import java.util.*;

public class Graph
{
    Vector <Node> m_node;
    Vector <Vertex> m_vertex;
    int m_o, m_size;

    public Graph(String nameFile)
    {
        FileReader fr = null;
        try {
            fr = new FileReader(nameFile);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    Map<String, LinkedList<String>> adj;
    //LinkedList is a dynamic array with better benefits

    public Graph(String data) {
        adj = new HashMap<String, LinkedList<String>>();
    }

    public void addNode(String node)
    {
        adj.putIfAbsent(node, new LinkedList<String>());
    }

    public void addNeighbor(String v1,String v2) {
        adj.get(v1).add(v2);
    }

    public List<String> getNeighbors(String v) {
        return adj.get(v);
    }

    public static void main(String[] args) {
        File file = new File("data.txt");
        FileReader fr = null;
        try {
            fr = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(fr);
        String line;
        String [] tokens;

        Graph g = new Graph();
        while( (line = br.readLine()) != null )
        {
            tokens = line.split("\\s+");
            g.addNode( tokens[0]);
            g.addNode( tokens[1]);
            g.addNeighbor( tokens[0], tokens[1]);
        }
        br.close();

    }
*/

/*
    public void PrimMST(){
        int[] D = new int[this.edges.size()];
        int[] P = new int[this.edges.size()];
        Heap<Pair> Q = new Heap<>();

    }*/