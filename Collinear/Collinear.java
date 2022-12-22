// -------------------------------------------------------------------------
/**
 * This class contains only two static methods that search for points on the
 * same line in three arrays of integers.
 *
 * @author
 * @version 03/10/22 22:22:52
 */
class Collinear {

    public static int Y1 = 1;
    public static int Y2 = 2;
    public static int Y3 = 3;

    // ----------------------------------------------------------
    /**
     * Counts for the number of non-hoizontal lines that go through 3 points in
     * arrays a1, a2, a3. This method is static, thus it can be called as
     * Collinear.countCollinear(a1,a2,a3)
     *
     * @param a1:
     *            An UNSORTED array of integers. Each integer a1[i] represents
     *            the point (a1[i], 1) on the plain.
     * @param a2:
     *            An UNSORTED array of integers. Each integer a2[i] represents
     *            the point (a2[i], 2) on the plain.
     * @param a3:
     *            An UNSORTED array of integers. Each integer a3[i] represents
     *            the point (a3[i], 3) on the plain.
     * @return the number of points which are collinear and do not lie on a
     *         horizontal line.
     *
     */
    static int countCollinear(int[] a1, int[] a2, int[] a3) {

        int x1, x2, x3;
        int count = 0;
        for(int i : a1) {
            for(int j : a2) {
                for(int k : a3) {
                    x1 = i * -1;
                    x2 = j * 2;
                    x3 = k * -1;
                    if(x1 + x2 + x3 == 0)
                        count++;
                }
            }
        }
        return count;

    }

    // ----------------------------------------------------------
    /**
     * Counts for the number of non-hoizontal lines that go through 3 points in
     * arrays a1, a2, a3. This method is static, thus it can be called as
     * Collinear.countCollinearFast(a1,a2,a3)
     *
     * @param a1:
     *            An UNSORTED array of integers. Each integer a1[i] represents
     *            the point (a1[i], 1) on the plain.
     * @param a2:
     *            An UNSORTED array of integers. Each integer a2[i] represents
     *            the point (a2[i], 2) on the plain.
     * @param a3:
     *            An UNSORTED array of integers. Each integer a3[i] represents
     *            the point (a3[i], 3) on the plain.
     * @return the number of points which are collinear and do not lie on a
     *         horizontal line.
     *
     */
    static int countCollinearFast(int[] a1, int[] a2, int[] a3) {
        sort(a3);
        int x1, x2, x3;
        int count = 0;
        for(int i : a1) {
            for(int j : a2) {
                x1 = i * -1;
                x2 = j * 2;
                x3 = x1 + x2;
                if(binarySearch(a3, x3))
                    count++;
            }
        }
        return count;
    }

    // ----------------------------------------------------------
    /**
     * Sorts an array of integers according to InsertionSort. This method is
     * static, thus it can be called as Collinear.sort(a)
     *
     * @param a:
     *            An UNSORTED array of integers.
     * @return after the method returns, the array must be in ascending sorted
     *         order.
     *
     * This method runs in the worst case in Theta(N^2) time.
     */
    static void sort(int[] a) {
        for(int i = 0; i < a.length; i++){
            int j = i-1;
            while(j >= 0 && a[j]>a[j+1]){
                int temp = a[j];
                a[j] = a[j+1];
                a[j+1] = temp;
                j--;
            }
        }
    }

    // ----------------------------------------------------------
    /**
     * Searches for an integer inside an array of integers. This method is
     * static, thus it can be called as Collinear.binarySearch(a,x)
     *
     * @param a:
     *            A array of integers SORTED in ascending order.
     * @param x:
     *            An integer.
     * @return true if 'x' is contained in 'a'; false otherwise.
     *
     * This method runs in the worst case in Theta(lg(N)) time.
     *
     */
    static boolean binarySearch(int[] a, int x) {
        int lo = 0, hi = a.length-1;
        while (lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;
            if (x < a[mid]) hi = mid - 1;
            else if (x > a[mid]) lo = mid + 1;
            else return true;
        }
        return false;
    }

}
