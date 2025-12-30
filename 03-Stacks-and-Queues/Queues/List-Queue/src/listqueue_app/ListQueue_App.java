
/* A program demonstrating the implementation and use of an list-based queue in 
 * Java taken from Problem Solving with Java by Elliot Koffman and Ursula 
 * Woltz. */

package listqueue_app;

/**
 * The driver class for the list queue app. Do not modify this file.
 *
 */
public class ListQueue_App
{
    /**
     * The main method for the list queue app.
     *
     * @param args  the program's command-line arguments
     */
    public static void main(String[] args)
    {
        // Initialize queue.
        ListQueue queue = new ListQueue();

        // Enqueue 4 names
        queue.enqueue("Chris");
        queue.enqueue("Robin");
        queue.enqueue("Debbie");
        queue.enqueue("Richard");
        
        // Print out queue.
        System.out.println("Full List: ");
        System.out.println(queue.toString());

        // Dequeue first name.
        String name = queue.dequeue();
        System.out.println("Dequeued " + name + ".");
        
        // Print out queue.
        System.out.println("Full List: ");
        System.out.println(queue.toString());

        // Enqueue extra name.
        queue.enqueue("Dustin");
        System.out.println("Enqueued Dustin.");
        
        // Print out queue.
        System.out.println("Full List: ");
        System.out.println(queue.toString());

        // Dequeue name.
        name = queue.dequeue();
        System.out.println("Dequeued " + name + ".");

        // Print out queue.
        System.out.println("Full List: ");
        System.out.println(queue.toString());
        
        // Print queue size.
        System.out.println("Size of queue is " + queue.getSize() + ".");

        // Enqueue priority person.
        queue.enqueue("Lizzie");
        System.out.println("Enqueued Lizzie.");

        // Print queue with priority person at back.
        System.out.println(queue.toString());

        // Move priority person to front.
        queue.moveToFront("Lizzie");
        System.out.println("Lizzie moved to front.");

        // Print out queue again, priority person should be at front.
        System.out.println(queue.toString());
        
        ListQueue LQueue = new ListQueue();
        
        LQueue.enqueue("25");
        LQueue.enqueue("10");
        LQueue.enqueue("5");
        LQueue.enqueue("2");
        
        LQueue.dequeue();
        LQueue.dequeue();
        LQueue.dequeue();
        
        System.out.println(LQueue.isEmpty() ? "Queue is empty." : "Queue is not empty.");
        
        System.out.println("Peeked at " + LQueue.peek() + ".");
    }
}
