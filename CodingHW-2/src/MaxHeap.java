/**
 * @author Ricardo Ramos
 * @class CECS 328
 * @date 3/26/2019
 */
import java.util.Arrays;
import java.util.Random;

public class MaxHeap
{
    public static void main(String[] args)
    {      
        //Tester 1
        /*System.out.println("TESTER 1 Part 1");
        Object [] names = new Object[0]; //empty Object array
        
        MaxHeap namesHeap = new MaxHeap(names); //creating a heap of names array
        namesHeap.add("Bryce Canyon NP"); //adding String elements into array
        namesHeap.add("Yosemite NP");
        namesHeap.add("Joshua Tree NP");
        namesHeap.add("Zion NP");
        namesHeap.add("Redwoods NP");
        namesHeap.add("Lassen Volcanic NP");
        
        System.out.println("Array as max heap: (added elements): " + namesHeap); //Max heap of String array
        
        namesHeap.remove("Redwoods NP");
        System.out.println("Array as max heap: (removed Redwoods NP): " + namesHeap); //Max heap after removing an element
        
        namesHeap.remove("Yellowstone NP"); //Trying to remove an element that is not in the array
        System.out.println();
        
        System.out.println("TESTER 1 Part 2");
        Object [] numbersArray = {2,4,1,5,9,7,10}; //Initiating a new object array with integers
               
        System.out.println("Unsorted array: " + Arrays.toString(numbersArray)); //Unsorted array
        
        MaxHeap maxheap2 = new MaxHeap(numbersArray); //Creating heap from our numbersArray      
        maxheap2.add(11); //adding 11 to the heap
        maxheap2.add(-1); //adding -1 to the heap       
        System.out.println("Array as max heap (added 11 and -1): " + maxheap2); // Printing Max heap array after adding 11 and -1
        maxheap2.remove(2);
        System.out.println("Array as max heap (removed 2): " + maxheap2); //Printing Max heap array after removing 2
        maxheap2.remove(11);
        System.out.println("Array as max heap (removed 11): " + maxheap2); // Printing Max heap array after removing 11
        
        System.out.println();*/
        
        //Tester 2
        System.out.println("TESTER 2");
        Object[] array = {1,4,1,2,9,5,2,15,10,3};
        
        System.out.println("Unsorted array: " + Arrays.toString(array)); //Unsorted array
        
        MaxHeap maxheap = new MaxHeap(array);        
        //System.out.println("Array as max heap: " + maxheap); //Max heap array
        
        MaxHeap.heapSort(maxheap.heap);
        System.out.println("Array after heap sort: " + maxheap);//Heap sorted array
                
        /*Random rand = new Random();
        int size = 320000; //creating an array with a very large size
	Object[] largeArray = new Object[size]; //creating Object array with our specified size
	for(int i = 0; i < size; i++) 
        {
            int number = rand.nextInt(size); //Generate a random value to add into our Object array
            largeArray[i] = number; //set each index in our array with a random value
	}
        
        //Tracking the time it takes to perform heapsort on our large array
	long startTime = System.nanoTime();
        MaxHeap runtime = new MaxHeap(largeArray); //creating the heap from our large array of integers
        MaxHeap.heapSort(runtime.heap); //performing heapsort on our larger array
	long endTime = System.nanoTime();
        
	long RunTime = endTime- startTime;
	System.out.println("Runtime: " + RunTime +" ns");*/  
    }   
    
    private Object[] heap; //declaring instance variable of our heap as an array of objects
    private static int heapSize; //declaring instance of our heap size
    
    //default constructor
    public MaxHeap()
    {
        heap = new Object[0]; //initializing our Object array to zero
        heapSize = 0; //inti
    }
    
    //initialized constructor
    public MaxHeap(Object[] data)
    {
        heap = data; //setting our heap to the data being passed in
        heapSize = data.length; //setting our heap size equal to the lenght of the data being passed in
        buildMaxHeap(heap); //after we set our heap we heapify it
    }
    
    /**
     * Method that will build our array of objects and heapify it
     * @param data 
     */
    private static void buildMaxHeap(Object[] data)
    {
        int size = (int) Math.floor(data.length/2) - 1;
        
        for(int i = size; i >= 0; i--)
        {
            maxHeapify(data, i);
        }
    }
    
