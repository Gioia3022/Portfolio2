import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;

public class Main {

    public static void main(String[] args)  {
        Graph g;
        g = new Graph("src/data.txt");
        g.displayTxt(); //this shows that we have the data in m_node and m_vertex

        //45 is the number of vertices there are in our graph
        int[][] matrixvertexgraph=new int[45][45];


        //We prepare our parameters for the Prims algorithm
        int[][] matrixweightgraph = g.convertListToArrayWeight(new int[45][45]); //<- doesn't work
        //matrixvertexgraph = g.convertListToArrayVertex(matrixvertexgraph);

        //our matrix of weight is empty
        /*for(int i =0; i < matrixweightgraph.length; i++){
            for(int j = 0; j < matrixweightgraph.length; j++){
                System.out.println(matrixweightgraph[i][j]);
            }
        }*/

        //g.MSTPrims(matrixvertexgraph, matrixweightgraph);
    }
}
