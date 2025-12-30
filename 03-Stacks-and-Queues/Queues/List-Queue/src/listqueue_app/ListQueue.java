/* A program demonstrating the implementation and use of an list-based queue in 
 * Java taken from Problem Solving with Java by Elliot Koffman and Ursula 
 * Woltz. */

//import java.util.Queue;

package listqueue_app;

import java.lang.Exception;
/**
 * Represents a list-based queue.
 *
 */
public class ListQueue
{
    /**
     * Stores the node at the front of the queue.
     */
    private ListNode front;
        
    /**
     * Stores the node at the back (rear) of the queue.
     */
    private ListNode rear;

    /**
     * Initialises a new instance of a list-based queue.
     */
    public ListQueue() 
    {
        front = null;
        rear = null;
    }
    
    
        /**
     * Returns true if the queue is empty, otherwise returns false.
     *
     * @return    true if the queue is empty, otherwise false
     */
    public boolean isEmpty()
    { 
        /* We know the queue is empty if there is no item at the front (that is,
         * if `front` is null. */
         
       return front == null;
    }
    
    /**
     * Adds an item to the back of the queue (enqueues it).
     * 
     * @param item    the data to add
     */
    public void enqueue(String item)
    {
        /* Enqueues item in a new node and resets rear to reference the new 
         * node. If the queue has 1 element, front should also reference the new
         * node. */
        
        ListNode newNode = new ListNode(item);
        if (isEmpty())
        {
            front = newNode;
            rear = newNode;
        }
        else
        {
            rear.next = newNode;
            rear = newNode;
        }
         
    }

    /**
     * Removes an item from the front of the queue and returns it (dequeues it).
     * 
     * @return the item at the front of the queue.
     */
    public String dequeue()
    {
        /* If the queue is not empty, returns its first element & front 
         * references new first element. If the queue is empty, return an empty string*/
         
       if (isEmpty())
           return "";
       else
       {
           String dequeuedItem = front.data;
           front = front.next;
           if (front == null)
               rear = null;
           
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
        /* If the queue is not empty, returns its first element. Otherwise, return an empty string*/
        if (isEmpty())
            return "";
        else
            return front.data;
    }


    /**
     * Returns the size of the queue.
     *
     * @return    the size of the queue
     */
    public int getSize()
    {
        /* We can count the size of the queue just like we count the size of
         * linked lists. Start at the head (in this case, the front) and follow
         * the links, keeping count until we hit a null link. Then we know we're
         * done. */
         
        int count = 0;
        ListNode current = front;
        while (current != null)
        {
            count++;
            current = current.next;
        }
        
        return count;
    }

    /**
     * Searches for the specified item in the queue and shifts it to the front.
     * 
     * @param item    the item to search for
     */
    public void moveToFront(String item)
    {
        /* We need to find the given item in the queue, and then dequeue from
         * the front and enqueue at the back until that item is at the front. 
        If the item is not in the list print the message "The item is not in the list"*/
         
        if (isEmpty())
        {
            System.out.println("The item is not in the list");
            return;
        }
        
        ListNode current = front;
        ListNode previous = null;
        while (current != null)
        {
            if (current.data.equals(item))
            {
                if (current == front)
                    return;
                if (current == rear)
                    rear = previous;
                previous.next = current.next;
                current.next = front;
                front = current;
                return;
            }
            previous = current;
            current = current.next;
        }
        System.out.println("The item is not in the list");
    }

    @Override
    public String toString()
    {
        // Do not modify this method, but do understand how it works.

        // Build string.
        String result = "Front: \n";
        ListNode current = front;
        while (current != null)
        {
            result = result + current.data + "\n"; // Don't forget the newline!
            current = current.next;
        }
        return result;
    }
}

