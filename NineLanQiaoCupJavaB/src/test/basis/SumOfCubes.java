package test.basis;
//153是一个非常特殊的数，它等于它的每位数字的立方和，即153=1*1*1+5*5*5+3*3*3。编程求所有满足这种条件的三位十进制数。
public class SumOfCubes {
    public static void main(String[] args) {
        for (int i = 100; i < 1000; i++) {
            int a = i / 100;
            int b = i / 10 - a * 10;
            int c = i % 10;
            if (i == Math.pow(a, 3) + Math.pow(b, 3) + Math.pow(c, 3)) {
                System.out.println(i);
            }
        }
    }
}
