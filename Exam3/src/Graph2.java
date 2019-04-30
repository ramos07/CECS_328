
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
import javafx.util.Pair;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ramos
 */


/**
 * Superclass Graph that represents an undirected graph object.
 */
public class Graph2 {
    
    Object node;
    Set<Object> V; //vertices (nodes)
    Set<Object> E; //edges
    List<Object> Vertices;
    List<Object> Edges;
    int connComponents;
    
    //default constructor initializes an empty graph
    public Graph2(){
        V = new HashSet<>();
        E = new HashSet<>();
        Vertices = new ArrayList<>(V);
        Edges = new ArrayList<>(E);
    }
    
    /*overloaded constructor builds a graph object from set of nodes V and 
    set of pair nodes (i.e edges) E*/
    public Graph2(Set V, Set E){
        this.V = V;
        this.E = E;
        Vertices = new ArrayList<>(this.V);
        Edges = new ArrayList<>(this.E);
    }
    
    //adds a node into the graph
    public void addNode(Object n){
        V.add(n);
    }

    /*adds a new edge into the graph object from the set of nodes V and set of 
    pair nodes(i.e. edges)E*/
    public void addEdge(Pair edge){
        if(!V.contains(edge.getKey()) || !V.contains(edge.getValue()))
        {
            System.out.println("Cannot add edge because one of the pair values does not exist as a vertex.");         
        }
        else{
           E.add(edge);
       }
    }
    
    //Returns true if the graph is connected, false otherwise
    public boolean isConnected(Object node){
        
        
        
        return false;
    }
    
    public boolean checkIfConnected(Pair edge, Pair edge2){
        
        if(edge.getKey().equals(edge2.getKey()) || edge.getKey().equals(edge2.getValue()))
        {
            return true;
        }
        if(edge.getValue().equals(edge2.getKey()) || edge.getValue().equals(edge2.getValue()))
        {
            return true;
        }
        
        return false;
        
    }
    
    //returns the number of connected components in the graph
    public int numConnectedComponents(){
        
        int numberofVertices = Vertices.size();
        
        int numberofEdges = numberofVertices - 1;
        
        return numberofEdges;
    }

    
    //Returns a list of subgraphs of this graph, that are connected components
    /*public Graph [] connectedComponents(){
       
        return 
    }*/
    
    //prints a list of nodes as visited using Bread First Search traversal
    public void printBFS(){
        //Queue<Object> Q = new LinkedList<>(); 
        
    }
    
    public void BFS(Graph G, Object node)
    {
        Queue<Object> Q = new LinkedList<>();
        
        Q.add(node);
        
    }
    
    //prints a list of nodes as visited using Depth First Search traversal
    public void printDFS(){
        
    }
    
    @Override
    public  String toString(){
        return "Nodes: " + Arrays.toString(V.toArray()) +"\n"+ 
                "Edges: " + Arrays.toString(E.toArray());
    }
    
    public static void main(String []args)
    {
        Pair edge1 = new Pair('a', 'b');
        
        Set<Object> V = new HashSet<>(); //Nodes
        V.add('a');
        V.add('b');
        
        Set<Object> E = new HashSet<>(); //Edges
        E.add(edge1);
        
        
        
        Graph2 graph = new Graph2(V, E); //Initializing our graph
        //Graph2 graph = new Graph2(); //Creating new empty graph
        //System.out.println(graph);
        
        
        //Adding node values into the graph
        graph.addNode('c');
        graph.addNode('d');
        //System.out.println(graph);

        
        //Adding a new edge into the Set edges
        //System.out.println("adding edge");
        Pair edge2 = new Pair('a', 'c');
        graph.addEdge(edge2);
        //System.out.println(graph);
        graph.checkIfConnected(edge2, edge2);
        
        //Attempting to add edge where one of the pair values does not exist in the graph
        //Pair edge3 = new Pair('e', 'c');
        //graph.addEdge(edge3);
        
        System.out.println(graph.numConnectedComponents());
        
        System.out.println(graph);
        
        
    }
}

