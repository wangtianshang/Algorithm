package preContest;

import java.util.Scanner;

/*螺旋折线

如图p1.png所示的螺旋折线经过平面上所有整点恰好一次。 
对于整点(X, Y)，我们定义它到原点的距离dis(X, Y)是从原点到(X, Y)的螺旋折线段的长度。

例如dis(0, 1)=3, dis(-2, -1)=9

给出整点坐标(X, Y)，你能计算出dis(X, Y)吗？

【输入格式】 
X和Y

对于40%的数据，-1000 <= X, Y <= 1000 
对于70%的数据，-100000 <= X， Y <= 100000 
对于100%的数据, -1000000000 <= X, Y <= 1000000000

【输出格式】 
输出dis(X, Y)

【样例输入】 
0 1

【样例输出】 
3

资源约定： 
峰值内存消耗（含虚拟机） < 256M 
CPU消耗 < 1000ms*/

public class Seven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int x0 = 0;
        int y0 = 0;
        int count = 0;
        int step = 0;
        boolean flag = true;
        while (flag) {
            if (x0 == x && y0 == y) {
                System.out.println(count);
                return;
            }
            step++;
            if (step % 2 != 0) {
                for (int i = 0; i < step; i++) {
                    x0--;
                    count++;
                    if (x0 == x && y0 == y) {
                        System.out.println(count);
                        return;
                    }
                }
                for (int i = 0; i < step; i++) {
                    y0++;
                    count++;
                    if (x0 == x && y0 == y) {
                        System.out.println(count);
                        return;
                    }
                }
            } else {
                for (int i = 0; i < step; i++) {
                    x0++;
                    count++;
                    if (x0 == x && y0 == y) {
                        System.out.println(count);
                        return;
                    }
                }
                for (int i = 0; i < step; i++) {
                    y0--;
                    count++;
                    if (x0 == x && y0 == y) {
                        System.out.println(count);
                        return;
                    }
                }
            }

        }
    }

}
