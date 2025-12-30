/** DeleteTest.java
 * program to unit-test the delete method of class D_LinkedList
 */
package d_linkedlist_app;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;

  
public class DeleteTest
{
    @BeforeClass
    public static void setUpClass()
    {
        System.out.println("\ntesting the delete() method of class D_LinkedList\n");
    }
    
    
     /**
     * Test 1 of delete method, of class D_LinkedList.
     */
    
    @Test
    public void test_emptyList_headNull()
    {
        System.out.println("> Test1 - test_emptyList_headNull(): head should still point to null");
        System.out.print("creating an empty list...");
        D_LinkedList instance = new D_LinkedList();
        System.out.println("attempting to delete a node with an arbitrary index in a non-existing list...");
        // select node to be deleted
        int nodeIndex = 3;
        boolean result = instance.delete(nodeIndex);
        // test node deletion
        assertNull("head no longer points to null", instance.head);
        System.out.println("As expected, deleting aborted, head still points to null");
    }
    
    
    /**
     * Test 2 of delete method, of class D_LinkedList.
     */
    
    @Test
    public void test_emptyList_deleteAnyNode()
    {
        System.out.println("> Test2 - test_emptyList_deleteAnyNode(): should fail");
        System.out.print("creating an empty list...");
        D_LinkedList instance = new D_LinkedList();
        boolean expResult = false;
        System.out.println("attempting to delete a node with an arbitrary index in a non-existing list...");
        // select node to be deleted
        int nodeIndex = 3;
        boolean result = instance.delete(nodeIndex);
        // test node deletion
        assertEquals(expResult, result);
        System.out.println("As expected, no node was found, deleting aborted");
    }

    
    /**
     * Test 3 of delete method, of class D_LinkedList.
     */
    
