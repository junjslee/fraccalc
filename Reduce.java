
/**
 * Write a description of class Reduce here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Reduce
{
    // instance variables - replace the example below with your own
    private int x;
    public static int gcf(int p, int q) {
        while (q != 0) {
            int temp = q;
            q = p % q;
            p = temp;
        }
        return p;
    }
    /**
     * Constructor for objects of class Reduce
     */
}
