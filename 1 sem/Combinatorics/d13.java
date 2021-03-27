import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;
 
public class d13 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("num2perm.in")));
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream("num2perm.out")));
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        Scanner leha = new Scanner(line);
        int n = leha.nextInt();
        BigInteger k = leha.nextBigInteger();
        BigInteger[] a;
        a = num2permutation(n, k);
        for (int i = 1;  i <= n; i++)
            writer.print(a[i] + " ");
        reader.close();
        writer.close();
        /*int n = Integer.parseInt(line);
        line = reader.readLine();
        int[] a = new int[n+1];
        for (int i = 0; i < n; i++)
            a[i] = leha.nextInt();
        System.out.print(permutation2num(a, n)+1);*/
    }

    /*static int permutation2num(int[] a, int n) {
        int numOfPermutation = 0;
        boolean[] was = new boolean[n+1];
        int[] P = new int[n+1];
        for (int i = 1;  i <= n; i++) {
            for (int j = 1; j <= a[i]-1; j++)
                if (!was[j])
                    numOfPermutation++;
            was[a[i]] = true;
        }
        return numOfPermutation;
    }*/

    public static BigInteger getFactorial(int f) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= f; i++)
            result = result.multiply(BigInteger.valueOf(i));
        return result;
    }

    public static BigInteger[] num2permutation(int n, BigInteger k) {
        BigInteger temp;
        boolean[] was = new boolean[n+1];
        BigInteger[] permutation = new BigInteger[n+1];
        for (int i = 1;  i <= n; i++) {
            if (n-i == 0)
                temp = BigInteger.valueOf(1);
            else
                temp = getFactorial(n - i);
            BigInteger alreadyWas = k.divide(temp);
            k = k.mod(temp);
            BigInteger curFree = BigInteger.valueOf(0);
            for (int j = 1; j <= n; j++)
                if (!was[j]) {
                    curFree = curFree.add(BigInteger.valueOf(1));
                    if (curFree.equals(alreadyWas.add(BigInteger.valueOf(1)))) {
                        permutation[i] = BigInteger.valueOf(j);
                        was[j] = true;
                    }
                }
        }
        return permutation;
    }
}