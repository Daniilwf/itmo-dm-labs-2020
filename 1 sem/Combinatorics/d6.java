import java.io.*;
import java.util.ArrayList;
import java.util.List;
 
public class d6 {
    public static void main(String[] args) throws IOException {
        List<String> str = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("vectors.in")));
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream("vectors.out")));
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String p = reader.readLine();
        int N = Integer.parseInt(p);
        int x = (int) Math.pow(2, N);
        int count = 0;
        for (int i = 0; i < x; i++) {
            int temp = i;
            boolean ahmat = true;
            int cnt1 = 0;
            StringBuilder vojd = new StringBuilder();
            for (int j = 0; j < N; j++) {
                if (temp % 2 == 1)
                    cnt1++;
                else
                    cnt1 = 0;
                if (cnt1 == 2) {
                    ahmat = false;
                    break;
                }
                vojd.append(temp % 2);
                temp = temp / 2;
            }
            if (ahmat) {
                count++;
                str.add(String.valueOf(vojd.reverse()));
            }
        }
        writer.println(count);
        for (int i = 0; i < count; i++)
            writer.println(str.get(i));
        reader.close();
        writer.close();
    }
}