// D_LinkedList.java
// program demonstrating the implementation and use of a doubly linked-list in java
// adapted from Problem Solving with Java by Elliot Koffman and Ursula Woltz
// ADS class

package d_linkedlist_app;

public class D_LinkedList
{
    // Data fields (member variable)
    D_ListNode head;	// pointer to first node in list

    // Methods
    // default constructor - creates an empty list
    public D_LinkedList()
    {
        head = null;
    }
  
    
    // Constructor - creates a list from an array. The array and its size are passed as parameters.
    // Constructor - creates a list from an array. The array and its size are passed as parameters.
    public D_LinkedList(int[] a)
    {
         for (int i = a.length - 1; i >= 0; i--) {
            D_ListNode n = new D_ListNode(a[i], head, null);
            if (head != null) {
                head.prev = n;
            }
            head = n;
        }
    }

    
    //Methods
    
    // postcondition: Adds a node storing obj after position index in list.
    public boolean addAfterPos(int obj, int index)
    {
        if (head == null)
            return false;
        
        if (index < 1)
            return false;
        
        D_ListNode newNode = new D_ListNode(obj);
        
        D_ListNode current = head;
        int counter = 1;
        
        while (current != null && counter < index)
        {
            current = current.next;
            counter++;
        }
        
        if (current == null)
            return false;
        
        newNode.next = current.next;
        newNode.prev = current;
        current.next = newNode;
        
        if (newNode.next != null)
        {
            newNode.next.prev = newNode;
        }
        return true; 
    }
   
    // precondition: The last link node has a null link.
    // postcondition: Returns a string formed by concatenating the 
    //	data fields of all list nodes.
    @Override
    public String toString()
    {
        if (head == null)
            return "";
        
        StringBuilder sb = new StringBuilder();
        D_ListNode current = head;
        
        while (current != null)
        {
            sb.append("\n");
            sb.append(current.data);
            
            current = current.next;
        }
        
        return sb.toString();
    }
    
    public String ordinality(int n)
    {
        String pos;
          
        if ((n%10 == 1) && (n != 11))
            pos = "st";
        else if ((n%10 == 2) && (n != 12))
            pos = "nd";
        else if ((n%10 == 3) && (n != 13))
            pos = "rd";
        else
            pos = "th";
        
        return pos;
    }
        
} // end of class D_LinkedList
