/* A program demonstrating the implementation and use of an array-based stack in 
 * Java taken from Problem Solving with Java by Elliot Koffman and Ursula 
 * Woltz. */

 package liststacktest;
 
/**
 * Represents a node in a linked list. Do not modify this file.
 */
public class ListNode
{
    /**
     * Stores the data for the node (a double value).
     */
    double data;

    /**
     * Stores the link to the next node. 
     */
    ListNode next;

    /**
     * Creates a new empty node.
     */
    public ListNode()
    {
        data = 0;
        next = null;
    }

    /**
     * Creates a new node with `data` stored in it.
     *
     * @param data  the data to store in the new node
     */
    public ListNode(double value)
    {
        data = value;
        next = null;
    }

    /**
     * Creates a new node storing `data` and linked to `next`.
     *
     * @param data  the data to store in the new node
     * @param next  the next node in the list
     */
    public ListNode(double value, ListNode n)
    {
        data = value;
        next = n;
    }
}
