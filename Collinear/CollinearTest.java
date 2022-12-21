package csu22011_a1;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import java.io.*;


import java.util.ArrayList;
import java.util.Arrays;

//-------------------------------------------------------------------------
/**
 *  Test class for Collinear.java
 *
 *  @author
 *  @version 03/10/22 22:33:19
 */
@RunWith(JUnit4.class)
public class CollinearTest
{

    public static void main(String[] args) throws IOException {

        System.out.println("TESTING FOR 1000");
        test1k();

        System.out.println();

        System.out.println("TESTING FOR 2000");
        test2k();

        System.out.println();

        System.out.println("TESTING FOR 4000");
        test4k();

        System.out.println();

        System.out.println("TESTING FOR 5000");
        test5k();

    }

    public static void test1k() throws IOException {
        int[] r1k_1 = readFile("r01000-1.txt");
        int[] r1k_2 = readFile("r01000-2.txt");
        int[] r1k_3 = readFile("r01000-3.txt");
        Stopwatch stopwatch = new Stopwatch();
        System.out.println("Brute force result: " + Collinear.countCollinear(r1k_1, r1k_2, r1k_3));
        double time1 = stopwatch.elapsedTime();
        StdOut.println("Elapsed time: " + time1);
        System.out.println("Fast result: " + Collinear.countCollinearFast(r1k_1, r1k_2, r1k_3));
        double time2 = stopwatch.elapsedTime() - time1;
        StdOut.println("Elapsed time: " + time2);
    }

    public static void test2k() throws IOException {
        int[] r2k_1 = readFile("r02000-1.txt");
        int[] r2k_2 = readFile("r02000-2.txt");
        int[] r2k_3 = readFile("r02000-3.txt");
        Stopwatch stopwatch = new Stopwatch();
        System.out.println("Brute force result: " + Collinear.countCollinear(r2k_1, r2k_2, r2k_3));
        double time1 = stopwatch.elapsedTime();
        StdOut.println("Elapsed time: " + time1);
        System.out.println("Fast result: " + Collinear.countCollinearFast(r2k_1, r2k_2, r2k_3));
        double time2 = stopwatch.elapsedTime() - time1;
        StdOut.println("Elapsed time: " + time2);
    }

    public static void test4k() throws IOException {
        int[] r4k_1 = readFile("r04000-1.txt");
        int[] r4k_2 = readFile("r04000-2.txt");
        int[] r4k_3 = readFile("r04000-3.txt");
        Stopwatch stopwatch = new Stopwatch();
        System.out.println("Brute force result: " + Collinear.countCollinear(r4k_1, r4k_2, r4k_3));
        double time1 = stopwatch.elapsedTime();
        StdOut.println("Elapsed time: " + time1);
        System.out.println("Fast result: " + Collinear.countCollinearFast(r4k_1, r4k_2, r4k_3));
        double time2 = stopwatch.elapsedTime() - time1;
        StdOut.println("Elapsed time: " + time2);;
    }

    public static void test5k() throws IOException {
        int[] r5k_1 = readFile("r05000-1.txt");
        int[] r5k_2 = readFile("r05000-2.txt");
        int[] r5k_3 = readFile("r05000-3.txt");
        Stopwatch stopwatch = new Stopwatch();
        System.out.println("Brute force result: " + Collinear.countCollinear(r5k_1, r5k_2, r5k_3));
        double time1 = stopwatch.elapsedTime();
        StdOut.println("Elapsed time: " + time1);
        System.out.println("Fast result: " + Collinear.countCollinearFast(r5k_1, r5k_2, r5k_3));
        double time2 = stopwatch.elapsedTime() - time1;
        StdOut.println("Elapsed time: " + time2);;
    }

    public static int[] readFile(String fileName) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        String[] str = bufferedReader.readLine().split(" ");
        int[] arr = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        return arr;
    }


    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
        new Collinear();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check that the two methods work for empty arrays
     */

    @Test
    public void testEmpty()
    {
        int expectedResult = 0;

        assertEquals("countCollinear with 3 empty arrays should return zero",     expectedResult, Collinear.countCollinear(new int[0], new int[0], new int[0]));
        assertEquals("countCollinearFast with 3 empty arrays should return zero", expectedResult,
                Collinear.countCollinearFast(new int[0], new int[0], new int[0]));
    }

    // TODO: write more tests here to cover 100% of the instructions and the branches of Collinear.java


    @Test
    public void testBinarySearchBranches() {
        int expectedResult = 2;
        int[] a1 = {2, 6};
        int[] a2 = {4};
        int[] a3 = {2, 6};

        assertEquals("countCollinear should return two", expectedResult,
                Collinear.countCollinear(a1, a2, a3));
        assertEquals("countCollinearFast should return two", expectedResult,
                Collinear.countCollinearFast(a1, a2, a3));
    }

    @Test
    public void testUnsuccessfulSearch() {
        int expectedResult = 0;
        int[] a1 = {0, 1};
        int[] a2 = {-5, 100, 101};
        int[] a3 = {2, 1};

        assertEquals("countCollinearFast for unsuccessful search should return zero", expectedResult,
                Collinear.countCollinearFast(a1, a2, a3));
    }

}
