/**
 * @name Coding HW-3
 * @author Ricardo Ramos
 * @date 23 April 2019
 * @class CECS 328
 */

 class AVLTree
 {
    /**
     * Inner Node class which will represent each node in our AVLTree 
     */
    class Node
    {    
        Comparable data; //the value inside each node.
        Node left; //the left child of a node
        Node right; //the right child of a node
        int height; //the height of the AVL Tree

        //Default constructor
        public Node()
        {
            left = null;
            right = null;
            data = 0;
            height = 0;
        }
        
        //Initialized constructor
        public Node(Comparable data)
        {
            left = null;
            right = null;
            this.data = data;
            height = 0;
        }     
    }
    
    private Node root;     
 
    //Default constructor
    public AVLTree()
    {
        root = null; //set the root of the AVL Tree as null
    }
     
    //Initialized constructor passing in array of Comparable values
    public AVLTree(Comparable [] values)
    {
        int size = values.length; //size of the array Comparable values
        
        //Construct the AVL Tree
        for(int i=0; i < size; i++)
        {
            add(values[i]); //insert each value from the values array into an AVL Tree
        }
    }

    /**
     * This method will add a value into the 
     * AVL Tree, the method insert is called 
     * inside which will take care the necessary 
     * rotations to make sure the AVL Tree is 
     * balanced.
     * @param data 
     */
    public void add(Comparable data)
    {
        root = insert(data, root); //Call the insert method 
    }
    
    /**
     * This method will return the height of the
     * node that is passed into the method, the 
     * return values is the height.
     * @param n
     * @return 
     */
    private int height(Node n )
    {

        if(n != null)
        {
            return n.height;
        }
        return 0;
    }
    
    public void printHeight()
    {
        System.out.println("AVLTree Height: "+height(root));
    }
    
    /**
     * This method will return the height difference of a
     * node. 
     * @param n
     * @return 
     */
    private int diff(Node n)
    {
        int difference = 0;
        difference = height(n.right) - height(n.left);
        
        return Math.abs(difference);
    }

     /**
      * This method will insert a value into the AVL Tree
      * and compare the value of with the root and decide
      * whether to put it on the left or right subtree, this 
      * method will be called recursively until there is no 
      * other node to compare the value with.
      * @param x - The value being inserted into the AVL Tree.
      * @param t - The Node value that is already in the AVL Tree.
      * @return 
      */
     private Node insert(Comparable e, Node n)
     {
         if (n == null)
         {
             n = new Node(e); //If the root is null create a new node.
         }
         else if (e.compareTo(n.data) < 0) //compare the value being inserted with the current node value.
         {
             n.left = insert( e, n.left ); //if the values being inserted is less than the current node value make it the left child
             
             if( diff(n) == 2 ) //get the height difference of the left and right node
             {
                if(e.compareTo(n.left.data) < 0) //after getting the height if there is an imabalance we rotate left
                {
                    n = rotateLeft(n);
                }
                else
                {
                    n = doubleRotateLeft(n); //if the value being inserted is less than the value of the left child we do a double rotation
                }
             }
         }
         else if(e.compareTo(n.data) > 0) //compare the value again checking if the value being inserted is greater
         {
             n.right = insert( e, n.right ); //if the inserted value is greater place it as the right child of the node
             
             if( diff(n) == 2 ) //get the height difference of the left and right node
             {
                if(e.compareTo(n.right.data) > 0) //if value being inserted is greater than the right node 
                {
                    n = rotateRight(n); //perform a right rotation with the current tree node
                }
                else
                {
                    n = doubleRotateRight(n); //perform a double right rotation with the current tree node.
                }
             }
         }
         else
         {
             
         }
         
         n.height = Math.max( height( n.left ), height( n.right ) ) + 1; //update the height of the AVL Tree.
         
         return n;
     }
     
     /**
      * This method will perform a left rotation on the nodes
      * to take care of an imbalance, by rotating positions
      * with the left child.
      * @param k2
      * @return 
      */
     private Node rotateLeft(Node n)
     {
         Node k1 = n.left;
         n.left = k1.right;
         k1.right = n;
         n.height = Math.max( height( n.left ), height( n.right ) ) + 1;
         k1.height = Math.max( height( k1.left ), n.height ) + 1;
         return k1;
     }
 
     /**
      * This method will perform a left rotation on the nodes
      * to take care of an imbalance, by rotating positions
      * with the right child.
      * @param k1
      * @return 
      */
     private Node rotateRight(Node n)
     {
         Node k2 = n.right;
         n.right = k2.left;
         k2.left = n;
         n.height = Math.max( height( n.left ), height( n.right ) ) + 1;
         k2.height = Math.max( height( k2.right ), n.height ) + 1;
         return k2;
     }
     
     /**
      * This method will perform a left rotation twice, it calls
      * the leftRotate method.
      * @param k3
      * @return 
      */
     private Node doubleRotateLeft(Node n)
     {
         n.left = rotateRight( n.left );
         return rotateLeft(n);
     }
     
     /**
      * This method will perform a right rotation twice, it calls 
      * the rightRotate method inside.
      * @param k1
      * @return 
      */
     private Node doubleRotateRight(Node n)
     {
         n.right = rotateLeft(n.right);
         return rotateRight(n);
     }    
    
    /**
     * This method will search the AVL Tree for a value
     * in the tree, if the value exists it will return a 
     * message stating whether the value exists in the tree 
     * or not.
     * @param val 
     */
    public void findValue(Comparable val)
    {
        System.out.println("Value to find: " + val);
        if(find(val) == false)
        {
            System.out.println("Value not in tree");
        }
        else
        {
            System.out.println("Value in tree");
        }
    }
        
    /**
     * Boolean method that will return true if the value 
     * exists in the tree, and false if the value 
     * does not exist in the AVL Tree.
     * @param val
     * @return 
     */ 
    public boolean find(Comparable val)
    {
        return search(root, val);
    }
    
    /**
     * This method will search the AVl Tree for a comparable value
     * it will set it equal to a node value and traverse through
     * the tree until the value wanting to be found is detected in
     * the AVL Tree.
     * @param n
     * @param val
     * @return 
     */
    private boolean search(Node n, Comparable val)
    {
        boolean found = false;
        
        while ((n != null) && !found) //keep running this while the node is not null and the node hasn't been found
        {
            Comparable rootValue = n.data;
            
            if (val.compareTo(rootValue) < 0)
            {
                n = n.left;
            }
            else if (val.compareTo(rootValue) > 0)
            {
                n = n.right;
            }
            else
            {
                found = true;
                break;
            }
            found = search(n, val);
        }
        return found;
    }

    /**
     * This method will get the post order print out 
     * of the AVL Tree.
     */
    private void postorder(Node n)
    {
        if (n != null)
        {
            int difference = diff(n);
            postorder(n.left);
            postorder(n.right);
            System.out.print("Node="+n.data +" " + "Diff="+difference+" | ");
        }
    }
    
    @Override
    public String toString()
    {
        postorder(root);
        
        return "";
    }
    
     public static void main(String[] args)
    {            
        Comparable [] values = {14, 17, 11, 7, 53, 4, 13, 8};
        AVLTree avlt = new AVLTree(values);  //construct AVL tree from array
        System.out.println("POST ORDER");
        System.out.println(avlt); //Print the tree with each node height difference
        System.out.println();
        avlt.printHeight(); //Print the height of the tree
        System.out.println();
        avlt.findValue(1); //Find 1 in the AVL Tree
        avlt.findValue(4); //Find 4 in the AVL Tree
                  
    }
 }
 