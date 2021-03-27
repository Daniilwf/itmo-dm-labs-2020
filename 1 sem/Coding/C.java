import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 
public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        List<Character> a = new ArrayList<>();
        if (s.length() > 0)
            a.add(s.charAt(0));
        for (int i = 1; i < s.length(); i++){
            if (a.lastIndexOf(s.charAt(i)) == -1)
                a.add(s.charAt(i));
        }
        System.out.print(barroze(s.length(), a.size(),s));
        /*String[] mas = new String[s.length()];
        for (int i = 0; i < s.length(); i++)
            mas[i] = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++)
                mas[j] = s.charAt(j) + mas[j];
            Arrays.sort(mas);
        }
        System.out.println(mas[0]);*/
    }
 
 
 
    public static String barroze(int N, int M, String s){
        int[] count = new int[N];
        String answer = "";
        for (int i = 0; i < M; i++)
            count[i] = 0;
        for (int i = 0; i < N; i++)
            count[s.charAt(i) - 97]++;
        int sum = 0;
        for (int i = 0; i < M; i++){
            sum += count[i];
            count[i] = sum - count[i];
        }
        int[] t = new int[N];
        for (int i = 0; i < N; i++) {
            t[count[s.charAt(i) - 97]] = i;
            count[s.charAt(i) - 97]++;
        }
        int j = t[0];
        for (int i = 0; i < N; i++) {
            answer += s.charAt(j);
            j = t[j];
        }
        return answer;
    }
}