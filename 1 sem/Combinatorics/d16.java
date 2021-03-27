import java.io.*;
import java.util.Scanner;
 
public class d16 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("choose2num.in")));
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream("choose2num.out")));
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(reader.readLine());
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] a = new int[k+1];
        Scanner scan = new Scanner(reader.readLine());
        for (int i = 1; i <= k; i++)
            a[i] = scan.nextInt();
        long sum = 0;
        for (int i = 1; i <= k; i++)
            for (int j = a[i - 1] + 1; j <= a[i] - 1; j++)
                sum += C(n-j, k - i);
        writer.print(sum);
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