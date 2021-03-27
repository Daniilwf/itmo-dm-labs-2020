import static java.lang.System.out;
 
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
 
public class d8 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("choose.in")));
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream("choose.out")));
        String p = reader.readLine();
        int vojd = 0;
        for (int i = 0; i < p.length(); i++){
            if (Character.isWhitespace(p.charAt(i))) {
                vojd = i;
                break;
            }
        }
        int n = Integer.parseInt(p.substring(0, vojd));
        int k = Integer.parseInt(p.substring(vojd+1));
        List<Integer> combinations = generateCombinations(n, k);
        for (int i = 0; i < combinations.size(); i++) {
            if ((i+1) % k == 0)
                writer.print(combinations.get(i) + "\n");
            else
                writer.print(combinations.get(i) + " ");
        }
        writer.close();
        reader.close();
 
    }

    private static void combinate(List<Integer> combinations, int[] data, int start, int end, int index) {
        if (index == data.length) {
            int[] combination = data.clone();
            for (int i = 0; i < combination.length; i++)
                combinations.add(combination[i]);
        } else if (start <= end) {
            data[index] = start;
            combinate(combinations, data, start + 1, end, index + 1);
            combinate(combinations, data, start + 1, end, index);
        }
    }

    public static List<Integer> generateCombinations(int n, int k) {
        List<Integer> combinations = new ArrayList<>();
        combinate(combinations, new int[k], 1, n, 0);
        return combinations;
    }
}