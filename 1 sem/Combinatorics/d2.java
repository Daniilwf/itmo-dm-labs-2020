import java.io.*;
 
public class d2{
    public static void main(String[] args) throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("gray.in")));
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream("gray.out")));
            String p = reader.readLine();
            int N = Integer.parseInt(p);
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            int x = (int) Math.pow(2, N);
            String[] a = new String[x];
            if (N == 1) {
                writer.println(0 + "\n" + 1);
                try {
                    writer.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else if (N == 2) {
                writer.println("00" + "\n" + "01" + "\n" + "11" + "\n" + "10");
                try {
                    writer.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else {
                a[0] = "00";
                a[1] = ("01");
                a[2] = ("11");
                a[3] = ("10");
                int count = 2;
                int vojdya = 7;
                while (count != N) {
                    int temp = 0;
                    for (int i = vojdya; i > vojdya / 2; i--) {
                        a[i] = a[temp];
                        temp++;
                    }
                    for (int i = 0; i < vojdya + 1; i++) {
                        if (i > vojdya / 2)
                            a[i] = '1' + a[i];
                        else
                            a[i] = '0' + a[i];
                    }
                    vojdya = vojdya * 2 + 1;
                    count++;
                }
                for (int i = 0; i < x-1; i++)
                    writer.println(a[i]);
                writer.print(a[x-1]);
                try {
                    writer.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            } catch(IOException | NumberFormatException e){
                e.printStackTrace();
            }
    }
}