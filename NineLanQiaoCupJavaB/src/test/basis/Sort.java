package test.basis;

import java.util.Arrays;
import java.util.Scanner;

//n个数排序
public class Sort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int seq[] = new int[n];
        for (int i = 0; i < n; i++) {
            seq[i] = sc.nextInt();
        }
        Arrays.sort(seq);
        for (int i : seq) {
            System.out.print(i + " ");
        }
    }
}
