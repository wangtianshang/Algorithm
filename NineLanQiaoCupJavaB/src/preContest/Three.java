package preContest;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.math.BigInteger;

/*标题：复数幂  
 
    设i为虚数单位。对于任意正整数n，(2+3i)^n 的实部和虚部都是整数。 
     
    求 (2+3i)^123456 等于多少？ 即(2+3i)的123456次幂，这个数字很大，要求精确表示。  
    
    答案写成 "实部±虚部i" 的形式，实部和虚部都是整数（不能用科学计数法表示），中间任何地方都不加空格，实部为正时前面不加正号。(2+3i)^2 写成: -5+12i，  
    
    (2+3i)^5 的写成: 122-597i  
      
    注意：需要提交的是一个很庞大的复数，不要填写任何多余内容。  */

/*复数相乘：(a+bi)(c+di)=(ac-bd)+(bc+ad)i.
注：eclipse不能读出过长的文本文件，坑爹*/
public class Three {
    public static void main(String[] args) throws IOException {

        int n = 123456;
        BigInteger a = new BigInteger("2");
        BigInteger ac = new BigInteger("2");
        BigInteger b = new BigInteger("3");
        BigInteger bc = new BigInteger("3");
        for (int i = 1; i < n; i++) {
            BigInteger tempA = a.multiply(ac).subtract(b.multiply(bc));
            b = b.multiply(ac).add(a.multiply(bc));
            a = tempA;
        }
        PrintStream ps = new PrintStream(
                new FileOutputStream("./src/preContest/Three.txt"));
        System.setOut(ps);

        System.out.println(
                a + (a.compareTo(BigInteger.ZERO) > 0 ? "+" : "") + b + "i");

        /*BufferedWriter bw = new BufferedWriter(
                new FileWriter("./src/preContest/Three.txt"));
        bw.write(a + (a.compareTo(BigInteger.ZERO) > 0 ? "+" : "") + b + "i");
        bw.flush();
        bw.close();*/
    }
}
