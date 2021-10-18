import java.io.*;

class Graph
{
    public Graph(File doc){
        try {
            BufferedReader br= new BufferedReader(new FileReader(doc));
            String s;
            while ((s= br.readLine())!= null)
                System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
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