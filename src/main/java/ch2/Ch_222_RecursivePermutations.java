package ch2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Stack;

/**
 * @author Vivek
 * @since 02/01/22
 */
public class Ch_222_RecursivePermutations {

    private static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter out = new PrintWriter(System.out);
    private static final Stack<Integer> permutation = new Stack<>();
    private static boolean[] chosen;
    private static int n;

    private static void search() {
        if (permutation.size() == n) {
            printCollectionDirect(permutation);
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (chosen[i]) continue;
            chosen[i] = true;
            permutation.push(i);
            search();
            chosen[i] = false;
            permutation.pop();
        }
    }

    public static void main(String[] args) throws IOException {
        n = readInt();
        chosen = new boolean[n + 1];
        search();
        out.flush();
        out.close();
        in.close();
    }

    private static int readInt() throws IOException {
        return Integer.parseInt(readLine());
    }

    private static String readLine() throws IOException {
        return in.readLine().trim();
    }
    private static <T> void printCollectionDirect(Collection<T> data) {
        data.forEach(t -> System.out.print(t + " "));
        System.out.println();
    }
}