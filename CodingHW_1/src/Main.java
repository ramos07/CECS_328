import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
/*
 * The purpose of this program is to sort an array in 
 * increasing order, using the sort algorithm.
 */

/**
 *
 * @author Ricardo Ramos
 * @name Coding HW #1
 * @date 12 March 2019
 */
public class Main {
    public static void main(String[] args)
    {
        int [] data = {1,4,1,2,9,5,2,3,15,10}; //Initialized array
        
        System.out.println("n = " + data.length); //show the size of the array
        System.out.println("Unsorted: " + Arrays.toString(data)); //show the unsorted array
        sort(data); //call the sort method and sort the array    
        
        System.out.println();
        
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        
        System.out.println("Enter an array size (n): ");
        int n = input.nextInt(); //take in array size
        int [] data2 = new int[n]; //create array of size n
        for(int i=0; i < data2.length; i++){
            data2[i] = rand.nextInt(99) + 1; //fill array with random values 1-99
        }
        System.out.println("n = " + data2.length); //show size of array
        sort(data2); //call the sort method and sort the array

    }  
    /**
     * Takes in an array and returns the maximum value
     * @param data
     * @return M 
     */
    public static int getMax(int[] data)
    {
        int M = data[0];
        for(int i=0; i < data.length; i++)
        {
            if(data[i] > M)
            {
                M = data[i];
            }
        }
        return M;
    }      
    /**
     * Sort method that will sort the passed in array.
     * Prints out the sorted array.
     * @param data 
     */
    public static void sort(int [] data)
    {   
        long startTime = System.nanoTime(); //start timer for algorithm
        
        int n = data.length; //size of passed in array
        
        int M = getMax(data); //Set M = the max element in the array
       
        int [] ele_count = new int [M+1]; //Initialize new array with size of M+1
        
        //Initialize element count array to zero
        for(int i=0; i <= M; i++){
            ele_count[i] = 0;
        }
        
        //For every element j in a[], update the 
        //array counts at data[j] by 1
        for(int j=0; j < n; j++)
        {
            ele_count[data[j]] += 1;
        }
        
        int [] positions = new int[M+1]; //Creating second array positions
        
        positions[0] = ele_count[0]; //First element in positions same as first element in ele_count array
        
        //positions j-th element is the sum of 
        //j-th element in ele_count
        //AND [j-1] in positions
        for(int j=1; j < M+1; j++)
        {
            positions[j] = ele_count[j] + positions[j-1];
        }
        
        int [] sorted_array = new int[n]; //Sorted array of size n for sorted elements
        
        //For i=0, 1, 2....n, place data[i] into the position
        //returned one less than the value of the positions array
        for(int j=n-1; j >= 0; j--)
        {
            sorted_array[positions[data[j]]-1] = data[j];
            positions[data[j]] -= 1;
        }
        long endTime = System.nanoTime();//End point of algorithm
        long executionTime = (endTime - startTime); //total execution time     
        float execTime = executionTime; //Converting long to float 
        float finalResult = execTime / 1000000; //Converting ns to ms
       
        if(n >= 50){ //If the array size > 50 dont show the sorted array but just the execution time
            System.out.println("Array size was too large to print but sort was successful");
            System.out.println("Time to execute algorithm: " + finalResult + " ms");
        }
        else{ //Else just print the sorted array but not execution time
            System.out.println("Sorted: " + Arrays.toString(sorted_array));
        }    
        
    }//end of sort() method
      
}//end of Main class
