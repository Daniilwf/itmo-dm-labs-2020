import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
 
public class d4 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("chaincode.in")));
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream("chaincode.out")));
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int x = 1 << N;
        Map<String, String> slovar = new HashMap<String, String>();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < N; i++) {
            temp.append('0');
        }
        //System.out.println(temp);
        slovar.put(String.valueOf(temp), String.valueOf(temp));
        writer.println(temp);
        String anotherTemp = String.valueOf(temp);
        for (int i = 1; i < x; i++){
            anotherTemp = anotherTemp.substring(1);
            String str0 = anotherTemp + '0';
            String str1 = anotherTemp + '1';
            if (!slovar.containsKey(str1)) {
                slovar.put(str1, str1);
                writer.println(str1);
                anotherTemp = str1;
            } else {
                slovar.put(str0, str0);
                writer.println(str0);
                anotherTemp = str0;
            }
            //System.out.println(slovar.get(++count));
 
        }
        reader.close();
        writer.close();
    }
}