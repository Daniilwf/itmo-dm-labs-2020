import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
 
public class E {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        List<String> strs = new ArrayList<>();
        for (int i = 0; i < 26; i++)
            strs.add(String.valueOf((char) (i + 97)));
        String mainstr = "";
        for (int i = 0; i < s.length(); i++) {
            String temp = String.valueOf(s.charAt(i));
            if (strs.contains(mainstr + temp))
                mainstr += temp;
            else {
                System.out.print(strs.indexOf(mainstr) + " ");
                strs.add(mainstr + temp);
                mainstr = temp;
            }
        }
        System.out.print(strs.indexOf(mainstr) + " ");
    }
}