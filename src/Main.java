import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;

public class Main {

    public static void main(String[] args)  {
        Graph g;
        g = new Graph("src/data.txt");
        //g.displayTxt();

        //45 is the number of vertices there are in out graph
        int[][] matrixvertexgraph=new int[45][45];
        int[][] matrixweightgraph= new int[45][45];

        //We prepare our parameters for the Prims algorithm
        matrixweightgraph = g.convertListToArrayWeight(matrixweightgraph);
        matrixvertexgraph = g.convertListToArrayVertex(matrixvertexgraph);

        g.MSTPrims(matrixvertexgraph, matrixweightgraph);
    }
}
