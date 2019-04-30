
import java.util.Set;
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
public class Graph {
    
    private Node root;
    
    //default constructor initializes an empty graph
    public Graph(){
        
    }
    
    
    /*overloaded constructor builds a graph object from set of nodes V and 
    set of pair nodes (i.e edges) E*/
    public Graph(Set V, Set E){
        
    }
    
    //adds a node into the graph
    public void addNode(Object n){
        
    }
    
    /*adds a new edge into the graph object from the set of nodes V and set of 
    pair nodes(i.e. edges)E*/
    public void addEdge(Pair edge){
        
    }
    
    //Returns true if the graph is connected, false otherwise
    public boolean isConnected(){
     
        return false;
    }
    
    //returns the number of connected components in the graph
    public int numConnectedComponents(){
        
        return 0;
    }
    
    //Returns a list of subgraphs of this graph, that are connected components
    /*public Graph [] connectedComponents(){
       
        return 
    }*/
    
    //prints a list of nodes as visited using Bread First Search traversal
    public void printBFS(){
        
    }
    
    //prints a list of nodes as visited using Depth First Search traversal
    public void printDFS(){
        
    }
    
    @Override
    public String toString(){
        
        return "";
    }
}

class Node{
    Object data;
    Node left;
    Node right;
    int height;
    
    public Node(){
        left = null;
        right = null;
        height = 0;
    }
    
    public Node(Object data)
    {
        this.data = data;
        left = null;
        right = null;
        height = 1;
    }
}
