/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrayqueue_app;

/**
 * Represents an array-based queue.
 * 
 */
public class ArrayQueue
{
    /**
     * The maximum 0-based index of the back of the queue (equal to size - 1).
     */
    private int maxBack;
    
    /**
     * The current index of the back of the queue.
     */
    private int back;
    
    /**
     * The array that contains the queue values.
     */
    private String[] values;
    
    private int front;

    /**
     * Initialises a new instance of an array-based queue.
     */
    public ArrayQueue(int size) 
    {
        /* The maximum index of the back of the queue is going to be equal to 
         * size - 1 (think about this carefully). We also initialise our back 
         * and set our top index to -1, showing this stack is empty. */
         
        maxBack = size - 1;
        values = new String[size];
        back = -1;
        front = -1;
    }
    
    /**
     * Initialises a new instance of an array-based queue by filling it with the
     * contents of an array
     
     * @param arr    the array to fill the queue with
     * @param size  the maximum size of the queue
     */
    public ArrayQueue(String[] arr, int queueSize)
    {
        /* Constructor - creates a stack partially filled from an array. The 
         * array is passed as a parameter. Note that the constructor dynamically 
         * allocates the size of the stack array but that the size is fixed 
         * after initialization. */
    
        maxBack = queueSize - 1;
        values = new String[queueSize];
        
        int arraySize = arr.length;
        int ceil = queueSize < arraySize ? queueSize : arraySize;
        
        for (int i = 0; i < ceil; i++) {
            values[i] = arr[i];
        }
        
        back = ceil - 1;
        front = 0;
    }

    
    /**
     * Returns true if the queue is empty, otherwise returns false.
     *
     * @return    true if the queue is empty, otherwise false
     */
    public boolean isEmpty()
    {
        /* We know the queue is empty if `back` is pointing to -1. Think about
         * why this is. */
       return front == -1;
    }
    
    /**
     * Adds an item to the back of the queue (enqueues it).
     * 
     * @param item    the data to add
     */
    public void enqueue(String item)
    {
        /* Enqueues item at the back of the queue and sets `back` to the index 
         * of the newly added element. */
        if ((back + 1) % values.length == front)
            System.out.println("The queue is full, the new item cannot be added.");
        else
        {
            back = (back + 1) % values.length;
            values[back] = item;
            if (front == -1)
                front = 0;
        }
    }

    /**
     * Removes an item from the front of the queue and returns it (dequeues it).
     * 
     * @return the item at the front of the queue.
     */
    public String dequeue()
    {
        /* Removes the item at the front of the queue and returns it. You'll
         * now need to do an array shift to keep the data "packed" at the front
         * of the queue. Return an empty string if the queue is empty */
        if (isEmpty())
            return "";
        else
        {
            String dequeuedItem = values[front];
            if (front == back)
            {
                front = -1;
                back = -1;
            }
            else
                front = (front + 1) %  values.length;
            
            return dequeuedItem;
        }
    }

    /**
     * Returns the item at the front of the queue but does not dequeue it.
     * 
     * @return the item at the front of the queue.
     */
    public String peek()
    {
        /* Return the item at the front of the queue but do not remove it. 
           Return an empty string if the queue is empty                               */
        if (isEmpty())
            return "";
        else
            return values[front];
    }



    /**
     * Returns the size of the queue.
     *
     * @return    the size of the queue
     */
    public int getSize()
    {
        /* The size of an array-based queue is easy to calculate. What is the
         * relationship between `back` and the current queue size? */
        if (isEmpty())
            return 0;
        else if (back >= front)
            return back - front + 1;
        else
            return values.length - front + back + 1;
    }

    /**
     * Searches for the specified item in the queue and shifts it to the front.
     * 
     * @param item    the item to search for
     */
    public void moveToFront(String item)
    {
        /* We need to find the given item in the queue, and then dequeue from
         * the front and enqueue at the back until that item is at the front. */
        int index = -1;
        for (int i = front; i != (back + 1) % values.length; i = (i + 1) % values.length)
        {
            if (values[i].equals(item))
            {
                index = i;
                break;
            }
        }
        if (index == -1)
        {
            for (int i = front; i != index; i = (i + 1) % values.length)
                enqueue(dequeue());
        }
    }

    /**
     * Searches for the specified item in the queue and shifts it to the back.
     * 
     * @param item    the item to search for
     */
    public void moveToBack(String item)
    {
        /* We need to find the given item in the queue, and then dequeue from
         * the front and enqueue at the back until that item is at the back. */
        int index = -1;
        for (int i = front; i != (back + 1) % values.length; i = (i + 1) % values.length)
        {
            if (values[i].equals(item))
            {
                index = i;
                break;
            }
        }
        if (index != -1)
        {
            for (int i = front; i != (back + 1) % values.length; i = (i + 1) % values.length)
            {
                if (i != index)
                    enqueue(dequeue());
                else
                {
                    dequeue();
                    enqueue(item);
                    break;
                }
            }
        }
    }

    @Override
    public String toString()
    {
        /* Return the contents of your queue as a string in this format:
         * element1 element2 element3 element4
         * No commas or newlines are necessary, just a space in the middle */
        StringBuilder sb = new StringBuilder();
        if (!isEmpty())
        {
            for (int i = front; i != (back + 1) % values.length; i = (i + 1) % values.length)
                sb.append(values[i]).append (" ");
        }
        return sb.toString().trim();
    }
    
    /**
     * Prints the contents of the queue to standard output.
     */
    public void displayQueue()
    { 
        if (!isEmpty()) {
            System.out.print("Front: ");
            for (int i = front; i != (back + 1) % values.length; i = (i + 1) % values.length)
            {
                String msg = i == back ? "" : "\t";
                System.out.println(msg + values[i]);
            }
            System.out.println();
        } 
        else 
        {
            System.out.println("Queue is empty.");
        }
    }
}
