package test.basis;
/*//123321是一个非常特殊的数，它从左边读和从右边读是一样的。
//输入一个正整数n， 编程求所有这样的五位和六位十进制数，满足各位数字之和等于n 。
import java.util.Arrays;
import java.util.Scanner;

public class Plalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res[] = new int[100000];
        int j = 0;
        for (int i = 100; i < 1000; i++) {
            String temp = Integer.toString(i);
            int a = change(temp.charAt(0));
            int b = change(temp.charAt(1));
            int c = change(temp.charAt(2));
            if (2 * (a + b) + c == n) {
                res[j++] = Integer.parseInt(temp + b + a);
            }
            if (2 * (a + b + c) == n) {
                res[j++] = Integer.parseInt(temp + c + b + a);
            }
        }
        Arrays.sort(res);
        for (int i : res) {
            if (i != 0) {
                System.out.println(i);
            }
        }
    }
    public static int change(char c) {
        return Integer.parseInt(Character.toString(c));
    }
}*/

//1221是一个非常特殊的数，它从左边读和从右边读是一样的，编程求所有这样的四位十进制数。
import java.util.Scanner;

public class Plalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //        ArrayList<Integer> list = new ArrayList();
        for (int i = 10; i < 100; i++) {
            String temp = Integer.toString(i);
            temp += temp.substring(1, 2) + temp.substring(0, 1);
            System.out.println(temp);
            //            list.add(Integer.parseInt(temp));
        }
        //        Collections.sort(list);
        //        for (int i : list) {
        //            System.out.println(i);
        //        }
    }
}
