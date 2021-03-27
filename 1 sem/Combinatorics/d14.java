import java.io.*;
import java.util.Scanner;
 
public class d14 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("perm2num.in")));
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream("perm2num.out")));
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[] a = new int[N + 1];
        Scanner scanner = new Scanner(reader.readLine());
        for (int i = 1; i <= N; i++)
            a[i] = scanner.nextInt();
        long[] fact = new long[19];
        fact[0] = 1;
        for (int i = 1; i < 19; i++)
            fact[i] = fact[i - 1] * i;
        long res = 0;
        for (int i = 1; i <= N; i++) {
            int temp = 0;
            for (int j = i + 1; j <= N; j++){
                if (a[j] < a[i])
                    temp++;
            }
            res += temp * fact[N - i];
        }
        writer.print(res);
        reader.close();
        writer.close();
    }
}