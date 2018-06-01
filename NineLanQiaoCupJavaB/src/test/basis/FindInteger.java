package test.basis;

import java.util.Scanner;

/*给出一个包含n个整数的数列，问整数a在数列中的第一次出现是第几个。
    
    输入格式
    第一行包含一个整数n。
    
    第二行包含n个非负整数，为给定的数列，数列中的每个数都不大于10000。
    
    第三行包含一个整数a，为待查找的数。*/
public class FindInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int seq[] = new int[n];
        for (int i = 0; i < n; i++) {
            seq[i] = sc.nextInt();
        }
        int a = sc.nextInt();
        int i = 0;
        for (; i < n; i++) {
            if (seq[i] == a) {
                System.out.println(i + 1);
                break;
            }
        }
        if (i == n) {
            System.out.println(-1);
        }
    }
}
