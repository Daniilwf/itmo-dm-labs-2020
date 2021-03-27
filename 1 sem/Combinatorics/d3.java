import java.io.*;
 
public class d3 {
    public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("antigray.in")));
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream("antigray.out")));
            String p = reader.readLine();
            int N = Integer.parseInt(p);
            int tempa = (int) Math.pow(3, N);
            int tempb = (int) Math.pow(3, N-1);
            String[] a = new String[tempa];
            String[] b = new String[tempb];
            for (int i = 0; i < tempb; i++) {
                int temp = i;
                StringBuilder vojd = new StringBuilder();
                for (int j = 0; j < N; j++) {
                    vojd.append(temp % 3);
                    temp = temp / 3;
                }
                b[i] = String.valueOf(vojd.reverse());
            }
            int ind = 0;
            for (int i = 0; i < tempa; i++) {
                a[i] = b[ind];
                writer.println(a[i]);
                for (int akr = 0; akr < 2; akr++) {
                    i++;
                    boolean firts = true;
                    for (int j = 0; j < N; j++) {
                        int temp = Integer.parseInt(b[ind].substring(j,j+1));
                        temp++;
                        if (temp == 3)
                            temp=0;
                        if (firts) {
                            a[i] = Integer.toString(temp);
                            firts = false;
                        }
                        else{
                            a[i] += Integer.toString(temp);
                        }
                    }
                    writer.println(a[i]);
                    b[ind] = a[i];
                }
                ind++;
            }
            reader.close();
            writer.close();
    }
}