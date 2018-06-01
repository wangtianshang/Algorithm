package test.basis;

import java.math.BigInteger;
import java.util.Scanner;

//快速计算幂次方算法
public class QuickPow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(quickPow(n, m));
    }

    private static BigInteger quickPow(int n, int m) {
        if (m == 0) {
            return BigInteger.ONE;
        }
        BigInteger temp = quickPow(n, m / 2);
        temp = temp.multiply(temp);
        if (m % 2 != 0) {
            temp = temp.multiply(BigInteger.valueOf(n));
        }
        return temp;

    }
}
