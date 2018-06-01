package preContest;

import java.util.Scanner;

/*你有一张某海域NxN像素的照片，"."表示海洋、"#"表示陆地，如下所示：
 
     .......
    .##....
    .##....
    ....##.
    ..####.
    ...###.
    ....... 

其中"上下左右"四个方向上连在一起的一片陆地组成一座岛屿。例如上图就有2座岛屿。

由于全球变暖导致了海面上升，科学家预测未来几十年，岛屿边缘一个像素的范围会被海水淹没。具体来说如果一块陆地像素与海洋相邻(上下左右四个相邻像素中有海洋)，它就会被淹没。

例如上图中的海域未来会变成如下样子：  

    .......
    .......
    .......
    .......
    ....#..
    .......
    .......


请你计算：依照科学家的预测，照片中有多少岛屿会被完全淹没。

【输入格式】 第一行包含一个整数N。 (1 <= N <= 1000) 以下N行N列代表一张海域照片。

照片保证第1行、第1列、第N行、第N列的像素都是海洋。

【输出格式】 一个整数表示答案。

【输入样例】 7 
.  .  .  . . . .
. # # . . . . 
. # # . . . . 
. . . . # # .
. . #### .
. . . ### .
. . . . .  .  .

【输出样例】 1

资源约定： 峰值内存消耗（含虚拟机） < 256M CPU消耗 < 1000ms

请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。

所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。 不要使用package语句。不要使用jdk1.7及以上版本的特性。
主类的名字必须是：Main，否则按无效代码处理。*/

//  解题思路：模拟海岛，bfs遍历求解小岛数，及能被淹没的小岛数。
//若有其中一块陆地四周皆为陆地则不会被淹没 
public class Nine {
    static int N;
    static int Map[][];
    static int visited[][];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine();
        Map = new int[N][N];
        visited = new int[N][N];
        System.out.println();
        for (int i = 0; i < N; i++) {
            String s = sc.nextLine();
            s = s.replace(" ", "");
            char[] c = s.toCharArray();
            for (int j = 0; j < N; j++) {
                if (c[j] == '.') {
                    Map[i][j] = 0;
                } else if (c[j] == '#') {
                    Map[i][j] = 1;
                }
                System.out.print(Map[i][j] + " ");
            }
            System.out.println();
        }
        int num = 0;
        //边缘都是海，1~n-1
        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                if (visited[i][j] == 0) {
                    if (Map[i][j] == 1) {
                        num += bfs(i, j);
                    }
                }
            }

        }
        System.out.println(num);

    }

    private static int bfs(int i, int j) {
        visited[i][j] = 1;
        if (Map[i + 1][j] == 1 && Map[i - 1][j] == 1 && Map[i][j - 1] == 1
                && Map[i][j + 1] == 1) {
            //            System.out.println("一块地");
            return 1;
        }
        if (!(i - 1 == 0 || j - 1 == 0 || i + 1 == N - 1 || j + 1 == N - 1)) {
            if (Map[i + 1][j] == 1 && visited[i + 1][j] == 0) {
                if (bfs(i + 1, j) == 1) {
                    return 1;
                }
            }
            if (Map[i - 1][j] == 1 && visited[i - 1][j] == 0) {
                if (bfs(i - 1, j) == 1) {
                    return 1;
                }
            }
            if (Map[i][j - 1] == 1 && visited[i][j - 1] == 0) {
                if (bfs(i, j - 1) == 1) {
                    return 1;
                }
            }
            if (Map[i][j + 1] == 1 && visited[i][j + 1] == 0) {
                if (bfs(i, j + 1) == 1) {
                    return 1;
                }
            }
        }
        return 0;
    }
}
