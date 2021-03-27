import java.io.*;
 
public class d1{
    public static void main(String[] args) throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("allvectors.in")));
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream("allvectors.out")));
            String p = reader.readLine();
            int N = Integer.parseInt(p);
            try{
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            int x = (int) Math.pow(2, N);
            for (int i = 0; i < x; i++) {
                int temp = i;
                StringBuilder vojd = new StringBuilder();
                for (int j = 0; j < N; j++) {
                    vojd.append(temp % 2);
                    temp = temp / 2;
                }
                writer.println(vojd.reverse());
            }
            try{
                writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}