    /**
     * This method will heapify our data in our array of Objects.
     * It is recursively called until each node is greater than both
     * of its children (left and right), hence max heapify.
     * @param data
     * @param i 
     */
    private static void maxHeapify(Object[] data, int i)
    {
        int left = (2 * i) + 1; //get the index of the left child
        int right = (2 * i) + 2; //get the index of the right child
        int largest = i; //set our largest index as the index i (root)
        
        //Compare the left index with the size of the heap and compare the left index value of our array with the root (i)
        if(left < heapSize && compareValues(data[left], data[i]))
        { 
            largest = left;
        }
        //Compare the right index with the size of the heap and compare the right index value with the 
        if(right < heapSize && compareValues(data[right], data[largest]))
        {
            largest = right;
        }
        if(largest != i)
        { 
            Object tmp = data[i];
            data[i] = data[largest];
            data[largest] = tmp;
            maxHeapify(data, largest); //recursive call of maxHeapify until we have the root as the largest element in the array
        }
    }
    
    /**
     * This boolean method will check the instance of two objects.
     * If the objects are strings then it will check the length of
     * each string variable and it will return a boolean depending on 
     * the condition below. Otherwise if the objects are integers then
     * it will compare the value of both objects and return the appropriate
     * boolean.
     * @param data1
     * @param data2
     * @return 
     */
    public static boolean compareValues(Object data1, Object data2)
    {
         //check variable type of objects, run first if conditions if the objects are strings
        if(data1 instanceof String && data2 instanceof String)
        {
            int data1_Length = ((String) data1).length(); //get length of first String object
            int data2_Length = ((String) data2).length(); //get length of second String object
            
            if(data1_Length > data2_Length || data1_Length == data2_Length) //Compare the lengths of both string objects 
            {
                return true; //return true if the length of the first string object is greater than the second string object
            }else
            {
                return false;
            }
        }
        else
        {
            if((int)data1 > (int)data2 || (int)data1  == (int)data2) //compare value of data1 and data2 integer objects
            {
                return true; //return true if the value of the first integer object is greater than the value fo the second integer object.
            }else
            {
                return false;
            }
        }
        
    }
    
    /**
     * This method will add an element into our heap array.
     * The element is inserted and the heap will be updated
     * as well as the heap size will be updated.
     * @param element 
     */
    public void add(Object element)
    {
        int newHeapSize = heap.length + 1; //heap size increases since we are adding an element
        Object[] tmpHeap = new Object[newHeapSize]; //creating a temporary heap array with our new heap size
        
        for(int i = 0; i < heap.length; i++)
        {
            tmpHeap[i] = heap[i]; //iterate and copy every element from our heap to our temporary heap
        }
        tmpHeap[newHeapSize - 1] = element; //add our element into our temporary heap
        heap = tmpHeap; //set our heap to our temporary heap
        heapSize = heap.length; //update the heap size after adding our element into the heap
        buildMaxHeap(heap); //build the max heap and heapify it again
    }
    
    /**
     * This method will remove and element from our heap array.
     * The element is removed from our heap and the heap size
     * is updated as well. An error is printed out if the element
     * desired to remove is not in the heap.
     * @param element 
     */
    public void remove(Object element)
    {
        int x = 0;
        int y = 0;
        int newHeapSize = heap.length - 1; //heap size changes since we are removing an element
  
        Object[] tmpHeap = new Object[newHeapSize]; //creating another heap with our new heap size
        try{
            for(int i = 0; i < heap.length; i++)
            {
                //if the element we want to delete is in the heap
                //our counter is not equal to 1 (where counter is keeping track of the root
                if(heap[i] == element && y != 1)
                {
                    y++; 
                }
                else
                {
                    tmpHeap[x] = heap[i]; //iterate and copy all the elements from our heap to our temporary heap array
                    x++;
                }
            }
            heap = tmpHeap; //set our heap to our new temporary heap that holds our new values
            heapSize = heap.length; //update the heap size for our heap
            buildMaxHeap(heap); //after updating our heap and our heap size, build the max heap again to restore the heap
        }
        catch(Exception e)
        {
            System.out.println("Element is NOT in heap"); //Return an error if the element is not in the heap
        }
    }
    
    /**
     * This method will sort our heap array from least to greatest.
     * Least to greatest since we are creating a max heap. 
     * @param data 
     */
    public static void heapSort(Object[] data)
    {
        heapSize = data.length; //update our heap size
        for(int i = data.length - 1; i >= 1; i--)
        {
            Object temp = data[0];
            data[0] = data[i];
            data[i] = temp;
            heapSize--; 
            maxHeapify(data, 0);
        }
        heapSize = data.length;
    }
    
    /**
     * toString method that returns our heap in string format.
     * @return 
     */
    @Override
    public String toString()
    {
        return Arrays.toString(heap);
    }
    
    
}