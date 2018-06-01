package preContest;

/*标题：方格计数  
 
如图p1.png所示，在二维平面上有无数个1x1的小方格。
  
我们以某个小方格的一个顶点为圆心画一个半径为1000的圆。  

你能计算出这个圆里有多少个完整的小方格吗？   

注意：需要提交的是一个整数，不要填写任何多余内容。 */

public class Two {
    public static void main(String[] args) {
        O_n();
    }
    //时间复杂度为O(N2)
    public static void O_n2() {
        int x = 1000;
        int y = 1000;
        int sum = 0;
        for (int a = 1; a <= x; a++) {
            for (int b = 1; b <= y; b++) {
                if (a * a + b * b <= x * y) {
                    sum += 1;
                } else {
                    continue;
                }

            }
        }
        System.out.println(sum * 4);
    }
    //时间复杂度为O(N),分析见图/Two.png
    public static void O_n() {
        int x = 1000;
        int y = 1000;
        int sum = 0;
        int b = 0;
        int tempB = 0;
        for (int a = x; a > 0; a--) {
            while (a * a + b * b <= x * y) {
                b++;
            }
            b--;
            sum += (b - tempB) * a;
            tempB = b;
        }
        System.out.println(sum * 4);
    }
}
