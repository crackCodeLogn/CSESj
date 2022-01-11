package ch2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/**
 * @author Vivek
 * @since 02/01/22
 */
public class Ch_221_RecursiveSubset {
    private static final Stack<Integer> subset = new Stack<>();
    private static int n;

    private static void search(int k) {
        if (k == n + 1) {
            for (int val : subset) System.out.printf("%d ", val);
            System.out.println();
            return;
        }
        subset.push(k);
        search(k + 1);
        subset.pop();
        search(k + 1);
    }

    private static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        n = readInt();
        search(1);
    }

    private static int readInt() throws IOException {
        return Integer.parseInt(readLine());
    }

    private static String readLine() throws IOException {
        return in.readLine().trim();
    }
}