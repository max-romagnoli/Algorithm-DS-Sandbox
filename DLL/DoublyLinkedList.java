import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

// -------------------------------------------------------------------------
/**
 *  This class contains the methods of Doubly Linked List.
 *
 *  @author  
 *  @version 11/10/22
 */


/**
 * Class DoublyLinkedList: implements a *generic* Doubly Linked List.
 * @param <T> This is a type parameter. T is used as a class name in the
 * definition of this class.
 *
 * When creating a new DoublyLinkedList, T should be instantiated with an
 * actual class name that extends the class Comparable.
 * Such classes include String and Integer.
 *
 * For example to create a new DoublyLinkedList class containing String data: 
 *    DoublyLinkedList<String> myStringList = new DoublyLinkedList<String>();
 *
 * The class offers a toString() method which returns a comma-separated sting of
 * all elements in the data structure.
 * 
 * This is a bare minimum class you would need to completely implement.
 * You can add additional methods to support your code. Each method will need
 * to be tested by your jUnit tests -- for simplicity in jUnit testing
 * introduce only public methods.
 */
class DoublyLinkedList<T extends Comparable<T>>
{


    /**
     * private class DLLNode: implements a *generic* Doubly Linked List node.
     */
    private class DLLNode
    {
        public final T data; // this field should never be updated. It gets its
                             // value once from the constructor DLLNode.
        public DLLNode next;
        public DLLNode prev;
    
        /**
         * Constructor
         * @param theData : data of type T, to be stored in the node
         * @param prevNode : the previous Node in the Doubly Linked List
         * @param nextNode : the next Node in the Doubly Linked List
         * @return DLLNode
         */
        public DLLNode(T theData, DLLNode prevNode, DLLNode nextNode) 
        {
          data = theData;
          prev = prevNode;
          next = nextNode;
        }
    }

    // Fields head and tail point to the first and last nodes of the list.
    private DLLNode head, tail;
    private int DLLSize = -1;


    /**
     * Constructor of an empty DLL
     * @return DoublyLinkedList
     */
    public DoublyLinkedList() 
    {
      head = null;
      tail = null;
    }

    /**
     * Tests if the doubly linked list is empty
     * @return true if list is empty, and false otherwise
     *
     * Worst-case asymptotic running time cost: Theta(1)
     *
     * Justification:
     *  The body of the method is composed of one line only.
     *  The line involves a single conditional expression and a return statement both running in constant time Theta(1).
     *
     *  Therefore, this method will run in Theta(1) time in the worst case.
     *
     */
    public boolean isEmpty()
    {
        return (head == null);
    }

    /**
     * Inserts an element in the doubly linked list at the first position
     * @param data : The new data of class T that needs to be added at the head of the list
     * @return none
     *
     * Worst-case asymptotic running time cost: Theta(1)
     *
     * Justification:
     *  The body of the method is composed of a single if-then-else branching.
     *  * The if-branch involves
     *  *   1. The call to the method isEmpty() - constant time operation
     *  *   2. The creation and assignment of a new DLLNode object - constant
     *  *   3. A single assignment - constant
     *  *   => The if-branch runs in Theta(1) time
     *  * The else-branch involves
     *  *   1. The creation and assignment of a new DLLNode object - constant time
     *  *   2/3. Two object assignments - constant
     *  *   => The else-branch also runs in Theta(1) time
     *
     *  The method overall runs in constant Theta(1) + Theta(1) = Theta(1) time in the worst case.
     */
    public void insertFirst(T data)
    {
        if(this.isEmpty())
        {
            head = new DLLNode(data, null, null);
            tail = head;
        }
        else
        {
            DLLNode tmp = new DLLNode(data,null, head);
            head.prev = tmp;
            head = tmp;
        }
    }

