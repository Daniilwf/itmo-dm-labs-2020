import java.io.*;
 
public class ramzan {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("nextpartition.in")));
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream("nextpartition.out")));
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String p = reader.readLine();
        int rovno = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '=') {
                rovno = i;
                break;
            }
        }
        int n = Integer.parseInt(p.substring(0, rovno));
        int[] a = new int[n];
        int probel = rovno + 1;
        int count = 0;
        for (int i = rovno + 1; i < p.length(); i++)
            if (p.charAt(i) == '+') {
                a[count++] = Integer.parseInt(p.substring(probel, i));
                probel = i + 1;
            }
        a[count++] = Integer.parseInt(p.substring(probel));
        if (count == 1){
            writer.print("No solution");
            reader.close();
            writer.close();
            System.exit(0);
        }
        a[count - 2]++;
        a[count - 1]--;
        if (a[count - 2] > a[count - 1]){
            a[count - 2] = a[count - 2] + a[count - 1];
            count--;
        } else{
            while (a[count - 2] * 2 <= a[count - 1]){
                a[count] = a[count - 1] - a[count - 2];
                count++;
                a[count - 2] = a[count - 3];
            }
        }
        writer.print(n + "=");
        for (int i = 0; i < count - 1; i++)
            writer.print(a[i] + "+");
        writer.print(a[count-1]);
        reader.close();
        writer.close();
    }
}