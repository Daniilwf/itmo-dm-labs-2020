import java.io.*;
 
public class d18 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("brackets2num.in")));
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream("brackets2num.out")));
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String p = reader.readLine();
        int n = p.length()/2;
        long[][] dp = new long[2*n + 1][n+1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++)
            dp[0][i] = 0;
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
        long res = 0;
        for (int i = 0; i < p.length(); i++){
            if (p.charAt(i) == '(') {
                glubina++;
            } else{
                if (glubina + 1 <= n)
                    res += dp[2*n -i -1][glubina + 1];
                glubina--;
            }
        }
        //System.out.print(res);
        writer.print(res);
        reader.close();
        writer.close();
    }
}