    /**
     * Inserts an element in the doubly linked list at the last position
     * @param data : The new data of class T that needs to be added at the tail of the list
     * @return none
     *
     * Worst-case asymptotic running time cost: Theta(1)
     *
     * Justification:
     *  The body of the method is composed of a single if-then-else branching.
     *  * The if-branch involves
     *  *   1. The call to the method isEmpty() - constant time operation
     *  *   2. The creation and assignment of a new DLLNode object - constant
     *  *   3. A single assignment - constant
     *  *   => The if-branch runs in Theta(1) time
     *  * The else-branch involves
     *  *   1. The creation and assignment of a new DLLNode object - constant time
     *  *   2/3. Two object assignments - constant
     *  *   => The else-branch also runs in Theta(1) time
     *
     *  The method overall runs in constant Theta(1) + Theta(1) = Theta(1) time in the worst case.
     */
    public void insertLast(T data)
    {
        if(this.isEmpty())
        {
            head = new DLLNode(data, null, null);
            tail = head;
        }
        else
        {
            DLLNode tmp = new DLLNode(data, tail, null);
            tail.next = tmp;
            tail = tmp;
        }
    }

    /**
     * Inserts an element in the doubly linked list
     * @param pos : The integer location at which the new data should be
     *      inserted in the list. We assume that the first position in the list
     *      is 0 (zero). If pos is less than 0 then add to the head of the list.
     *      If pos is greater or equal to the size of the list then add the
     *      element at the end of the list.
     * @param data : The new data of class T that needs to be added to the list
     * @return none
     *
     * Worst-case asymptotic running time cost: Theta(N)
     *
     * Justification:
     *  The body of the method is divided in four parts: 1) the if-branch, 2) the else-if-branch,
     *  3) the else-branch, 4) the line after the if-then-else branches.
     *
     *  The if-branch lines involve
     *      1. A conditional expression - constant time operation
     *      2. The call to the method insertFirst, which runs in Theta(1) time.
     *      => The if-branch runs in Theta(1) time
     *
     *  The else-if-branch involves
     *      1. A conditional expression - constant time
     *      2. The call to the method getNode, which runs in Theta(N) time
     *      3. The creation and assignment of a new DLLNode object - constant
     *      4/5. Two object assignments - constant
     *      => The else-if-branch runs in Theta(1) + Theta(N) + Theta(1) + Theta(1) = Theta(N) time
     *
     *  The else-branch lines involve
     *      1. A conditional expression - constant time operation
     *      2. The call to the method insertLast, which runs in Theta(1) time.
     *      => The else-branch runs in Theta(1) time
     *
     *  The line after the if-then-else branches involves a decrement that runs in Theta(1) time
     *
     *  The method overall runs in constant Theta(1) + Theta(N) + Theta(1) + Theta(1) = Theta(N) time in the worst case.
     */
    public void insertBefore( int pos, T data ) 
    {
        if (pos <= 0)
        {
            insertFirst(data);
        }
        else if (pos <= DLLSize)
        {
            DLLNode iter = getNode(pos);
            DLLNode tmp = new DLLNode(data, iter.prev, iter);
            iter.prev = tmp;
            tmp.prev.next = tmp;
        }
        else
        {
            insertLast(data);
        }
        DLLSize++;
    }

    /**
     * Returns the data stored at a particular position
     * @param pos : the position
     * @return the data at pos, if pos is within the bounds of the list, and null otherwise.
     *
     * Worst-case asymptotic running time cost: Theta(N)
     *
     * Justification:
     *  The method is composed of:
     *      1. The call to the method getNode which runs in Theta(N) and assigns its output to a new object
     *         reference in constant time.
     *         => This line runs in Theta(N) + Theta(1) = Theta(N) times
     *      2. An if-branch which
     *          - runs a conditional statement - constant time
     *          - returns the method - constant
     *      3. An else-branch composed of a return statement running in constant time
     *
     *  The method overall runs in Theta(N) + Theta(1) + Theta(1) = Theta(N) times in the worst case.
     *
     */
    public T get(int pos)
    {
        DLLNode nodeAtPos = getNode(pos);
        if(nodeAtPos != null)
            return nodeAtPos.data;
        else return null;
    }

