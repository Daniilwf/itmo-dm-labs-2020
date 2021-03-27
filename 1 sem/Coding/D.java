import java.io.*;
 
public class D {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        int[] alphabet = new int[26];
        for (int i = 0; i < 26; i++)
            alphabet[i] = i + 1;
        for (int i = 0; i < s.length(); i++) {
            int curInd = (int) s.charAt(i) - 97;
            int temp = alphabet[curInd];
            System.out.print(temp + " ");
            for (int j = 0; j < 26; j++)
                if (alphabet[j] < temp)
                    alphabet[j]++;
            alphabet[curInd] = 1;
        }
    }
}