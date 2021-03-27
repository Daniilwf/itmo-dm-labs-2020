import java.io.*;
import java.util.Scanner;
 
public class d17 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("num2brackets.in")));
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream("num2brackets.out")));
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(reader.readLine());
        int n = scanner.nextInt();
        long k = scanner.nextLong()+1;
        long[][] dp = new long[2*n + 1][n+1];
        for (int i = 0; i <= n; i++)
            dp[0][i] = 0;
        dp[0][0] = 1;
        for (int i = 1; i < 2*n; i++)
            for (int j = 0; j <= n; j++) {
                if (j > 0) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
                if (j + 1 <= n) {
                    dp[i][j] += dp[i - 1][j + 1];
                }
            }
        int glubina = 0;
        StringBuilder res = new StringBuilder();
        for (int i=n*2-1; i>=0; i--)
            if (glubina+1 <= n && dp[i][glubina+1] >=k ) {
                res.append('(');
                glubina++;
            }
            else {
                res.append(')');
                if (glubina+1 <= n)
                    k -= dp[i][glubina+1];
                glubina--;
            }
        //System.out.print(res);
        writer.print(res);
        reader.close();
        writer.close();
    }
}