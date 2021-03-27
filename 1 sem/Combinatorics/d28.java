import java.io.*;
import java.util.Scanner;
 
public class d28 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("nextmultiperm.in")));
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream("nextmultiperm.out")));
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(reader.readLine());
        int n = scanner.nextInt();
        int[] a = new int[n];
        Scanner scan = new Scanner(reader.readLine());
        for (int i = 0; i < n; i++)
            a[i] = scan.nextInt();
        int[] b = new int[n];
        for (int i = n - 1; i > 0; i--){
            if (a[i - 1] < a[i]){
                int minIndex = i;
                while ((minIndex < n - 1) && (a[minIndex + 1] > a[i - 1])) {
                    minIndex++;
                }
                int temp = a[i - 1];
                a[i - 1] = a[minIndex];
                a[minIndex] = temp;
                for (int j = 0; j < i; j++)
                    b[j] = a[j];
                int count = 0;
                for (int j = n - 1; j >= i; j--)
                    b[i + count++] = a[j];
                break;
            }
        }
        for (int i = 0; i < n; i++)
            //System.out.print(b[i] + " ");
            writer.print(b[i] + " ");
        reader.close();
        writer.close();
 
    }
}