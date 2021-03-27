import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
 
public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Scanner sc = new Scanner(reader.readLine());
        long[] a = new long[n];
        for (int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        System.out.print(younghuffman(a));
    }
    public static long younghuffman(long[] a){
        long[] b = new long[a.length];
        int i = 0;
        int j = 0;
        long ans = 0;
        for (int k = 0; k < a.length; k++)
            b[k] = 1000000000;
        for (int k = 0; k < a.length - 1; k++){
            if (i + 1 < a.length) {
                if ((a[i] + a[i + 1] <= a[i] + b[j]) && (a[i] + a[i + 1] <= b[j] + b[j + 1])) {
                    b[k] = a[i] + a[i + 1];
                    ans += b[k];
                    i += 2;
                    continue;
                }
                if ((a[i] + b[j] <= a[i] + a[i + 1]) && (a[i] + b[j] <= b[j] + b[j + 1])) {
                    b[k] = a[i] + b[j];
                    ans += b[k];
                    i++;
                    j++;
                    continue;
                }
                if ((b[j] + b[j + 1] <= a[i] + a[i + 1]) && (b[j] + b[j + 1] <= a[i] + b[j])) {
                    b[k] = b[j] + b[j + 1];
                    ans += b[k];
                    j += 2;
                }
            } else{
                if (i < a.length) {
                    if (a[i] + b[j] <= b[j] + b[j + 1]) {
                        b[k] = a[i] + b[j];
                        ans += b[k];
                        i++;
                        j++;
                    } else {
                        b[k] = b[j] + b[j + 1];
                        ans += b[k];
                        j += 2;
                    }
                } else {
                    b[k] = b[j] + b[j + 1];
                    ans += b[k];
                    j += 2;
                }
            }
        }
        return ans;
    }
}