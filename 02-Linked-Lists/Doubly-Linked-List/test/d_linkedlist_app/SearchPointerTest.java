/** SearchPointerTest.java
 * program to unit-test the searchPointer method of class D_LinkedList
 */
package d_linkedlist_app;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;


public class SearchPointerTest
{
    @BeforeClass
    public static void setUpClass()
    {
        System.out.println("\ntesting the searchPointer() method of class D_LinkedList\n");
    }
    
    
    /**
     * Test 1 of searchPointer method of class D_LinkedList.
     */
    //@Ignore
    @Test
    public void test_emptyList()
    {
        System.out.println("> Test1 - searchPointer in empty list: should return null");
        System.out.print("creating an empty list...");
        D_LinkedList instance = new D_LinkedList();
        D_ListNode expResult = null;
        // select arbitrary value to search in list 
        int desVal = 3;
        System.out.println("attempting to locate node with desired value...");
        D_ListNode result = instance.searchPointer(desVal);
        // test node searching
        assertEquals("although the list is empty, null was not returned", expResult, result);
        System.out.println("As expected, null was returned");
    }
    
    
    /**
     * Test 2 of searchPointer method of class D_LinkedList.
     */
    //@Ignore
    @Test
    public void test_nonEmptyList_dataInFirstNode()
    {
        System.out.println("> Test2 - searchPointer in non-empty list with desired value in first node: should return pointer to first node");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0, 0, 0};
        D_LinkedList instance = new D_LinkedList(a);
        // set desired value to search for
        int desVal = 5;
        // mark first node in list
        D_ListNode first = instance.head;
        //insert arbitrary value into first node
        first.data = desVal;
        D_ListNode expResult = first;
        System.out.println("attempting to locate node with desired value...");
        D_ListNode result = instance.searchPointer(desVal);
        // test node searching
        assertEquals("a pointer to the first node was not returned", expResult, result);
        System.out.println("As expected, a pointer to the first node was returned");
    }
    
    
    /**
     * Test 3 of searchPointer method of class D_LinkedList.
     */
    //@Ignore
    @Test
    public void test_nonEmptyList_dataInMiddleNode()
    {
        System.out.println("> Test3 - searchPointer in non-empty list with desired value in a node in middle of list: should return pointer to corresponding node");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0, 0, 0};
        D_LinkedList instance = new D_LinkedList(a);
        // select an arbitrary node to contain the desired value
        int nodeIndex = 4;
        // get to and mark target node
        D_ListNode target = instance.head;
        for (int i = 1; i < nodeIndex; i++)
            target = target.next;
        // set desired value to search for
        int desVal = 5;
        // insert desired value into target node
        target.data = desVal;
        D_ListNode expResult = target;
        System.out.println("attempting to locate node with desired value...");
        D_ListNode result = instance.searchPointer(desVal);
        // test node searching
        assertEquals("a pointer to the target node was not returned", expResult, result);
        System.out.println("As expected, a pointer to the correct node was returned");
    }
    
    
    /**
     * Test 4 of searchPointer method of class D_LinkedList.
     */
    //@Ignore
    @Test
    public void test_nonEmptyList_dataInLastNode()
    {
        System.out.println("> Test4 - searchPointer in non-empty list with desired value in last node of list: should return pointer to last node");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0, 0, 0};
        int nodesInList = a.length;
        D_LinkedList instance = new D_LinkedList(a);
        // get to and mark last node
        D_ListNode last = instance.head;
        for (int i = 1; i < nodesInList; i++)
            last = last.next;
        // set desired value to search for
        int desVal = 5;
        // insert desired value into last node
        last.data = desVal;
        D_ListNode expResult = last;
        System.out.println("attempting to locate node with desired value...");
        D_ListNode result = instance.searchPointer(desVal);
        // test node searching
        assertEquals("a pointer to the last node was not returned", expResult, result);
        System.out.println("As expected, a pointer to the last node was returned");
    }
    
    
    /**
     * Test 5 of searchPointer method of class D_LinkedList.
     */
    //@Ignore
    @Test
    public void test_nonEmptyList_dataNotFound()
    {
        System.out.println("> Test5 - searchPointer in non-empty list with desired value not in list: should return pointer to null");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0, 0, 0};
        D_LinkedList instance = new D_LinkedList(a);
        // set desired value to search for
        int desVal = 5;
        D_ListNode expResult = null;
        System.out.println("attempting to locate node with desired value...");
        D_ListNode result = instance.searchPointer(desVal);
        // test node searching
        assertEquals("although value was not found, a pointer to null was not returned", expResult, result);
        System.out.println("As expected, value was not found in list, a pointer to null was returned");
    }
}
