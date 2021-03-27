import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
 
public class E {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String p = reader.readLine();
        Double d2 = Double.valueOf(p);
        int N= (int) Math.pow(2.0, d2);
        int[][] a = new int[N][N];
        String[] line = new String[N];
        for (int i=0; i<N; i++){
            String h = reader.readLine();
            int stepa = 0;
            for (int j = 0; j<h.length(); j++)
                if (Character.isWhitespace(h.charAt(j))) {
                    stepa = j;
                    break;
                }
            line[i]=h.substring(0,stepa);
            a[i][0]=Integer.parseInt(h.substring(stepa+1));
        }
        for (int i=0; i<N; i++){
            System.out.println(line[i] + " " + a[0][i]);
            for (int j = 0; j<N-i-1; j++){
                if (a[j][i] == a[j+1][i])
                    a[j][i+1]=0;
                else a[j][i+1]=1;
            }
        }
    }
}