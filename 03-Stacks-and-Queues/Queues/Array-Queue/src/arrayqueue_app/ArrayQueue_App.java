/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrayqueue_app;

/* A program demonstrating the implementation and use of an array-based queue in Java taken from Problem Solving with  
   Java by Elliot Koffman and Ursula Woltz. */

import java.util.*;
 
/**
 * The driver class for the array queue app. Do not modify this file.
 *
 */
public class ArrayQueue_App
{
	/**
	 * Scanner used to read input from user.
	 */
	private static Scanner reader;
	
	/**
	 * A utility method to wait for user input.
	 */
	private static String readline()
	{
		if (reader == null) {
			reader = new Scanner(System.in);
		}
		return reader.nextLine();
	}

    /**
     * The main method for the array queue app.
     *
     * @param args  the program's command-line arguments
     */
    public static void main(String[] args)
    {
        // Initialize queue.
        ArrayQueue queue = new ArrayQueue(10);

        // Print empty status.
        System.out.println(queue.isEmpty() ? "Queue is empty." : "Queue is not empty.");
        
       
        
        // Enqueue 4 names
        queue.enqueue("Chris");
        queue.enqueue("Robin");
        queue.enqueue("Debbie");
        queue.enqueue("Richard");
        
        // Print out queue.
        queue.displayQueue();
        
        
        
        // Print empty status.
        System.out.println(queue.isEmpty() ? "Queue is empty." : "Queue is not empty.");

        
        
        // Dequeue first name.
        String name = queue.dequeue();
        System.out.println("Dequeued " + name + ".");

        // Print out queue 
        queue.displayQueue();
        
        // Enqueue extra name.
        System.out.println("Adding Dusting to the queue...");
        queue.enqueue("Dustin");
        
        // Print out queue with new person at the back.
        queue.displayQueue();
        
        // Peek name.
        name = queue.peek();
        System.out.println("Peeked at " + name + ".");

        
        
        // Print queue size.
        System.out.println("Size of queue is " + queue.getSize() + ".");

        
        
        // Enqueue priority person.
        System.out.println("Adding Lizzie to the queue...");
        queue.enqueue("Lizzie");

        // Print out queue with priority person at back.
        queue.displayQueue();

        
        
        // Move priority person to front.
        System.out.println("Move Lizze to Front");
        queue.moveToFront("Lizzie");
        
        // Print out queue with priority person at front.
        queue.displayQueue();
        

        
        // Dequeue name. - Comment out if you want to move him to the back
        name = queue.dequeue();
        System.out.println("Dequeued " + name + ".");
                
        

        // Move low-priority person to back.
        System.out.println("Move Robin to Back");
        queue.moveToBack("Robin");
        
        // Print out queue with low-priority person at back.
        queue.displayQueue();
        
        System.out.println("Printing queue with the toString() method: ");
        System.out.println(queue.toString());
        
        ArrayQueue aQueue = new ArrayQueue(4);
        aQueue.enqueue("25");
        aQueue.enqueue("10");
        aQueue.enqueue("5");
        aQueue.enqueue("2");
        
        aQueue.dequeue();
        aQueue.dequeue();
        aQueue.dequeue();
        
        System.out.println(aQueue.isEmpty() ? "Queue is empty." : "Queue is not empty.");
        
        name = aQueue.peek();
        System.out.println("Peeked at " + name + ".");
        
        ArrayQueue aQueueCircular = new ArrayQueue(4);
        
        aQueueCircular.enqueue("25");
        aQueueCircular.enqueue("10");
        aQueueCircular.enqueue("5");
        aQueueCircular.enqueue("2");
        
        aQueueCircular.dequeue();
        aQueueCircular.dequeue();
        aQueueCircular.dequeue();
        
        System.out.println(aQueueCircular.isEmpty() ? "Queue is empty." : "Queue is not empty.");
        
        name = aQueueCircular.peek();
        System.out.println("Peeked at " + name + ".");
    }
}
