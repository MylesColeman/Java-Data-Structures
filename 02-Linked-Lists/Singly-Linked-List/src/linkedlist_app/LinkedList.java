// LinkedList.java
// program demonstrating the implementation and use of a linked-list in java
// taken from Problem Solving with Java by Elliot Koffman and Ursula Woltz
// ADS class

package linkedlist_app;

public class LinkedList
{
    // Data fields (member variable)
    ListNode head;	// pointer to first node in list

    // Methods
    // default constructor - creates an empty list
    public LinkedList()
    {
        head = null;
    }
    
    
    // Constructor - creates a list from an array. The array is passed as a parameter
    public LinkedList(int[] a)
    {
        // DO NOT MODIFY THIS CONSTRUCTOR.
        
        // Populate list.
        for (int i = a.length - 1; i >= 0; i--) {
            head = new ListNode(a[i], head);
        }
    
    }
    
    
   
    // postcondition: Adds a node storing obj at front of this list.
    public void addFirst(int obj)
    {
        ListNode newNode = new ListNode(obj);
        newNode.next = head;
        
        head = newNode;
    }
    
        // postcondition: Returns the length of this list.
    public int getSize()
    {
        int counter = 0;
        ListNode current = head;
        
        while (current != null)
        {
            counter++;
            current = current.next;
        }
        
        return counter;
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
        ListNode current = head;
        
        while (current != null)
        {
            sb.append(current.data);
            sb.append("\n");
            current = current.next;
        }
        
        return sb.toString();
    }

    
    // postcondition: Returns int stored at head of this list.
    public int getFirst()
    {
        if (head == null)
            return 999;
        else
            return head.data;
    }

    
    // postcondition: Returns int stored at end of this list.
    public int getLast()
    {
        if (head == null)
            return 999;
        
        ListNode current = head;
        
        while (current.next != null)
            current = current.next;
        
        return current.data;
    }
    
       
    // postcondition: Adds a node storing obj at end of this list.
    public void addLast(int obj)
    {
        ListNode newNode = new ListNode(obj);
        
        if (head == null)
            head = newNode;
        else
        {
            ListNode current = head;
            
            while (current.next != null)
                current = current.next;
            
            current.next = newNode;
        }
    }
    
    
    // precondition: list is pointed to by head; last node, if any, points to null
    // postcondition: returns a pointer to node containing a desired value, or null if not found
    public ListNode searchPointer(int n)
    {
        ListNode current = head;
            
            while (current != null)
            {
                if (current.data == n)
                    return current;
                else
                    current = current.next; 
            }
            
            return null;
    }// end of method searchPointer()
    
    
    // precondition: list is pointed to by head; last node, if any, points to null
    // postcondition: returns a one-based index to node containing a desired value, or -1 if not found
    public int searchIndex(int n)
    {
        int counter = 1;
        ListNode current = head;
            
            while (current != null)
            {
                if (current.data == n)
                    return counter;
                
                counter++;
                    current = current.next;
            }
            
            return -1;
    }// end of method searchIndex()
    
    
    // precondition: list is pointed to by head; last node, if any, points to null
    // postcondition: nth node is deleted if it exists. A 1-based index is used
    public boolean delete(int n)
    {
        if (head == null)
            return false;
        
        if (n == 1)
        {
            ListNode temp = head;
            head = head.next;
            temp.next = null;
            return true;
        }
        
        ListNode current = head;
        ListNode previous = null;
        int count = 1;
        
        while (current != null && count != n)
        {
            previous = current;
            current = current.next;
            count++;
        }
        
        if (current == null)
            return false;
        
        previous.next = current.next;
        current.next = null;
        return true;
        
    }// end of delete() method
    
    
    // postcondition: retrieves the data stored in node at position index of list.
    public int getAtPos(int index)
    {
        int counter = 1;
        ListNode current = head;
        
        while (current != null)
        {
            if (counter == index)
                return current.data;
            
            counter++;
            current = current.next;
        }
        
        return 999;
    }

    
    // precondition: a list must exist with at least one node
    // postcondition: Adds a node storing obj after position index in list.
    public boolean addAfterPos(int obj, int index)
    {
        if (head == null)
            return false;
        
        if (index < 1)
            return false;
        
        ListNode newNode = new ListNode(obj);
        
        ListNode current = head;
        int counter = 1;
        
        while (current != null && counter < index)
        {
            current = current.next;
            counter++;
        }
        
        if (current == null)
            return false;
        
        newNode.next = current.next;
        current.next = newNode;
        return true;
    }
    
    
    // Method used in print statements - DO NOT ALTER !
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
    
    public int removeNodesWithValue(int value)
    {
        if (head == null)
            return 0;
        
        int removedCount = 0;
        ListNode current = head;
        ListNode previous = null;
        
        while (current != null)
        {
            if(current.data == value)
            {
                if (previous == null)
                    head = current.next;
                else
                {
                    previous.next = current.next;
                }
                
                removedCount++;
                ListNode temp = current;
                current = current.next;
                temp.next = null;
            }
            else
            {
                previous = current;
                current = current.next;
            }
        }
        return removedCount;
    }
    
    public ListNode removeNodesAndReturnDeleted(int value)
    {
        ListNode deletedHead = null;
        ListNode deletedTail = null;
        ListNode current = head;
        ListNode previous = null;
        
        while (current != null)
        {
            if (current.data == value)
            {
                if (previous == null)
                    head = current.next;
                else
                {
                    previous.next = current.next;
                }
                
                if (deletedHead == null)
                {
                    deletedHead = current;
                    deletedTail = current;
                }
                else
                {
                    deletedTail.next = current;
                    deletedTail = current;
                }
                
                ListNode temp = current;
                current = current.next;
                temp.next = null;
            }
            else
            {
                previous = current;
                current = current.next;
            }
        }
        return deletedHead;
    }
        
} // end of class LinkedList