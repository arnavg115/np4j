import np4j.*;

/**
 * main
 */
public class main {

    public static void main(String[] args) {
        Array i = Array.rep(2, 2, 6);
        Array b = Array.rep(2, 2, 1);

        System.out.println(Array.sum(i,b));
    }
}