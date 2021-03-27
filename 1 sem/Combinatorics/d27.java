import java.io.*;
 
public class d27 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("nextbrackets.in")));
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream("nextbrackets.out")));
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String p = reader.readLine();
        int r = 0;
        int l = 0;
        for (int i = p.length() - 1; i >= 0; i--) {
            if (p.charAt(i) == '(') {
                l++;
                if (r > l)
                    break;
            }
            else
                r++;
        }
        p = p.substring(0, p.length() - l - r);
        StringBuilder str = new StringBuilder();
        str.append(p);
        if (p.equals("")) {
            //System.out.print('-');
            writer.print('-');
        }
        else {
            str.append(')');
            for (int i = 0; i < l; i++)
                str.append('(');
            for (int i = 0; i < r - 1; i++)
                str.append(')');
            //System.out.print(str);
            writer.print(str);
        }
        reader.close();
        writer.close();
    }
}