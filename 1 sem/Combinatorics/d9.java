import java.io.*;
import java.util.Scanner;
 
public class d9 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("brackets.in")));
        String p = reader.readLine();
        int N = Integer.parseInt(p);
        order(N);
        reader.close();
    }

    public static  void order (int n) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream("brackets.out")));
        String s = "";
        for (int j = 1; j <= n; j++)
        s = s + '(';
        for (int j = 1; j <= n; j++)
        s = s + ')';
        writer.println(s);
        while (true) {
            s = next(s);
            if (s.equals("No Solution"))
                break;
            else
                writer.println(s);
        }
        writer.close();
    }
 
    public static java.lang.String next(String s) {
        int counter_close = 0;
        int counter_open = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                counter_open++;
                if (counter_close > counter_open)
                    break;
            }
            else
                counter_close++;
        }
        // начиная с символа с индексом "length(s) - counter_open - counter_close" удаляем все символы (индексация с 0)
        s = s.substring(0, s.length() - counter_open - counter_close);
        if (s.equals(""))
        return "No Solution";
            else {
            s = s + ')';
            for (int j = 1; j <= counter_open; j++)
            s = s + '(';
            for (int j = 1; j <= counter_close - 1; j++)
            s = s + ')';
            return s;
        }
    }
 
    static String deleteCharacters(String str, int from, int to) {
        return str.substring(0,from)+str.substring(to);
    }
}