    @Test
    public void test_nonEmptyList_invalidIndex_headNotNull()
    {
        System.out.println("> Test3 - test_nonEmptyList_invalidIndex_headNotNull(): head should remain not null");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0, 0, 0};
        D_LinkedList instance = new D_LinkedList(a);
        // mark first node in list
        D_ListNode first = instance.head;
        System.out.println("attempting to delete a node with an invalid index...");
        // select node to be deleted
        int nodeIndex = 0;
        boolean result = instance.delete(nodeIndex);
        // test node deletion
        assertEquals("head no longer pointing to first node of list", instance.head, first);
        System.out.println("As expected, node was not found, deleting aborted, head is still non-null and pointing to first node in list");        
    }
    
    
    /**
     * Test 4 of delete method, of class D_LinkedList.
     */
    
    @Test
    public void test_nonEmptyList_invalidIndex()
    {
        System.out.println("> Test4 - attempting to delete a node with an invalid index in a non-empty list: should fail");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0, 0, 0};
        D_LinkedList instance = new D_LinkedList(a);
        System.out.println("attempting to delete a node with an invalid index...");
        // select node to be deleted
        int nodeIndex = 0;
        boolean expResult = false;
        boolean result = instance.delete(nodeIndex);
        // test node deletion
        assertEquals(expResult, result);
        System.out.println("As expected, node was not found, deleting aborted");
    }

        
    /** Test 5 of delete method, of class D_LinkedList.
     */
    
    @Test
    public void test_nonEmptyList_deleteFirstNode_headDisconnected()
    {    
        System.out.println("> Test5 - attempting to delete the first node of a list: head should be disconnected from deleted node");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0, 0, 0};
        D_LinkedList instance = new D_LinkedList(a);
        // mark node to be deleted
        D_ListNode toDelete = instance.head;
        System.out.println("attempting to delete first node in list...");
        // select node to be deleted
        int nodeIndex = 1;
        boolean result = instance.delete(nodeIndex);
        // test node deletion    
        assertNotSame("head of list still connected to deleted node", instance.head, toDelete);
        System.out.println("As expected, head no longer points to deleted node");
    }

    
    /** Test 6 of delete method, of class D_LinkedList.
     */
    
    @Test
    public void test_nonEmptyList_deleteFirstNode_deletedNodeNextPointerIsNull()
    {    
        System.out.println("> Test6 - attempting to delete the first node of a list: deleted node's next pointer should point to null");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0, 0, 0};
        D_LinkedList instance = new D_LinkedList(a);
        // mark node to be deleted
        D_ListNode toDelete = instance.head;
        System.out.println("attempting to delete first node in list...");
        // select node to be deleted
        int nodeIndex = 1;
        boolean result = instance.delete(nodeIndex);
        // test node deletion    
        assertNull("deleted node not connected to null", toDelete.next);
        System.out.println("As expected, deleted node's next pointer is successfully pointing to null");
    }
    
    
    /** Test 7 of delete method, of class D_LinkedList.
     */
    
    @Test
    public void test_nonEmptyList_deleteFirstNode_deletedNodePrevPointerIsNull()
    {    
        System.out.println("> Test7 - attempting to delete the first node of a list: deleted node's prev pointer should point to null");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0, 0, 0};
        D_LinkedList instance = new D_LinkedList(a);
        // mark node to be deleted
        D_ListNode toDelete = instance.head;
        System.out.println("attempting to delete first node in list...");
        // select node to be deleted
        int nodeIndex = 1;
        boolean result = instance.delete(nodeIndex);
        // test node deletion    
        assertNull("deleted node not connected to null", toDelete.prev);
        System.out.println("As expected, deleted node's prev pointer is successfully pointing to null");
    }
    
    
    /**
     * Test 8 of delete method, of class D_LinkedList.
     */
    
    @Test
    public void test_nonEmptyList_deleteFirstNode_nodeStillConnected()
    {
        System.out.println("> Test8 - attempting to delete the first node of a list: deleted node should no longer be connected to the list");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0, 0, 0};
        D_LinkedList instance = new D_LinkedList(a);
        // mark node to be deleted
        D_ListNode toDelete = instance.head;
        // mark node after node to be deleted
        D_ListNode after = toDelete.next;
        System.out.println("attempting to delete first node in list...");
        // select node to be deleted
        int nodeIndex = 1;
        boolean result = instance.delete(nodeIndex);
        // test node deletion
        assertNotSame("node to be deleted still connected to list", toDelete.next, after);
        System.out.println("As expected, the deleted node is no longer connected to the list");
    }
    
    
    /**
     * Test 9 of delete method, of class D_LinkedList.
     */
    
    @Test
    public void test_nonEmptyList_deleteFirstNode_nodeBypassed()
    {
        System.out.println("> Test9 - attempting to delete the first node of a list: deleted node should be bypassed");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0, 0, 0};
        D_LinkedList instance = new D_LinkedList(a);
        // mark node to be deleted
        D_ListNode toDelete = instance.head;
        // mark node after node to be deleted
        D_ListNode after = toDelete.next;
        System.out.println("attempting to delete first node in list...");
        // select node to be deleted
        int nodeIndex = 1;
        boolean result = instance.delete(nodeIndex);
        // test node deletion
        assertEquals("deleted node not bypassed in list", instance.head, after);
        System.out.println("As expected, head now points to the successor of the deleted node in list");
    }

    
    /**
     * Test 10 of delete method, of class D_LinkedList.
     */
    
    @Test
    public void test_nonEmptyList_deleteFirstNode_successorNodePrevPointerIsNull()
    {
        System.out.println("> Test10 - attempting to delete the first node of a list: the successor node to the deleted node should point to null");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0, 0, 0};
        D_LinkedList instance = new D_LinkedList(a);
        // mark node to be deleted
        D_ListNode toDelete = instance.head;
        // mark node after node to be deleted
        D_ListNode after = toDelete.next;
        System.out.println("attempting to delete first node in list...");
        // select node to be deleted
        int nodeIndex = 1;
        boolean result = instance.delete(nodeIndex);
        // test node deletion
        assertNull("prev pointer of successor node to deleted node does not point to null", after.prev);
        System.out.println("As expected, the prev pointer of the successor node to the deleted node now points to null");
    }

    
    /**
     * Test 11 of delete method, of class D_LinkedList.
     */
    
    @Test
    public void test_nonEmptyList_deleteFirstNode()
    {
        System.out.println("> Test11 - attempting to delete the first node in list");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0, 0, 0};
        D_LinkedList instance = new D_LinkedList(a);
        System.out.println("attempting to delete first node in list...");
        boolean expResult = true;
        // select node to be deleted
        int nodeIndex = 1;
        boolean result = instance.delete(nodeIndex);
        // test node deletion
        assertEquals(expResult, result);
        System.out.println("As expected, node was found and deleted");
    }
    
    
    /**
     * Test 12 of delete method, of class D_LinkedList.
     */
    
    @Test
    public void test_nonEmptyList_deleteMiddleNode_firstPartOfListStillConnectedToDeletedNode()
    {   
        System.out.println("> Test12 - attempting to delete a node in middle of list: first part of list should be disconnected from deleted node");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0, 0, 0};
        D_LinkedList instance = new D_LinkedList(a);
        // get to and mark node before node to be deleted
        D_ListNode before = instance.head;
        // select arbitrary node to be deleted
        int nodeIndex = 5;
        for (int i = 1; i < nodeIndex-1; i++)
            before = before.next;
        // mark node to be deleted
        D_ListNode toDelete = before.next;
        System.out.println("attempting to delete a node in middle of list...");
        boolean result = instance.delete(nodeIndex);
        // test node deletion
        assertNotSame("first part of list still connected to node to be deleted", before.next, toDelete);
        System.out.println("As expected, first part of list is now disconnected from the deleted node");
    }
    
    
    /**
     * Test 13 of delete method, of class D_LinkedList.
     */
    
    @Test
    public void test_nonEmptyList_deleteMiddleNode_deletedNodeStillConnectedToFirstPartOfList()
    {   
        System.out.println("> Test13 - attempting to delete a node in middle of list: first part of list should be disconnected from deleted node");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0, 0, 0};
        D_LinkedList instance = new D_LinkedList(a);
        // get to and mark node before node to be deleted
        D_ListNode before = instance.head;
        // select arbitrary node to be deleted
        int nodeIndex = 5;
        for (int i = 1; i < nodeIndex-1; i++)
            before = before.next;
        // mark node to be deleted
        D_ListNode toDelete = before.next;
        System.out.println("attempting to delete a node in middle of list...");
        boolean result = instance.delete(nodeIndex);
        // test node deletion
        assertNotSame("node to be deleted still connected to first part of list", toDelete.prev, before);
        System.out.println("As expected, the deleted node is now disconnected from the first part of list");
    }
    
    
    /**
     * Test 14 of delete method, of class D_LinkedList.
     */
    
    @Test
    public void test_nonEmptyList_deleteMiddleNode_deletedNodeDisconnectedFromRestOfList()
    {   
        System.out.println("> Test14 - attempting to delete a node in middle of list: node to be deleted should be disconnected from second part of list");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0, 0, 0};
        D_LinkedList instance = new D_LinkedList(a);
        // select arbitrary node to be deleted
        int nodeIndex = 5;
        // get to and mark node to be deleted
        D_ListNode toDelete = instance.head;
        for (int i = 1; i < nodeIndex; i++)
            toDelete = toDelete.next;
        // mark node after node to be deleted
        D_ListNode after = toDelete.next;
        System.out.println("attempting to delete a node in middle of list...");
        boolean result = instance.delete(nodeIndex);
        // test node deletion
        assertNotSame("node to be deleted still connected to second half of list", toDelete.next, after);
        System.out.println("As expected, deleted node is no longer connected to second part of list");
    }
    
    
    /**
     * Test 15 of delete method, of class D_LinkedList.
     */
    
    @Test
    public void test_nonEmptyList_deleteMiddleNode_restOfListDisconnectedFromDeletedNode()
    {   
        System.out.println("> Test15 - attempting to delete a node in middle of list: node to be deleted should be disconnected from second part of list");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0, 0, 0};
        D_LinkedList instance = new D_LinkedList(a);
        // select arbitrary node to be deleted
        int nodeIndex = 5;
        // get to and mark node to be deleted
        D_ListNode toDelete = instance.head;
        for (int i = 1; i < nodeIndex; i++)
            toDelete = toDelete.next;
        // mark node after node to be deleted
        D_ListNode after = toDelete.next;
        System.out.println("attempting to delete a node in middle of list...");
        boolean result = instance.delete(nodeIndex);
        // test node deletion
        assertNotSame("second half of list still connected to node to be deleted", after.prev, toDelete);
        System.out.println("As expected, second part of list is no longer connected to deleted node");
    }
    
    
    /**
     * Test 16 of delete method, of class D_LinkedList.
     */
    
    @Test
    public void test_nonEmptyList_deleteMiddleNode_deletedNodeNextPointerIsNull()
    {   
        System.out.println("> Test16 - attempting to delete a node in middle of list: deleted node's next pointer should point to null");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0, 0, 0};
        D_LinkedList instance = new D_LinkedList(a);
        // select arbitrary node to be deleted
        int nodeIndex = 5;
        // get to and mark node to be deleted
        D_ListNode toDelete = instance.head;
        for (int i = 1; i < nodeIndex; i++)
            toDelete = toDelete.next;
        System.out.println("attempting to delete a node in middle of list...");
        boolean result = instance.delete(nodeIndex);
        // test node deletion
        assertNull("node to be deleted's next pointer not connected to null", toDelete.next);
        System.out.println("As expected, deleted node's next pointer is now pointing to null");
    }
    
    
    /**
     * Test 17 of delete method, of class D_LinkedList.
     */
    
    @Test
    public void test_nonEmptyList_deleteMiddleNode_deletedNodePrevPointerIsNull()
    {   
        System.out.println("> Test17 - attempting to delete a node in middle of list: deleted node's prev pointer should point to null");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0, 0, 0};
        D_LinkedList instance = new D_LinkedList(a);
        // select arbitrary node to be deleted
        int nodeIndex = 5;
        // get to and mark node to be deleted
        D_ListNode toDelete = instance.head;
        for (int i = 1; i < nodeIndex; i++)
            toDelete = toDelete.next;
        System.out.println("attempting to delete a node in middle of list...");
        boolean result = instance.delete(nodeIndex);
        // test node deletion
        assertNull("node to be deleted's prev pointer not connected to null", toDelete.prev);
        System.out.println("As expected, deleted node's prev pointer is now pointing to null");
    }
    
    
    /**
     * Test 18 of delete method, of class D_LinkedList.
     */
    
    @Test
    public void test_nonEmptyList_deleteMiddleNode_predecessorNodeConnectedToSuccessorNode()
    {   
        System.out.println("> Test18 - attempting to delete a node in middle of list: predecessor node should be connected to successor node");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0, 0, 0};
        D_LinkedList instance = new D_LinkedList(a);
        // select arbitrary node to be deleted
        int nodeIndex = 5;
        // get to and mark node before node to be deleted
        D_ListNode before = instance.head;
        for (int i = 1; i < nodeIndex-1; i++)
            before = before.next;
        // mark node to be deleted
        D_ListNode toDelete = before.next;
        // mark node after node to be deleted
        D_ListNode after = toDelete.next;
        System.out.println("attempting to delete a node in middle of list...");
        boolean result = instance.delete(nodeIndex);
        // test node deletion
        assertEquals("predecessor node is not connected to successor node", before.next, after);
        System.out.println("As expected, deleted node was bypassed; predecessor node was connected to successor node");
    }
    
    
    /**
     * Test 19 of delete method, of class D_LinkedList.
     */
    
    @Test
    public void test_nonEmptyList_deleteMiddleNode_successorNodeConnectedToPredecessorNode()
    {   
        System.out.println("> Test19 - attempting to delete a node in middle of list: successor node should be connected to predecessor node");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0, 0, 0};
        D_LinkedList instance = new D_LinkedList(a);
        // select arbitrary node to be deleted
        int nodeIndex = 5;
        // get to and mark node before node to be deleted
        D_ListNode before = instance.head;
        for (int i = 1; i < nodeIndex-1; i++)
            before = before.next;
        // mark node to be deleted
        D_ListNode toDelete = before.next;
        // mark node after node to be deleted
        D_ListNode after = toDelete.next;
        System.out.println("attempting to delete a node in middle of list...");
        boolean result = instance.delete(nodeIndex);
        // test node deletion
        assertEquals("successor node is not connected to predecessor node", after.prev, before);
        System.out.println("As expected, successor node is connected to predecessor node");
    }
    
    
    /**
     * Test 20 of delete method, of class D_LinkedList.
     */
    
    @Test
    public void test_nonEmptyList_deleteMiddleNode()
    {   
        System.out.println("> Test20 - attempting to delete a node in middle of list: node should be deleted");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0, 0, 0};
        D_LinkedList instance = new D_LinkedList(a);
        boolean expResult = true;
        System.out.println("attempting to delete a node in middle of list...");
        // select arbitrary node to be deleted
        int nodeIndex = 5;
        boolean result = instance.delete(nodeIndex);
        // test node deletion
        assertEquals(expResult, result);
        System.out.println("As expected, node was found and deleted");
    }
    
    
    /**
     * Test 21 of delete method, of class D_LinkedList.
     */
    
    @Test
    public void test_nonEmptyList_deleteLastNode_predecessorNodeNextPointerIsNull()
    {   
        System.out.println("> Test21 - attempting to delete the last node of a list: predecessor node's next pointer should now point to null");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0, 0, 0};
        D_LinkedList instance = new D_LinkedList(a);
        // select node to be deleted
        int nodeIndex = a.length;
        // get to and mark node before node to be deleted
        D_ListNode before = instance.head;
        for (int i = 1; i < nodeIndex-1; i++)
            before = before.next;
        System.out.println("attempting to delete last node in list...");
        boolean result = instance.delete(nodeIndex);
        // test node deletion
        assertNull("predecessor node's next pointer not connected to null", before.next);
        System.out.println("As expected, predecessor node's next pointer now points to null");
    }
    
    
    /**
     * Test 22 of delete method, of class D_LinkedList.
     */
    
    @Test
    public void test_nonEmptyList_deleteLastNode_deletedNodeNextPointerIsNull()
    {   
        System.out.println("> Test22 - attempting to delete the last node of a list: deleted node's next pointer should point to null");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0, 0, 0};
        D_LinkedList instance = new D_LinkedList(a);
        // select node to be deleted
        int nodeIndex = a.length;
        // get to and mark node to be deleted
        D_ListNode toDelete = instance.head;
        for (int i = 1; i < nodeIndex; i++)
            toDelete = toDelete.next;
        System.out.println("attempting to delete last node in list...");
        boolean result = instance.delete(nodeIndex);
        // test node deletion
        assertNull("deleted node's next pointer is not set to null", toDelete.next);
        System.out.println("As expected, deleted node's next pointer now points to null");
    }
    
    
    /**
     * Test 23 of delete method, of class D_LinkedList.
     */
    
    @Test
    public void test_nonEmptyList_deleteLastNode_deletedNodePrevPointerIsNull()
    {   
        System.out.println("> Test23 - attempting to delete the last node of a list: deleted node's prev pointer should point to null");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0, 0, 0};
        D_LinkedList instance = new D_LinkedList(a);
        // select node to be deleted
        int nodeIndex = a.length;
        // get to and mark node to be deleted
        D_ListNode toDelete = instance.head;
        for (int i = 1; i < nodeIndex; i++)
            toDelete = toDelete.next;
        System.out.println("attempting to delete last node in list...");
        boolean result = instance.delete(nodeIndex);
        // test node deletion
        assertNull("deleted node's prev pointer is not set to null", toDelete.prev);
        System.out.println("As expected, deleted node's prev pointer now points to null");
    }
    
    
    /**
     * Test 24 of delete method, of class D_LinkedList.
     */
    
    @Test
    public void test_nonEmptyList_deleteLastNode()
    {   
        System.out.println("> Test24 - attempting to delete the last node of a list: last node should be deleted");
        System.out.print("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0, 0, 0};
        D_LinkedList instance = new D_LinkedList(a);
        boolean expResult = true;
        System.out.println("attempting to delete last node in list...");
        // select node to be deleted
        int nodeIndex = a.length;
        boolean result = instance.delete(nodeIndex);
        // test node deletion
        assertEquals(expResult, result);
        System.out.println("As expected, last node was found and deleted");
    }
}
