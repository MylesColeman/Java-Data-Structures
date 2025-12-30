/** D_ListNode.java
 * class D_ListNode representing a node with information and link fields
 * adapted from Problem Solving with Java by Elliot Koffman and Ursula Woltz
 */

package d_linkedlist_app;

public class D_ListNode
{
    // Data fields
    int		data;	// data stored in the node
    D_ListNode	next;	// link to next node
    D_ListNode  prev;   // link to previous node

    // Methods
    //Constructors
    // postcondition: Creates a new empty node
    public D_ListNode()
    {
            data = 0;
            next = null;
            prev = null;
    }

    // postcondition: Creates a new node storing obj
    public D_ListNode(int obj)
    {
            data = obj;
            next = null;
            prev = null;
    }

    // postcondition: Creates a new node storing obj
    // and linked to node referenced by link.
    public D_ListNode(int obj, D_ListNode succ, D_ListNode pred)
    {
            data = obj;
            next = succ;
            prev = pred;
    }
} // end of class D_ListNode