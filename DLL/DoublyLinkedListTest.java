package csu22011_a2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for Doubly Linked List
 *
 *  @author  Max Romagnoli
 *  @version 13/10/16 18:15
 */
@RunWith(JUnit4.class)
public class DoublyLinkedListTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
      new DoublyLinkedList<Integer>();
    }

    @Test
    public void testEmpty() {
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<>();
        assertTrue("Testing empty DLL", testDLL.isEmpty());
        testDLL.insertFirst(1);
        assertFalse("Testing non-empty DLL", testDLL.isEmpty());
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check if the insertBefore works
     */

    @Test
    public void testFirstAndLast() {
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<>();
        testDLL.insertBefore(0,45);
        testDLL.insertBefore(0, 35);
        testDLL.insertBefore(0, 12);
        testDLL.insertBefore(3, 10000);
        assertEquals("Checking list at position 0", "12,35,45,10000",testDLL.toString());
    }

    @Test
    public void testMiddle() {
        DoublyLinkedList<String> testDLL = new DoublyLinkedList<>();
        testDLL.insertBefore(0, "Fourth");
        testDLL.insertBefore(0, "Second");
        testDLL.insertBefore(0, "First");
        testDLL.insertBefore(2, "Third");
        testDLL.insertBefore(10, "Seventh");
        testDLL.insertBefore(1000, "Ninth");
        testDLL.insertBefore(4, "Fifth");
        testDLL.insertBefore(5, "Sixth");
        testDLL.insertBefore(7, "Eighth");
        assertEquals("Checking list at position 2", "First,Second,Third,Fourth,Fifth,Sixth,Seventh,Eighth,Ninth",
                testDLL.toString());
    }

    @Test
    public void testGet() {
        DoublyLinkedList<Integer> testDLL = makeIntegerDLL();
        assertEquals("Checking getting element at 0","0",
                String.valueOf(testDLL.get(0)));
        assertEquals("Checking getting element at 4","4",
                String.valueOf(testDLL.get(4)));
        assertEquals("Checking getting element at 8","8",
                String.valueOf(testDLL.get(8)));
        assertNull("Checking getting element at 1000", testDLL.get(-80));
    }

    @Test
    public void testDelete() {
        DoublyLinkedList<Integer> testDLL = makeIntegerDLL();
        testDLL.deleteAt(5);
        assertEquals("Checking deletion at position 5", "0,1,2,3,4,6,7,8",testDLL.toString());
        testDLL.deleteAt(0);
        assertEquals("Checking deletion at head of the list", "1,2,3,4,6,7,8", testDLL.toString());
        testDLL.deleteAt(6);
        assertEquals("Checking deletion at tail of the list", "1,2,3,4,6,7", testDLL.toString());
        testDLL.deleteAt(1);
        assertEquals("Checking deletion at position 1", "1,3,4,6,7", testDLL.toString());
        assertFalse("Checking out of bound deletion", testDLL.deleteAt(10000));
        testDLL = new DoublyLinkedList<>();
        testDLL.insertBefore(0,1);
        assertTrue("Checking deletion of one element list", testDLL
                .deleteAt(0));
    }

    @Test
    public void testInsertBefore() {
        // test non-empty list
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);

        testDLL.insertBefore(0,4);
        assertEquals( "Checking insertBefore to a list containing 3 elements at position 0", "4,1,2,3",
                testDLL.toString() );
        testDLL.insertBefore(1,5);
        assertEquals( "Checking insertBefore to a list containing 4 elements at position 1", "4,5,1,2,3", testDLL.toString() );
        testDLL.insertBefore(2,6);       
        assertEquals( "Checking insertBefore to a list containing 5 elements at position 2", "4,5,6,1,2,3", testDLL.toString() );
        testDLL.insertBefore(-1,7);        
        assertEquals( "Checking insertBefore to a list containing 6 elements at position -1 - expected the element at the head of the list", "7,4,5,6,1,2,3", testDLL.toString() );
        testDLL.insertBefore(7,8);        
        assertEquals( "Checking insertBefore to a list containing 7 elemenets at position 8 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8", testDLL.toString() );
        testDLL.insertBefore(700,9);        
        assertEquals( "Checking insertBefore to a list containing 8 elements at position 700 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8,9", testDLL.toString() );

        // test empty list
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);        
        assertEquals( "Checking insertBefore to an empty list at position 0 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(10,1);        
        assertEquals( "Checking insertBefore to an empty list at position 10 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(-10,1);        
        assertEquals( "Checking insertBefore to an empty list at position -10 - expected the element at the head of the list", "1", testDLL.toString() );
    }

    @Test
    public void testReverse() {
        DoublyLinkedList<Integer> testDLL = makeIntegerDLL();
        testDLL.reverse();
        assertEquals("Reversing the list", "8,7,6,5,4,3,2,1,0",testDLL.toString());
    }

    @Test
    public void testUnique() {
        DoublyLinkedList<String> testDLL = makeStringDLL();
        testDLL.makeUnique();
        assertEquals("Making the list unique", "A,B,C,D,E",testDLL.toString());
        testDLL = new DoublyLinkedList<>();
        testDLL.insertBefore(0,"test");
        testDLL.insertBefore(0,"test");
        testDLL.makeUnique();
        assertEquals("Checking two element list", "test",testDLL.toString());
        testDLL.deleteAt(1);
        testDLL.deleteAt(0);
        assertTrue("List should be empty", testDLL.isEmpty());
    }

    @Test
    public void testStack() {
        DoublyLinkedList<Integer> testDLL =  new DoublyLinkedList<>();
        testDLL.push(100);
        assertEquals("Pushing one element in zero element list", "100", testDLL.toString());
        testDLL.push(200);
        assertEquals("Popping should return deleted element","200",String.valueOf(testDLL.pop()));
        testDLL.pop();
        assertTrue("Popping element should return empty list", testDLL.isEmpty());
        assertNull("Method should return null when attempting pop on empty list",testDLL.pop());
    }

    @Test
    public void testQueue() {
        DoublyLinkedList<Integer> testDLL =  new DoublyLinkedList<>();
        testDLL.enqueue(100);
        assertEquals("Enqueuing one element in zero element list", "100", testDLL.toString());
        testDLL.enqueue(200);
        assertEquals("Dequeuing should return deleted element","100",String.valueOf(testDLL.dequeue()));
        testDLL.dequeue();
        assertTrue("Dequeuing element should return empty list", testDLL.isEmpty());
        assertNull("Method should return null when attempting dequeue on empty list",testDLL.dequeue());
    }


    // Helper methods

    public DoublyLinkedList<Integer> makeIntegerDLL() {
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<>();
        testDLL.insertBefore(0, 3);
        testDLL.insertBefore(0, 1);
        testDLL.insertBefore(0, 0);
        testDLL.insertBefore(2, 2);
        testDLL.insertBefore(10, 6);
        testDLL.insertBefore(1000, 8);
        testDLL.insertBefore(4, 4);
        testDLL.insertBefore(5, 5);
        testDLL.insertBefore(7, 7);
        return testDLL;
    }

    public DoublyLinkedList<String> makeStringDLL() {
        DoublyLinkedList<String> testDLL = new DoublyLinkedList<>();
        testDLL.insertBefore(0, "A");
        testDLL.insertBefore(0, "B");
        testDLL.insertBefore(0, "A");
        testDLL.insertBefore(2, "C");
        testDLL.insertBefore(10, "D");
        testDLL.insertBefore(1000, "B");
        testDLL.insertBefore(4, "A");
        testDLL.insertBefore(5, "B");
        testDLL.insertBefore(7, "E");       // A,B,C,A,A,B,D,E,B
        return testDLL;
    }
}

