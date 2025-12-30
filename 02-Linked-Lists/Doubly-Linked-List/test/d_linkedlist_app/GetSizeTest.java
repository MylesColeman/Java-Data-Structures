/** GetSizeTest.java
 * program to unit-test the getSize method of class LinkedList
 */
package d_linkedlist_app;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;


public class GetSizeTest
{
   @BeforeClass
    public static void setUpClass()
    {
        System.out.println("\ntesting the getSize() method of class LinkedList\n");
    }
    
    
    /**
     * Test 1 of getSize method, of class D_LinkedList.
     */
    //@Ignore
    @Test
    public void test_emptyList_zeroSize()
    {
        System.out.println("> Test1 - getSize in empty list: should return zero");
        System.out.print("creating an empty list...");
        D_LinkedList instance = new D_LinkedList();
        int expResult = 0;
        System.out.println("computing list size...");
        int result = instance.getSize();
        // test computation of list size
        assertEquals(expResult, result);
        System.out.println("As expected, size of zero returned");
    }
    
    
    /**
     * Test 2 of getSize method, of class D_LinkedList.
     */
    //@Ignore
    @Test
    public void test_nonEmptyList_correctSizeReturned()
    {
        System.out.println("> Test2 - getSize in non-empty list: should return correct size");
        System.out.println("creating a non-empty list with an arbitrary number of nodes...");
        int[] a = {0, 0, 0, 0, 0};
        D_LinkedList instance = new D_LinkedList(a);
        int expResult = a.length;
        // compute size of list
        int result = instance.getSize();
        // test computation of list size
        assertEquals(expResult, result);
        System.out.println("As expected, nodes successfully counted");
    }
}
