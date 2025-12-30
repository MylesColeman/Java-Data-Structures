// C_LinkedList.java
// program demonstrating the implementation and use of a circular linked-list in java.
// This variation contains a dummy or sentinel node to simplify and accelerate some of the list-handling algorithms.
// This node marks the start of the list (and end of the list).
// head always points to the dummy/sentinel node. A 1-based indexing system is used.
// adapted from Problem Solving with Java by Elliot Koffman and Ursula Woltz
// ADS class

package c_linkedlist_app;

public class C_LinkedList
{
    // Data fields (member variable)
    ListNode head;	// pointer to dummy/sentinel node in list. This marks the start of the list.

    // default constructor - creates an empty list with only a sentinel node containing sentinel value 999
    // head points towards the dummy/sentinel node
    public C_LinkedList()
    {
        ListNode newNode = new ListNode(999);
        head = newNode;
        newNode.next = head;
    }
    
    
    // Constructor - creates a circular list from an array. The array and its size are passed as parameters
    // head points towards the dummy/sentinel node
    public C_LinkedList(int[] a)
    {
        ListNode last = null;
        ListNode newNode = null;
        ListNode prev = null;
        int size = a.length;
        for (int i = 1; i <= size; i++)
        {
            newNode = new ListNode(a[size - i], prev);
            if (i == 1)
              last = newNode;
            prev = newNode;
        }
        head = new ListNode(999, newNode);
        last.next = head;
    }
   
    
    // Methods
    
    // Method to check if circular linked lists is empty
    public boolean isEmpty()
    {
        return head.next == head;
    }
    
    
    // postcondition: Adds a node storing obj at front of this list.
    public void addFirst(int obj)
    {
        ListNode newNode = new ListNode(obj);
        
        if (head.next == head)
        {
            newNode.next = head;
            head.next = newNode;
        }
        else
        {
            newNode.next = head.next;
            head.next = newNode;
        }
    }

    
    // postcondition: Adds a node storing obj at end of this list.
    public void addLast(int obj)
    {
        ListNode newNode = new ListNode(obj);
        
        if (head.next == head)
        {
            newNode.next = head;
            head.next = newNode;
        }
        else
        {
            ListNode current = head;
        
            while (current.next != head)
                current = current.next;
            
            newNode.next = head;
            current.next = newNode;
        }   
    }
    
    
    // precondition: a list must exist with at least one node
    // postcondition: Adds a node storing obj after position index in list.
    public boolean addAfterPos(int obj, int index)
    {
        if (index < 1)
            return false;
        
        ListNode newNode = new ListNode(obj);
        ListNode current = head.next;
        int counter = 1;
        
        if (head.next == head && index == 1) 
        { 
            return false;
        }
        
        while (current != head && counter < index)
        {
            current = current.next;
            counter++;
        }
        
        if (current == head)
        {
            return false;
        }
        
        newNode.next = current.next;
        current.next = newNode;
        return true;
    }


    // postcondition: Returns int stored at head of this list.
    public int getFirst()
    {
        if (head.next == null)
            return 999;
        
        return head.next.data;   
    }

    
    // postcondition: Returns int stored at end of this list.
    public int getLast()
    {
        if (head.next == head)
            return 999;
        
        ListNode current = head;
        
        while (current.next != head)
            current = current.next;
        
        return current.data;
    }
    
    
    // postcondition: retrieves the data stored in node at position index of list.
    public int getAtPos(int index)
    {
        int counter = 1;
        ListNode current = head.next;
        
        while (current != head)
        {
            if (counter == index)
                return current.data;
            
            counter++;
            current = current.next;
        }
        
        return 999;
    }
    
    
    // postcondition: Returns the length of this list.
    public int getSize()
    {
        int counter = 0;
        ListNode current = head.next; // Start from the first actual node, not the dummy.

        while (current != head) 
        {
            counter++;
            current = current.next;
        }
        return counter;
    }

    
    // precondition: The last link node has a link to head.
    // postcondition: Returns a string formed by concatenating the 
    //	data fields of all list nodes.
    @Override
    public String toString()
    {
        if (head.next == head)
            return "";
        
        StringBuilder sb = new StringBuilder();
        ListNode current = head.next;
        
        while (current != head)
        {
            sb.append("\n");
            sb.append(current.data);
            
            current = current.next;
        }
        
        return sb.toString();
    }

    // precondition: list is pointed to by the dummy node's link pointer; the link pointer of the last node, if it exists, points to head
    // postcondition: nth node is deleted if it exists. A 1-based index is used.
    public boolean delete(int n)
    {
        if (head.next == head)
            return false;
        
        if (n <= 0)
            return false;
        
        if (n == 1)
        {
            ListNode toDelete = head.next;
            head.next = head.next.next;
            toDelete.next = null;
            return true;
        }
        
        ListNode current = head.next;
        ListNode previous = head;
        int counter = 1;
        
        while (current != head && counter < n)
        {
            previous = current;
            current = current.next;
            counter++;
        }
        
        if (current == head)
            return false;
        
        previous.next = current.next;
        current.next = null;
        return true;
    }// end of delete() method
    
    
    // precondition: list is pointed to by the dummy node's link pointer; the link pointer of the last node, if it exists, points to head
    // postcondition: returns a pointer to node containing a desired value, or null if not found
    public ListNode searchPointer(int n)
    {
        ListNode current = head.next;
            
            while (current != head)
            {
                if (current.data == n)
                    return current;
                else
                    current = current.next; 
            }
            
            return null;
    }// end of method searchPointer()
    
    
    // precondition: list is pointed to by the dummy node's link pointer; the link pointer of the last node, if it exists, points to head
    // postcondition: returns a one-based index to node containing a desired value, or -1 if not found
    public int searchIndex(int n)
    {
        int counter = 1;
        ListNode current = head.next;
            
            while (current != head)
            {
                if (current.data == n)
                    return counter;
                
                counter++;
                    current = current.next;
            }
            
            return -1;
    }// end of method searchIndex()
    
    
    // Method used in print statements
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
        
} // end of class C_LinkedList
