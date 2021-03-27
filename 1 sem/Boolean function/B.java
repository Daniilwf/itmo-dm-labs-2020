import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[] chisla = new int[N];
        String[] str = new String[N];
        for (int i = 0; i < N; i++) {
            String p = reader.readLine();
            for (int j = 0; j < p.length(); j++)
                if (Character.isWhitespace(p.charAt(j))) {
                    chisla[i] = Integer.parseInt(p.substring(0, j));
                    str[i] = p.substring(j + 1);
                    break;
                }
        }
        boolean Null = true;
        boolean One = true;
        boolean SamoDva = true;
        boolean Mnt = true;
        boolean lin = true;
        for (int i = 0; i < N; i++) {
            if (Noll(str[i]))
                Null = false;
            if (Odin(str[i]))
                One = false;
            if (SamDva(str[i]))
                SamoDva = false;
            if (Monoton(str[i]))
                Mnt = false;
            if (Lineyka(str[i]))
                lin = false;
 
        }
        if (Null) {
            System.out.println("NO");
            System.exit(0);
        }
        if (One) {
            System.out.println("NO");
            System.exit(0);
        }
        if (SamoDva) {
            System.out.println("NO");
            System.exit(0);
        }
        if (Mnt) {
            System.out.println("NO");
            System.exit(0);
        }
        if (lin) {
            System.out.println("NO");
            System.exit(0);
        }
        System.out.println("YES");
    }
 
    static boolean Noll(String str) {
        if (str.equals("0")) return false;
        if (str.equals("1")) return true;
        return str.charAt(0) != '0';
    }
 
    static boolean Odin(String str) {
        if (str.equals("0")) return true;
        if (str.equals("1")) return false;
        return str.charAt(str.length() - 1) != '1';
    }
 
    static boolean SamDva(String str) {
        if (str.length() == 1) return true;
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) == str.charAt(str.length() - i - 1))
                return true;
        }
        return false;
    }
 
    static boolean Monoton(String str) {
        int n = str.length();
        int[] mas = new int[n];
        for (int i = 0; i < n; i++) {
            mas[i] = str.charAt(i) - '0';
        }
        return !Chast(mas);
    }
 
    static boolean Chast(int[] a){
        if (a.length == 1) {
            return true;
        }
        int sred = a.length / 2;
        for (int i = 0; i < sred; i++) {
            if (a[i] > a[i + sred]) {
                return false;
            }
        }
        int[] l = new int[sred];
        int[] r = new int[sred];
        for (int i = 0; i < sred; i++) {
            l[i] = a[i];
            r[i] = a[a.length / 2 + i];
        }
        return (Chast(l) && Chast(r));
    }
 
    static int[] Jiga(String str) {
        int n = str.length();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            a[i][0] = str.charAt(i) - '0';
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j][i] == a[j + 1][i])
                    a[j][i + 1] = 0;
                else a[j][i + 1] = 1;
            }
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++)
            res[i] = a[0][i];
        return res;
    }
 
    static boolean Lineyka(String str){
        int[] a = Jiga(str);
        for (int i = 0; i < str.length(); i++) {
            if (a[i] == 1)
                if ((i == 0) || (i == 1) || (i == 2) || (i == 4) || (i == 8) || (i == 16) || (i == 32) || (i == 64))
                    continue;
                else
                    return true;
        }
        return false;
    }
}