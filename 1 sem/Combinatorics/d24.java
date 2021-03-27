import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
 
public class d24 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("nextperm.in")));
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream("nextperm.out")));
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[] a = new int[N];
        Scanner scanner = new Scanner(reader.readLine());
        for (int i = 0; i < N; i++)
            a[i] = scanner.nextInt();
        int[] a1 = Arrays.copyOf(a, a.length);
        int[] a2 = Arrays.copyOf(a, a.length);
        int[] nazvanie1 = new int[N];
        int[] nazvanie2 = new int[N];
        boolean check1 = false;
        boolean check2 = false;
        for (int i = N-1; i > 0; i--){
            int indexMax = i;
            int indexMin = i;
            if (a[i - 1] > a[i]){
                if (!check1) {
                    for (int j = i; j < N; j++) {
                        if ((a[j] > a[indexMax]) && (a[j] < a[i - 1]))
                            indexMax = j;
 
                    }
                    int temp = a1[i - 1];
                    a1[i - 1] = a1[indexMax];
                    a1[indexMax] = temp;
                    for (int j = 0; j < i; j++)
                        nazvanie1[j] = a1[j];
                    int count = 0;
                    for (int j = N - 1; j >= i; j--)
                        nazvanie1[i + count++] = a1[j];
                    check1 = true;
                }
                }
            else {
                if (!check2) {
                    for (int j = i; j < N; j++) {
                        if ((a[j] < a[indexMin]) && (a[j] > a[i - 1]))
                            indexMin = j;
                    }
                    int temp = a2[i - 1];
                    a2[i - 1] = a2[indexMin];
                    a2[indexMin] = temp;
                    for (int j = 0; j < i; j++)
                        nazvanie2[j] = a2[j];
                    int count = 0;
                    for (int j = N - 1; j >= i; j--)
                        nazvanie2[i + count++] = a2[j];
                    check2 = true;
                }
            }
            if (check1 && check2)
                break;
            }
        for (int i = 0; i < N; i++)
            writer.print(nazvanie1[i] + " ");
        writer.println();
        for (int i = 0; i < N; i++)
            writer.print(nazvanie2[i] + " ");
        reader.close();
        writer.close();
    }
}