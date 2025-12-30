/** addAfterPosTest.java
 * program to unit-test the addAfterPos method of class D_LinkedList
 */
package d_linkedlist_app;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;

public class AddAfterPosTest
{
     @BeforeClass
    public static void setUpClass()
    {
        System.out.println("\ntesting the addAfterPos() method of class D_LinkedList\n");
    }
    
    
    /**
     * Test 1 of addAfterPos() method, of class D_LinkedList.
     */
    
    @Test
    public void test_emptyList_nodeShouldNotBeAddedAfterNoNode()
    {
        System.out.println("> Test1 - test_emptyList_nodeShouldNotBeAddedAfterNoNode(): operation should abort since there are no nodes in the list after which a new one can be positioned.");
        boolean expResult = false;
        System.out.print("creating an empty list...");
        D_LinkedList instance = new D_LinkedList();
        System.out.println("attempting to insert a new node after some node in an empty list...");
        int nodeIndex = 1;
        boolean result = instance.addAfterPos(10, nodeIndex);
        // test node insertion
        assertEquals("a mismatch was obtained, unexpectedly false was not returned", expResult, result);
        System.out.println("As expected, no node was added to the empty list since there were no nodes in the list after which a new one could be positioned.");
    }
    
    
    /**
     * Test 2 of addAfterPos() method, of class D_LinkedList.
     */
    
