package test.basis;

import java.util.Scanner;

//求1+2+3+...+n的值。
public class SequenceSummation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long sum = n * (n + 1) / 2;
        System.out.println(sum);
    }
}
