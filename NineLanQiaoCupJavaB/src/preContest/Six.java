package preContest;

import java.util.Scanner;

/*递增三元组
        
        给定三个整数数组 
        A = [A1, A2, … AN], 
        B = [B1, B2, … BN], 
        C = [C1, C2, … CN]， 
        请你统计有多少个三元组(i, j, k) 满足： 
        1. 1 <= i, j, k <= N 
        2. Ai < Bj < Ck
        
        【输入格式】 
        第一行包含一个整数N。 
        第二行包含N个整数A1, A2, … AN。 
        第三行包含N个整数B1, B2, … BN。 
        第四行包含N个整数C1, C2, … CN。
        
        对于30%的数据，1 <= N <= 100 
        对于60%的数据，1 <= N <= 1000 
        对于100%的数据，1 <= N <= 100000 0 <= Ai, Bi, Ci <= 100000
        
        【输出格式】 
        一个整数表示答案
        
        【样例输入】 
        3 
        1 1 1 
        2 2 2 
        3 3 3
        
        【样例输出】 
        27
        
        资源约定： 
        峰值内存消耗（含虚拟机） < 256M 
        CPU消耗 < 1000ms
        
        分析：直接暴力写的。 
        想法就是，枚举b中的数字，统计a中小于b的个数，c中大于b的个数，然后相乘即可。最后将乘积求和。*/
public class Six {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        int b[] = new int[n];
        int c[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            c[i] = sc.nextInt();
        }
        /* O(N3)
               int sum = 0;
        for (int i : a) {
            for (int j : b) {
                for (int k : c) {
                    if (i < j && j < k) {
                        sum++;
                    }
                }
            }
        }*/
        //O(N2)
        int sum = 0;
        int tempSum1 = 0;
        int tempSum2 = 0;
        for (int j : b) {
            for (int i : a) {
                if (i < j) {
                    tempSum1++;
                }
            }
            for (int k : c) {
                if (k > j) {
                    tempSum2++;
                }
            }
            sum += tempSum1 * tempSum2;
            tempSum1 = 0;
            tempSum2 = 0;
        }
        System.out.println(sum);
    }

}
