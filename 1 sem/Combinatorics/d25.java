import java.io.*;
import java.util.Scanner;
 
public class d25 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("nextchoose.in")));
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream("nextchoose.out")));
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(reader.readLine());
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] a = new int[k + 1];
        Scanner scan = new Scanner(reader.readLine());
        for (int i = 0; i < k; i++)
            a[i] = scan.nextInt();
        a[k] = n + 1;
        boolean check = false;
        for (int i = k; i > 0; i--) {
            if (a[i] - a[i - 1] >= 2) {
                a[i - 1] += 1;
                check = true;
                for (int j = i; j < k; j++)
                    a[j] = a[j - 1] + 1;
                break;
            }
        }
        if (check) {
            for (int i = 0; i < k; i++) {
                //System.out.print(a[i] + " ");
                writer.print(a[i] + " ");
            }
        } else{
            //System.out.print(-1);
            writer.print(-1);
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