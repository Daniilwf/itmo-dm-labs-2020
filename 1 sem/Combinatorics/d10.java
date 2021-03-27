import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 
public class d10 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("partition.in")));
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream("partition.out")));
        String line = reader.readLine();
        int n = Integer.parseInt(line);
        List<Integer> vojd = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            vojd.add(1);
            writer.print("1+");
        }
        vojd.add(1);
        writer.print("1\n");
        while (vojd.get(0) != n) {
            vojd = nextPartition(vojd);
            for (int i = 0; i < vojd.size()-1; i++)
                writer.print(vojd.get(i) + "+");
            writer.print(vojd.get(vojd.size()-1) + "\n");
        }
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