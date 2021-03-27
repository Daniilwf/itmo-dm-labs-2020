import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 
public class d7 {
    public static void main(String[] args) throws Exception {
        String line;
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("permutations.in")));
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream("permutations.out")));
        line = reader.readLine();
        int n = Integer.parseInt(line);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = i + 1;
        if (n == 1)
            writer.println("1");
        else if (n == 2)
            writer.println("1 2" + "\n" + "2 1");
        else {
            List l = mas(arr);
            for (int i = 0; i < l.size(); i++) {
                StringBuilder temp = (StringBuilder) l.get(i);
                for (int j = 0; j < temp.length(); j++)
                    writer.print(temp.charAt(j) + " ");
                if (l.size() - i > 1) {
                    writer.print("\n");
                }
            }
            writer.println();
        }
        reader.close();
        writer.close();
    }
    public static List<StringBuilder> mas(int[] arr) {
        if (arr.length == 2) {
            StringBuilder sb1 = new StringBuilder();
            sb1.append(arr[0]).append(arr[1]);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(arr[1]).append(arr[0]);
            return Arrays.asList(sb1, sb2);
        }
        else {
            List<StringBuilder> l = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                int[] result = new int[arr.length - 1];
                for (int k = 0, j = 0; k < arr.length; k++) {
                    if (k != i) {
                        result[j++] = arr[k];
                    }
                }
                for (StringBuilder sb : mas(result)) {
                    l.add(sb.insert(0, arr[i]));
                }
            }
            return l;
        }
    }
}