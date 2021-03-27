import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static java.lang.System.out;
 
public class d23 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("nextvector.in")));
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream("nextvector.out")));
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        int[] min = new int[line.length()+1];
        int[] plus = new int[line.length()+1];
        for (int i = 1; i <= line.length(); i++){
            min[i] = line.charAt(i-1) - '0';
            plus[i] = line.charAt(i-1) - '0';
        }
        int indm = 0;
        int indp = 0;
        for (int i = line.length(); i>=0; i--){
            if (min[i] == 1){
                if (indm == 0)
                    indm = i;
            }
            else {
                if (indp == 0)
                    indp = i;
            }
            if ((indp != 0) && (indm != 0))
                break;
        }
        plus[indp] = 1;
        for (int i = indp+1; i < plus.length; i++)
            plus[i] = 0;
        min[indm] = 0;
        for (int i = indm+1; i < min.length; i++)
            min[i] = 1;
        if (indm == 0)
            writer.print("-");
        else
        for (int j = 1; j < min.length; j++) {
            writer.print(min[j]);
        }
        writer.println();
        if (plus[0] == 1)
            writer.print("-");
        else
        for (int i = 1; i < min.length; i++)
            writer.print(plus[i]);
        reader.close();
        writer.close();
    }

    public static List<Integer> nextPartition(List<Integer> b) {
        b.set((b.size() - 1), b.get(b.size() - 1) - 1);
        b.set((b.size() - 2), b.get(b.size() - 2) + 1);
        if (b.get(b.size() - 2) > b.get(b.size() - 1)) {
            b.set((b.size() - 2), b.get(b.size() - 2) + b.get(b.size() - 1));
            b.remove(b.size() - 1);
        }
        else{
            while (b.get(b.size() - 2) * 2 <= b.get(b.size() - 1)) {
                b.add(b.get(b.size() - 1) - b.get(b.size() - 2));
                b.set((b.size() - 2), b.get(b.size() - 3));
            }
        }
        return b;
    }
}