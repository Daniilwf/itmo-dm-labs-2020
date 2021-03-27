import java.io.*;
import java.util.Scanner;
 
public class d15 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("num2choose.in")));
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream("num2choose.out")));
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(reader.readLine());
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        long m = scanner.nextLong() + 1;
        int[] res = new int[k + 1];
        long s = 0;
        int t = 1;
        while (t<=k){
            int kruta = res[t-1] + 1;
            while ((kruta < n - k + t) && (s + C(n - kruta, k - t) < m)){
                s = s + C(n - kruta, k - t);
                kruta++;
            }
            res[t] = kruta;
            t++;
        }
        for (int i = 1; i <= k; i++){
            writer.print(res[i] + " ");
        }
        reader.close();
        writer.close();
    }
 
    static long C(int n,int k)
    {
        if ((n==k) || (k==0)) {
            return 1;
        }
        if (k==1) {
            return n;
        }
        return C(n-1,k) + C(n-1,k-1);
    }
}