    /**
     * Returns the node at a particular position
     * @param pos : the position
     * @return the node at pos, if pos is within the bounds of the list, and null otherwise.
     *
     * Worst-case asymptotic running time cost: Theta(N)
     *
     * Justification:
     *  The method is composed of three branches of an if-then-else statement.
     *  i. The if-branch covers the positions in the first half of the list
     *  ii. The else-if-branch covers the positions in the second half
     *  iii. The else-branch covers out-of-bound exceptions
     *
     *  The first two branches can be each divided into three sub-parts: 1) the lines before the for loop,
     *  2) the lines after the for loop, 3) the for loop itself.
     *
     *  IF-BRANCH
     *  The lines before the for loop involve
     *      1. A conditional expression - constant time
     *      2. An assignment operation - constant
     *      => Theta(1) + Theta(1) = Theta(1)
     *
     *  The line after the loop involves
     *      1. A return statement - constant time operation
     *
     *  The for loop itself in the worst case will iterate over half the elements of the list, starting from the head to
     *  the middle of the list. Thus, it will perform Theta(N/2) operations.
     *  Each iteration involves
     *      1. Checking the condition - constant time
     *      2. An assignment - constant
     *      3. An increment - constant
     *      => Each iteration of the for loop will costs Theta(1) time
     *  Thus, the lines involved in the for loop will run in Theta(1)*Theta(N/2) = Theta(N/2)
     *  Ignoring the constant term 1/2, the running time will be Theta(N)
     *
     *  Therefore, the if-branch operations will cost Theta(1) + Theta(1) + Theta(N) = Theta(N)
     *
     *  ELSE-IF-BRANCH
     *  Just like the if-branch, this branch iterates in Theta(N) time in the worst case. Although, instead of iterating from the head
     *  to the middle, it iterates from the tail to the middle.
     *
     *  ELSE-BRANCH
     *  This branch involves one return statement which runs in constant time Theta(1).
     *
     *  All in all, the asymptotic running time is Theta(N) + Theta(N) + Theta(1) = Theta(N) in the worst case.
     */
    public DLLNode getNode(int pos)
    {
        if(pos >= 0 && pos < DLLSize/2)
        {
            DLLNode iter = head;
            for (int count = 0; pos > count; count++)
            {
                iter = iter.next;
            }
            return iter;
        }
        else if(pos >= DLLSize/2 && pos <= DLLSize)
        {
            DLLNode iter = tail;
            for (int count = DLLSize; pos < count; count--)
            {
                iter = iter.prev;
            }
            return iter;
        }
        else return null;
    }

    /**
     * Deletes the element of the list at position pos.
     * First element in the list has position 0. If pos points outside the
     * elements of the list then no modification happens to the list.
     * @param pos : the position to delete in the list.
     * @return true : on successful deletion, false : list has not been modified. 
     *
     * Worst-case asymptotic running time cost: Theta(N)
     *
     * Justification:
     *  The method involves the following operations:
     *      1. The call to the method getNode which runs in Theta(N) times and assigns its output to a new object
     *         reference in constant time.
     *         => This line runs in Theta(N) + Theta(1) time in the worst case
     *      2. An if-then-else branching system:
     *          - The if-branch contains other if-then-else statements:
     *              * if-branch involves a conditional, two object assignments and a decrement - all three running in constant time
     *              * else-branch involves a method call to deleteNode - running in Theta(1) time
     *              * A return statement - constant time
     *          - The else-branch returns the function in Theta(1) time
     *         => The if-then-else branching runs in Theta(1) constant time
     *  This method overall runs in Theta(N) + Theta(1) = Theta(N) times in the worst case
     *
     */
    public boolean deleteAt(int pos) 
    {
        DLLNode nodeAtPos = getNode(pos);
        if(nodeAtPos!=null)
        {
            if(DLLSize == 0)
            {
                head = null;
                tail = null;
                DLLSize--;
            }
            else
            {
                deleteNode(nodeAtPos, pos);
            }
            return true;
        }
        else return false;
    }

