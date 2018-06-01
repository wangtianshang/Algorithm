package test.basis;

import java.util.Scanner;

/*问题描述
给出n个数，找出这n个数的最大值，最小值，和。

输入格式
第一行为整数n，表示数的个数。

第二行有n个数，为给定的n个数，每个数的绝对值都小于10000。

输出格式
输出三行，每行一个整数。第一行表示这些数中的最大值，第二行表示这些数中的最小值，第三行表示这些数的和*/
public class MaxMinSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int seq[] = new int[n];
        for (int i = 0; i < n; i++) {
            seq[i] = sc.nextInt();
        }
        int max = seq[0], min = seq[0];
        long sum = 0;
        for (int i : seq) {
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
            sum += i;
        }
        System.out.println(max);
        System.out.println(min);
        System.out.println(sum);
    }
}
