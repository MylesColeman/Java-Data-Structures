/* A program demonstrating the implementation and use of an array-based stack in
 * Java taken from Problem Solving with  
 * Java by Elliot Koffman and Ursula Woltz. */
   
package arraystack_app;

/**
 * Represents an array-based stack.
 *
 * 
 */
public class ArrayStack
{    
    /**
     * The maximum 0-based index of the top of the stack (equal to size - 1).
     */
    private int maxTop;
    /**
     * The current index of the top of the stack.
     */
    private int top;
    /**
     * The array that contains the stack values.
     */
    private double[] values;
	
    /**
     * Initialises a new instance of an array-based stack.
     *
     * @param size  the maximum size of the stack
     */
    public ArrayStack(int size)
    {
        /* The maximum index of our top is going to be equal to size - 1 (think
         * about this carefully). We also initialise our array and set our top
         * index to -1, showing this stack is empty. */
         
        maxTop = size - 1;
        values = new double[size];
        top = -1;
    }
	
     /**
     * Constructor:Initialises a new instance of an array-based stack by 
     * filling it with the contents of an array 
     * @param arr	 the array of elements to add in the stack
     * @param Stacksize  the maximum size of the stack
     */
    public ArrayStack(double[] arr, int stackSize)
    {        
	
        maxTop = stackSize - 1;
        values = new double[stackSize];
        
        int arraySize = arr.length;
        int ceil = stackSize < arraySize ? stackSize : arraySize;
        
        for (int i = 0; i < ceil; i++) {
            values[i] = arr[i];
		}
		
        top = ceil - 1;
    }
    
    /**
     * Returns true if the stack is empty, otherwise returns false.
     * 
     * @return  true if the stack is empty, otherwise false
     */
    public boolean isEmpty()
    {
        /* We know our stack is empty if the index of the top of the stack is
         * equal to -1. */
       return top == -1;
    }
    
    /**
     * Returns true if the stack is full, otherwise returns false.
     * 
     * @return  true if the stack is full, otherwise false
     */
    public boolean isFull()
    {
        /* We know our stack is empty if the index of the top of the stack is
         * at its maximum. */
        return top == maxTop;
     
    }

    /**
     * Pushes a value onto the top of the stack.
     * 
     * @param value the value to push onto the stack
     */
   public void push(final double value)
    {
        /* We can 'push' a value onto the stack by incrementing `top` and adding
         * the value at the appropriate index in the array. 
        * If the stack is full print the message "The stack is full, the new element cannot be added"*/
        
        if (isFull())
            System.out.println("The stack is full, the new element cannot be added");
        else
        {
            top++;
            values[top] = value;
        }
      
    }

    /**
     * Pops a value off the top of the stack and returns it.
     * 
     * @return  the value that was popped off the stack
     */
   public double pop()
    {
        /* We can 'pop' a value off of the stack by storing the topmost value,
         * decrementing the top and then returning our stored value. 
        *  If the stack is empty return -999        */
        if (isEmpty())
            return -999;
        else
        {
            double poppedValue = values[top];
            top--;
            return poppedValue;
        }
    }
    
    /**
     * Returns the value on the top of the stack without popping it.
     *
     * @return  the value on the top of the stack
     */
   public double peek()
    {
        /* Very similar to pop, but we don't need to change `top`. Think about
         * why this is.
        *  If the stack is empty return -999        */
       if (isEmpty())
           return -999;
       else
           return values[top];
    }
	
	/**
	 * Gets the current size of the stack.
	 *
	 * @return	the size of the stack
	 */
   public int getSize()
    {
		/* We need to return the *current* height of the stack (*not* its
		 * maximum capacity). */
        return top + 1;
    } 

    /**
     * Prints the contents of the stack to standard output.
     */
    public void displayStack()
    {
        /* Don't change this method, but do understand how it works. This will
         * print out the contents of your stack. */
           
        if (!isEmpty()) {
            System.out.print("Top: ");
            for (int i = top; i > -1; i--)
            {
                String msg = i == top ? "" : "\t";
                System.out.println(msg + values[i]);
            }
            System.out.println();
        } else {
            System.out.println("Stack is empty.");
        }
    }
}
