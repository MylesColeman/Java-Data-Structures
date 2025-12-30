/* A program demonstrating the implementation and use of an array-based stack in 
 * Java taken from Problem Solving with Java by Elliot Koffman and Ursula 
 * Woltz. */

 package liststacktest;
 
/**
 * The driver class for the list stack app. Do not modify this file.
 *
 */
public class ListStack_App
{
    /**
     * The main method for the list stack app.
     *
     * @param args  the program's command-line arguments
     */
    public static void main(String[] args)
    {
        ListStack stack = new ListStack();
        
        // Show that stack is empty.
        String msg = stack.isEmpty() ? "Stack is empty." : "Stack is not empty.";
        System.out.println(msg);
        
        System.out.println("Pushing 4 values into the stack...");
        // Push values on to stack.
        stack.push(5.0);
        stack.push(6.5);
        stack.push(-3.0);
        stack.push(-8.0);
        
        // Display stack contents.
        stack.displayStack();
        
        // Show top of stack.
        System.out.println("Top: " + stack.peek());
    
        // Pop top value.
        System.out.println("stack.pop() to remove the top value");
        stack.pop();
        
        // Show top of stack again.
        System.out.println("The new Top is: " + stack.peek());
        
        // Empty stack.
        System.out.println("Emptying the whole stack...");
        while (!stack.isEmpty())
        {
            stack.pop();
        }
        
        // Demonstrate that stack is empty.
        System.out.println("Printing the new stack: ");
        stack.displayStack();
        
        ListStack LStack = new ListStack();
        LStack.push(2);
        LStack.push(5);
        LStack.push(10);
        LStack.push(25);
        
        LStack.pop();
        LStack.pop();
        LStack.pop();
        
        String otherMsg = LStack.isEmpty() ? "Stack is empty." : "Stack is not empty.";
        System.out.println(otherMsg);
        
        System.out.println("Top: " + LStack.peek());
    }
}

