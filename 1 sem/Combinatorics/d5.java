import java.io.*;
import java.util.Scanner;
 
public class nazarbaev {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("telemetry.in")));
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream("telemetry.out")));
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(reader.readLine());
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int length = (int) Math.pow(k, n);
        String[] a = new String[length];
        for (int i = 0; i < length; i++)
            a[i] = "";
        int temp = 1;
        for (int i = 0; i < n; i++){
            int cur = 0;
            int j = 0;
            while (j < a.length) {
                for (int bukva = 0; bukva < k; bukva++) {
                    for (int ow = 0; ow < temp; ow++) {
                        if (j == a.length)
                            break;
                        a[j] += cur;
                        j++;
                    }
                    if (cur != k - 1)
                    cur++;
                }
                for (int bukva = 0; bukva < k; bukva++) {
                    for (int ow = 0; ow < temp; ow++) {
                        if (j == a.length)
                            break;
                        a[j] += cur;
                        j++;
                    }
                    if (cur != 0)
                    cur--;
                }
            }
            temp *= k;
        }
        for (int j = 0; j < length; j++)
            writer.println(a[j]);
        reader.close();
        writer.close();
    }
}