    /**
     * Deletes a given element of the list at a given position pos.
     * The method does not loop through the list as it simply provides the functionality of deletion.
     * @param node : the node to delete
     * @param pos : the position
     * @return none.
     *
     * Worst-case asymptotic running time cost: Theta(1)
     *
     * Justification:
     *  The method is composed of:
     *      1. An if-branch which
     *          - runs a conditional statement - constant time
     *          - assigns two variables - constant
     *          => Theta(1) + Theta(1) + Theta(1) = Theta(1)
     *      2. An else-if-branch which
     *          - runs a conditional statement - constant time
     *          - assigns two variables - constant
     *          => Theta(1) + Theta(1) + Theta(1) = Theta(1)
     *      3. An else-if-branch which
     *          - assigns two variables - constant
     *          => Theta(1) + Theta(1) = Theta(1)
     *      4. A variable decrement with constant running time.
     *
     *  The method overall runs in Theta(1) + Theta(1) + Theta(1) + Theta(1) = Theta(1) times in the worst case.
     *
     */
    public void deleteNode(DLLNode node, int pos) {
        if(pos == 0)
        {
            head = node.next;
            head.prev = null;
        }
        else if(pos == DLLSize)
        {
            tail = node.prev;
            tail.next = null;
        }
        else
        {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        DLLSize--;
    }

    /**
     * Reverses the list.
     * If the list contains "A", "B", "C", "D" before the method is called
     * Then it should contain "D", "C", "B", "A" after it returns.
     *
     * Worst-case asymptotic running time cost: Theta(N)
     *
     * Justification:
     *  The method involves a single for-loop that iterates over all the elements of the list, starting from the head all the way to
     *  the tail of the list. Thus, it will perform Theta(N) operations.
     *  Each iteration involves
     *      1. Checking the condition - constant time
     *      2. An if-branch composed of
     *          - Conditional statement - constant time
     *          - A variable declaration and assignment - constant
     *          - Two object assignments - constant
     *          => Thus running in Theta(1) + Theta(1) + Theta(1) = Theta(1) time
     *      2. An else-branch composed of
     *          - A variable declaration and assignment - constant
     *          - Four object assignments - each one runs in constant time
     *          => Thus running in Theta(1) + Theta(1) = Theta(1) time
     *      3. The loop update, involving a constant time assignment
     *      => Each iteration of the for loop will cost Theta(1) time
     *  Thus, the for loop and, therefore, the method itself will run in Theta(1)*Theta(N) = Theta(N)
     */
    public void reverse()
    {
        for (DLLNode iter = head; iter != null; iter = iter.prev)
        {
            if (iter.next != null)
            {
                DLLNode temp = iter.prev;
                iter.prev = iter.next;
                iter.next = temp;
            }
            else
            {
                DLLNode temp = tail;
                tail = head;
                head = temp;
                head.next = head.prev;
                head.prev = null;
            }
        }
    }

    /**
     * Removes all duplicate elements from the list.
     * The method should remove the _least_number_ of elements to make all elements uniqueue.
     * If the list contains "A", "B", "C", "B", "D", "A" before the method is called
     * Then it should contain "A", "B", "C", "D" after it returns.
     * The relative order of elements in the resulting list should be the same as the starting list.
     *
     * Worst-case asymptotic running time cost: Theta(N^2)
     *
     * Justification:
     *  This method is composed of one nested for loop as well as constant time operations before them.
     *  The analysis will be divided into four parts: 1) line(s) before the inner loop, 2) the inner loop itself,
     *  3) line(s) before the outer loop, 4) the outer loop itself
     *
     *  BEFORE THE INNER LOOP
     *  - An assignment running in constant time - Theta(1)
     *
     *  INNER LOOP
     *  The loop iterates over all the elements of the list, performing Theta(N) operations.
     *  Each iteration includes:
     *      1. Checking the condition - constant time
     *      2. An if statement which
     *          - runs two conditional operations in constant time
     *          - calls the method deleteNode, which runs in constant time - Theta(1)
     *          - decrements - constant time
     *          => Theta(1) + Theta(1) + Theta(1) = Theta(1)
     *      3. Two loop updates (an assignment and decrement) - both constant time
     *      => Each iteration of the loop will cost Theta(1) + Theta(1) + Theta(1) + Theta(1) = Theta(1) times
     *  Thus, the inner for loop runs in Theta(N)*Theta(1) = Theta(N) times in the worst case.
     *
     *  BEFORE THE OUTER LOOP
     *  - An assignment running in constant time - Theta(1)
     *
     *  OUTER LOOP
     *  The loop iterates over all the elements of the list, performing Theta(N) operations.
     *  Each iteration includes:
     *      1. Checking the condition - constant time
     *      2. An assignment - constant
     *      3. Running the inner for loop - in Theta(N) times
     *      4. Two loop updates (an assignment and increment) - constant time
     *      => Each iteration of the loop will cost Theta(1) + Theta(1) + Theta(N) + Theta(1) = Theta(N) times
     *  Thus, the outer for loop runs in Theta(N)*Theta(N) = Theta(N^2) times in the worst case.
     *
     *  Finally, we can add the cost of the lines before the outer loop the total running time of the outer loop itself.
     *  Outer loop = Theta(N^2)
     *  Lines before the outer loop = Theta(1)
     *  The overall running time of the method will be of Theta(N^2) + Theta(1) = Theta(N^2) times.
     */
    public void makeUnique()
    {
        int samplePos = 0;
        for (DLLNode i = head; i != null; i = i.next, samplePos++)
        {
            int pos = 0;
            for (DLLNode j = head; j != null; j = j.next, pos++)
            {
                if(i.data == j.data && samplePos != pos)
                {
                    deleteNode(j, pos);
                    pos--;
                }
            }
        }
    }


    /*----------------------- STACK API 
     * If only the push and pop methods are called the data structure should behave like a stack.
     */

    /**
     * This method adds an element to the data structure.
     * How exactly this will be represented in the Doubly Linked List is up to the programmer.
     * @param item : the item to push on the stack
     *
     * Worst-case asymptotic running time cost: Theta(1)
     *
     * Justification:
     *  The method is composed of:
     *      1. The call to the method insertLast which runs in Theta(1) time
     *      2. A variable increment - constant time
     *
     *  The method overall runs in Theta(1) + Theta(1) = Theta(1) times in the worst case.
     *
     */
    public void push(T item) 
    {
        insertLast(item);
        DLLSize++;
    }

    /**
     * This method returns and removes the element that was most recently added by the push method.
     * @return the last item inserted with a push; or null when the list is empty.
     *
     * Worst-case asymptotic running time cost: Theta(1)
     *
     * Justification:
     *  The method is composed of:
     *      1. The assignment of an object reference - constant time
     *      2. An if-branch which
     *          - calls the method deleteAt with a parameter which will have the method always run in constant time, as it directly
     *            access the tail of the list - Theta(1)
     *          - a return statement - constant
     *          => The if-branch runs in Theta(1) + Theta(1) = Theta(1) time
     *      3. An else-branch with a constant time return statement
     *
     *  The method overall runs in Theta(1) + Theta(1) + Theta(1) = Theta(1) times
     */
    public T pop() 
    {
        DLLNode formerTail = tail;
        if(deleteAt(DLLSize))
            return formerTail.data;
        else return null;
    }

    /*----------------------- QUEUE API
     * If only the enqueue and dequeue methods are called the data structure should behave like a FIFO queue.
     */
 
    /**
     * This method adds an element to the data structure.
     * How exactly this will be represented in the Doubly Linked List is up to the programmer.
     * @param item : the item to be enqueued to the stack
     *
     * Worst-case asymptotic running time cost: Theta(1)
     *
     * Justification:
     *  The method is composed of:
     *      1. The call to the method insertFirst which runs in Theta(1) time
     *      2. A variable increment - constant time
     *
     *  The method overall runs in Theta(1) + Theta(1) = Theta(1) times in the worst case.
     */
    public void enqueue(T item) 
    {
        insertFirst(item);
        DLLSize++;
    }

     /**
     * This method returns and removes the element that was least recently added by the enqueue method.
     * @return the earliest item inserted with an equeue; or null when the list is empty.
     *
     * Worst-case asymptotic running time cost: Theta(1)
     *
     * Justification:
      *  The method is composed of:
      *      1. The assignment of an object reference - constant time
      *      2. An if-branch which
      *          - calls the method deleteAt with a parameter which will have the method always run in constant time, as it directly
      *            access the tail of the list - Theta(1)
      *          - a return statement - constant
      *          => The if-branch runs in Theta(1) + Theta(1) = Theta(1) time
      *      3. An else-branch with a constant time return statement
      *
      *  The method overall runs in Theta(1) + Theta(1) + Theta(1) = Theta(1) times
     */
    public T dequeue() 
    {
        DLLNode formerTail = tail;
        if (deleteAt(DLLSize))
            return formerTail.data;
        else return null;
    }
 

    /**
     * @return a string with the elements of the list as a comma-separated
     * list, from beginning to end
     *
     * Worst-case asymptotic running time cost:   Theta(n)
     *
     * Justification:
     *  The code consists of the lines before the for-loop, the for-loop itself and the lines after the for-loop.
     *
     *  The lines before the for loop involve 
     *  - the creation of a StringBuilder object which does not depend on the length of the list. Therefore it takes Theta(1) time.
     *  - the allocation and assignment of two variables which are constant time operations.
     *  Thus the code before the for-loop will take Theta(1) time to run.
     *
     *  The lines after the for-loop involve a single return instruction and thus take Theta(1) time.
     *
     *  The for-loop itself will iterate over all elements of the DLL. Thus it will perform Theta(N) iterations.
     *  Each iteration will involve:
     *   * The if-conditional will run:
     *       - the if-then-else conditions and branching, which are constant time operations. Thus these cost Theta(1) time.
     *       - The then-branch of the conditional calls StringBuilder's append() method, which (from the Java documentation) we know it runs in Theta(1) time.
     *       - the else-branch of the conditional involves a single assignment, thus runs in Theta(1) time.
     *     Therefore the if-then-else conditions will cost Theta(1) in the worst case.
     *   * The final call to StringBuilder's append will cost again Theta(1)
     *   * the nested call to toString() will cost time proportional to the length of the strings (but not the length of the list). 
     *     Assuming strings are relatively small compared to the size of the list, this cost will be Theta(1).
     *  Therefore each iteration of the loop will cost Theta(1).
     *  Thus the lines involving the for-loop will run in Theta(N)*Theta(1) = Theta(N).
     *
     * Therefore this method will run in Theta(1) + Theta(1) + Theta(N) = Theta(N) time in the worst case.
     *
     */
    public String toString() 
    {
      StringBuilder s = new StringBuilder();
      boolean isFirst = true; 

      // iterate over the list, starting from the head
      for (DLLNode iter = head; iter != null; iter = iter.next)
      {
        if (!isFirst)
        {
          s.append(",");
        } else {
          isFirst = false;
        }
        s.append(iter.data.toString());
      }

      return s.toString();
    }


}



