
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Optional;

//-------------------------------------------------------------------------
/**
 *  Test class for Doubly Linked List
 *
 *  @version 3.1 09/11/15 11:32:15
 *  @author  Massimiliano Romagnoli
 */

@RunWith(JUnit4.class)
public class BSTTest
{
  
  //TODO write more tests here.

  
  /** <p>Test {@link BST#prettyPrintKeys()}.</p> */


  @Test
  public void testGet() {
      BST<Integer, Integer> bst = new BST<Integer, Integer>();
      bst.put(7, 7);
      bst.put(8, 8);
      assertFalse("Checking if 10 is present: ", bst.contains(10));
      assertNull("Retrieving out of bound: ", bst.get(10));
      bst.put(2, 2);
      assertTrue("Checking if 2 is present: ", bst.contains(2));
      assertEquals("Should return 2", "2", bst.get(2).toString());
      bst.put(2, null);
      assertEquals("Element should be deleted, tree updated: ", "(()7(()8()))", bst.printKeysInOrder());
      bst.put(8, 10);
      assertEquals("Putting existing key, should return updated value: ", "10", bst.get(8).toString());

  }

 @Test
 public void testPrettyPrint() {
     BST<Integer, Integer> bst = new BST<Integer, Integer>();
    // assertEquals("Checking pretty printing of empty tree",
     //        "-null\n", bst.prettyPrintKeys());
      
                                //  -7
                                //   |-3
                                //   | |-1
                                //   | | |-null
     bst.put(7, 7);     //   | |  -2
     bst.put(8, 8);     //   | |   |-null
     bst.put(3, 3);     //   | |    -null
     bst.put(1, 1);     //   |  -6
     bst.put(2, 2);     //   |   |-4
     bst.put(6, 6);     //   |   | |-null
     bst.put(4, 4);     //   |   |  -5
     bst.put(5, 5);     //   |   |   |-null
                                //   |   |    -null
                                //   |    -null
                                //    -8
                                //     |-null
                                //      -null
     System.out.println(bst.prettyPrintKeys());
     String result = 
      "-7\n" +
      " |-3\n" + 
      " | |-1\n" +
      " | | |-null\n" + 
      " | |  -2\n" +
      " | |   |-null\n" +
      " | |    -null\n" +
      " |  -6\n" +
      " |   |-4\n" +
      " |   | |-null\n" +
      " |   |  -5\n" +
      " |   |   |-null\n" +
      " |   |    -null\n" +
      " |    -null\n" +
      "  -8\n" +
      "   |-null\n" +
      "    -null\n";
     assertEquals("Checking pretty printing of non-empty tree", result, bst.prettyPrintKeys());
     }

  
     /** <p>Test {@link BST#delete(Comparable)}.</p> */
     @Test
     public void testDelete() {
         BST<Integer, Integer> bst = new BST<Integer, Integer>();
         bst.delete(1);
         assertEquals("Deleting from empty tree", "()", bst.printKeysInOrder());
         
         bst.put(7, 7);   //        _7_
         bst.put(8, 8);   //      /     \
         bst.put(3, 3);   //    _3_      8
         bst.put(1, 1);   //  /     \
         bst.put(2, 2);   // 1       6
         bst.put(6, 6);   //  \     /
         bst.put(4, 4);   //   2   4
         bst.put(5, 5);   //        \
                                  //         5
         
         assertEquals("Checking order of constructed tree",
                 "(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());
         
         bst.delete(9);
         assertEquals("Deleting non-existent key",
                 "(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());
 
         bst.delete(8);
         assertEquals("Deleting leaf", "(((()1(()2()))3((()4(()5()))6()))7())", bst.printKeysInOrder());
 
         bst.delete(6);
         assertEquals("Deleting node with single child",
                 "(((()1(()2()))3(()4(()5())))7())", bst.printKeysInOrder());

         bst.delete(4);
         assertEquals("Delete node with single child (right)", "(((()1(()2()))3(()5()))7())", bst.printKeysInOrder());
 
         bst.delete(3);
         assertEquals("Deleting node with two children",
                 "(((()1())2(()5()))7())", bst.printKeysInOrder());
     }

     @Test
     public void testHeight() {
         BST<Integer, Integer> bst = new BST<Integer, Integer>();
         assertEquals("Testing empty tree: ", -1, bst.height());
         bst.put(7, 7);   //        _7_
         assertEquals("Testing one node tree: ", 0, bst.height());
         bst.put(9, 9);   //      /     \
         bst.put(3, 3);   //    _3_      9
         bst.put(1, 1);   //    /       /  \
         assertEquals("Height should be two: ", 2, bst.height());
         bst.put(10, 10); //   1       8   10
         bst.put(8, 8);   //                 \
         bst.put(11, 11); //                 11
         bst.put(-1,-1);  //
         bst.put(-2,-2);
         assertEquals("Height should be four: ", 4, bst.height());
     }

     @Test
     public void testPrintInOrder() {
         BST<Integer, Integer> bst = new BST<Integer, Integer>();
         assertEquals("Printing empty tree: ", "()", bst.printKeysInOrder());
         bst.put(5,5);
         assertEquals("Printing one node tree: ", "(()5())", bst.printKeysInOrder());
         bst.put(2, 2);
         assertEquals("Printing 2 nodes: ", "((()2())5())", bst.printKeysInOrder());
         bst.put(7, 7);
         assertEquals("Printing 3 nodes: ", "((()2())5(()7()))", bst.printKeysInOrder());
     }

     @Test
     public void testMedian() {
         BST<Integer, Integer> bst = new BST<Integer, Integer>();
         assertNull("Testing empty tree: ", bst.median());
         bst.put(5, 5);
         bst.put(2, 2);
         bst.put(8, 8);
         assertEquals("Median should be 5: ", "5", bst.median().toString());
         bst.put(1, 1);
         assertEquals("Median should be 2: ", "2", bst.median().toString());
         bst.put(6, 6);
         bst.put(7, 7);
         bst.put(10, 10);
         assertEquals("Median should be 6: ", "6", bst.median().toString());
     }
     
}

