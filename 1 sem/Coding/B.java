import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 
public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        /*List<Character> a = new ArrayList<>();
        if (s.length() > 0)
            a.add(s.charAt(0));
        for (int i = 1; i < s.length(); i++){
            if (a.lastIndexOf(s.charAt(i)) == -1)
                a.add(s.charAt(i));
        }
        System.out.print(barroze(s.length(), a.size(),s));*/
        String[] mas = new String[s.length()];
        mas[0] = s;
        for (int i = 1; i < s.length(); i++){
            mas[i] = mas[i-1].substring(1) + mas[i-1].charAt(0);
        }
        Arrays.sort(mas);
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            str.append(mas[i].substring(s.length() - 1));
        }
        System.out.print(str);
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
        int j = t[1];
        for (int i = 0; i < N; i++) {
            answer += s.charAt(j);
            j = t[j];
        }
        return answer;
    }
}