    @Test
    public void test_nonEmptyList_insertNewNodeAfterFirstNode_chainAllThreeNodesTogetherForwardly()
    {
        System.out.println("> Test2 - test_nonEmptyList_insertNewNodeAfterFirstNode_chainAllThreeNodesTogetherForwardly(): first node, new node and second node should be chained together in the forward direction.");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0, 0, 0};
        D_LinkedList instance = new D_LinkedList(a);
        // mark first node in list
        D_ListNode first = instance.head; 
        // mark second node in list
        D_ListNode second = first.next; 
        System.out.println("attempting to add a node after the first node in list...");
        int nodeIndex = 1;
        instance.addAfterPos(10, nodeIndex);
        // test node insertion
        assertEquals("first node, new node and second node were not chained together in the forward direction", first.next.next, second);
        System.out.println("As expected, first node, new node and second node were successfully chained together in the forward direction");
    }
    
    
    /**
     * Test 3 of addAfterPos() method, of class D_LinkedList.
     */
    
    @Test
    public void test_nonEmptyList_insertNewNodeAfterFirstNode_chainAllThreeNodesTogetherBackwardly()
    {
        System.out.println("> Test3 - test_nonEmptyList_insertNewNodeAfterFirstNode_chainAllThreeNodesTogetherBackwardly(): second node, new node and first node should be chained together in the reverse direction.");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0, 0, 0};
        D_LinkedList instance = new D_LinkedList(a);
        // mark first node in list
        D_ListNode first = instance.head; 
        // mark second node in list
        D_ListNode second = first.next; 
        System.out.println("attempting to add a node after the first node in list...");
        int nodeIndex = 1;
        instance.addAfterPos(10, nodeIndex);
        // test node insertion
        assertEquals("second node, new node and first node were not chained together in the reverse direction", second.prev.prev, first);
        System.out.println("As expected, second node, new node and first node were successfully chained together in the reverse direction");
    }
    
    
    /**
     * Test 4 of addAfterPos method, of class D_LinkedList.
     */
    
    @Test
    public void test_nonEmptyList_newValueInsertedAfterFirstNode()
    {
        System.out.println("> Test4 - test_nonEmptyList_newValueInsertedAfterFirstNode(): new data value should be stored in new node after first node in list");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0, 0, 0};
        D_LinkedList instance = new D_LinkedList(a);
        // mark first node in list
        D_ListNode first = instance.head; 
        // select arbitrary value to be added to list
        int obj = 29;
        System.out.println("adding a node after the first node in list...");
        int nodeIndex = 1;
        instance.addAfterPos(obj, nodeIndex);
        // test node insertion
        assertEquals("new data value was not found in new node", first.next.data, obj);
        System.out.println("As expected, new data was successfully stored in new node");
    }
    
    
    /**
     * Test 5 of addAfterPos() method, of class D_LinkedList.
     */
    
    @Test
    public void test_nonEmptyList_insertNewNodeInMiddleOfList_chainAllThreeNodesTogetherForwardly()
    {
        System.out.println("> Test5 - test_nonEmptyList_insertNewNodeInMiddleOfList_chainAllThreeNodesTogetherForwardly(): nodes before and after insertion point should be chained together with new node, in the forward direction");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0, 0, 0};
        D_LinkedList instance = new D_LinkedList(a);
        // select arbitrary node index after which to insert new node
        int nodeIndex = 4;
        // get to and mark node before insertion point
        D_ListNode before = instance.head; 
        for (int i = 1; i < nodeIndex; i++)
            before = before.next;
        // mark node after insertion point
        D_ListNode after = before.next; 
        System.out.println("attempting to add a new node after position nodeIndex in list...");
        instance.addAfterPos(10, nodeIndex);
        // test node insertion
        assertEquals("nodes before and after insertion point were not chained properly together with the new node, in the forward direction", before.next.next, after);
        System.out.println("As expected, nodes before and after the insertion point were chained together with the new node, in the forward direction");
    }
    
    
    /**
     * Test 6 of addAfterPos() method, of class D_LinkedList.
     */
    
    @Test
    public void test_nonEmptyList_insertNewNodeInMiddleOfList_chainAllThreeNodesTogetherBackwardly()
    {
        System.out.println("> Test6 - test_nonEmptyList_insertNewNodeInMiddleOfList_chainAllThreeNodesTogetherBackwardly(): nodes after and before insertion point should be chained together with new node, in the backward direction");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0, 0, 0};
        D_LinkedList instance = new D_LinkedList(a);
        // select arbitrary node index after which to insert new node
        int nodeIndex = 4;
        // get to and mark node before insertion point
        D_ListNode before = instance.head; 
        for (int i = 1; i < nodeIndex; i++)
            before = before.next;
        // mark node after insertion point
        D_ListNode after = before.next; 
        System.out.println("attempting to add a new node after position nodeIndex in list...");
        instance.addAfterPos(10, nodeIndex);
        // test node insertion
        assertEquals("nodes after and before insertion point were not chained properly together with the new node, in the backward direction", after.prev.prev, before);
        System.out.println("As expected, nodes after and before the insertion point were successfully chained together with the new node, in the backward direction");
    }
    
    
    /**
     * Test 7 of addAfterPos method, of class D_LinkedList.
     */
    
    @Test
    public void test_nonEmptyList_newValueInsertedAfterSomeMiddleNode()
    {
        System.out.println("> Test7 - test_nonEmptyList_newValueInsertedAfterSomeMiddleNode(): new data value should be stored in new node after some arbitrarily selected middle node in list");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0, 0, 0};
        D_LinkedList instance = new D_LinkedList(a);
        // select arbitrary node index after which to insert new node
        int nodeIndex = 4;
        // get to and mark node before insertion point
        D_ListNode before = instance.head; 
        for (int i = 1; i < nodeIndex; i++)
            before = before.next;
        // select arbitrary value to be added to list
        int obj = 29;
        System.out.println("adding a node after node with position nodeIndex in list...");
        instance.addAfterPos(obj, nodeIndex);
        // test node insertion
        assertEquals("new data value was not found in new node", before.next.data, obj);
        System.out.println("As expected, new data was successfully stored in new node");
    }
   
    
    /**
     * Test 8 of addAfterPos() method, of class D_LinkedList.
     */
    
    @Test
    public void test_nonEmptyList_insertNewNodeAfterLastNode_nextPointerOfLastNodeBeforeInsertionNotNull()
    {
        System.out.println("> Test8 - test_nonEmptyList_insertNewNodeAfterLastNode_nextPointerOfLastNodeBeforeInsertionNotNull(): the next pointer of the last node before insertion should no longer point to null");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0, 0, 0};
        D_LinkedList instance = new D_LinkedList(a);
        // get to and mark last node in list
        D_ListNode last = instance.head;
        int nodesInList = a.length;    //a.length
        for (int i = 1; i < nodesInList; i++)
            last = last.next;
        System.out.println("attempting to add a node after the last node in list...");
        int nodeIndex = nodesInList;
        instance.addAfterPos(10, nodeIndex);
        // test node insertion
        assertNotNull("the last node before insertion still points unexpectedly to null", last.next);
        System.out.println("As expected, the next pointer of the last node before insertion no longer points to null");
    }   
    
    
    /**
     * Test 9 of addAfterPos() method, of class D_LinkedList.
     */
    
    @Test
    public void test_nonEmptyList_insertNewNodeAfterLastNode_prevPointerOfNewLastNodePointsToLastNodeBeforeInsertion()
    {
        System.out.println("> Test9 - test_nonEmptyList_insertNewNodeAfterLastNode_prevPointerOfNewLastNodePointsToLastNodeBeforeInsertion(): the prev pointer of the new last node should point to the last node before insertion.");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0, 0, 0};
        D_LinkedList instance = new D_LinkedList(a);
        // get to and mark last node in list
        D_ListNode last = instance.head;
        int nodesInList = a.length;    //a.length
        for (int i = 1; i < nodesInList; i++)
            last = last.next;
        System.out.println("attempting to add a node after the last node in list...");
        int nodeIndex = nodesInList;
        instance.addAfterPos(10, nodeIndex);
        // mark new last node in list
        D_ListNode newLast = last.next;
        // test node insertion
        assertEquals("the prev pointer of the new last node does not point to the last node before insertion.", newLast.prev, last);
        System.out.println("As expected, the prev pointer of the new last node successfully points to the last node before insertion.");
    }
    
    
    /**
     * Test 10 of addAfterPos() method, of class D_LinkedList.
     */
    
    @Test
    public void test_nonEmptyList_insertNewNodeAfterLastNode_newLastNodeNextPointerIsNull()
    {
        System.out.println("> Test10 - test_nonEmptyList_insertNewNodeAfterLastNode_newLastNodeNextPointerIsNull(): the next pointer of the new last node should point to null.");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0, 0, 0};
        D_LinkedList instance = new D_LinkedList(a);
        // get to and mark last node in list
        D_ListNode last = instance.head;
        int nodesInList = a.length;    //a.length
        for (int i = 1; i < nodesInList; i++)
            last = last.next;
        System.out.println("attempting to add a node after the last node in list...");
        int nodeIndex = nodesInList;
        instance.addAfterPos(10, nodeIndex);
        // mark new last node in list
        D_ListNode newLast = last.next;
        // test node insertion
        assertNull("the next pointer of the new last node is not null.", newLast.next);
        System.out.println("As expected, the next pointer of the new last node successfully points to null.");
    }
    
    
    /**
     * Test 11 of addAfterPos method, of class D_LinkedList.
     */
    
    @Test
    public void test_nonEmptyList_newValueInsertedAfterLastNode()
    {
        System.out.println("> Test11 - test_nonEmptyList_newValueInsertedAfterLastNode(): new data value should be stored in new node after last node in list");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0, 0, 0};
        D_LinkedList instance = new D_LinkedList(a);
        // mark last node in list
        D_ListNode last = instance.head; 
        int nodesInList = a.length;
        for (int i = 1; i < nodesInList; i++)
            last = last.next;
        // select arbitrary value to be added to list
        int obj = 29;
        System.out.println("adding a node after the first node in list...");
        instance.addAfterPos(obj, nodesInList);
        // test node insertion
        assertEquals("new data value was not found in new node", last.next.data, obj);
        System.out.println("As expected, new data was successfully stored in new node");
    }
}
