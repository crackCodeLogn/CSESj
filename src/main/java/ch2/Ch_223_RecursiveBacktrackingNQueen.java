package ch2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * @author Vivek
 * @since 02/01/22
 */
public class Ch_223_RecursiveBacktrackingNQueen {

    private static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter out = new PrintWriter(System.out);

    private static int n, count = 0;
    private static boolean[] columns, diag1, diag2;

    private static void search(int y) {
        if (y == n) {
            count++;
            return;
        }
        for (int x = 0; x < n; x++) {
            if (columns[x] || diag1[x + y] || diag2[x - y + n - 1]) continue;
            columns[x] = true;
            diag1[x + y] = true;
            diag2[x - y + n - 1] = true;
            search(y + 1);
            columns[x] = false;
            diag1[x + y] = false;
            diag2[x - y + n - 1] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        n = readInt();
        columns = new boolean[n];
        diag1 = new boolean[n * 2];
        diag2 = new boolean[n * 2];
        search(0);
        System.out.println(count);
    }

    private static int readInt() throws IOException {
        return Integer.parseInt(readLine());
    }

    private static String readLine() throws IOException {
        return in.readLine().trim();
    }
}