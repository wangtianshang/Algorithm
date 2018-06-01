package test.basis;

import java.util.Scanner;

public class HexConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long ten = sc.nextLong();
        String hex = Long.toString(ten, 16);
        hex = hex.toUpperCase();
        System.out.println(hex);
    }

}
/*import java.util.Scanner;
 * 给定n个十六进制正整数，输出它们对应的八进制数。16进制长度小于10000
 * 正确解法
public class HexConverter {
    public static void main(String[] args) {
        new HexConverter().systemScanner();
    }
    public void systemScanner() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                String strTmp = sc.next();
                tranform(strTmp.toCharArray(), strTmp.length());
            }
        }
    }
    
     * 3位16进制等价于4位8进制
     
    int[] stack = new int[40000];
    public void tranform(char[] str, int length) {
        int top = -1;
        for (int i = length - 1; i >= 0; i -= 3) {
            int sum = 0;
            for (int j = 0; j < 3 && i - j >= 0; j++) {// i-j>=0防止不够三个的情况
                int tmp = str[i - j] >= '0' && str[i - j] <= '9'
                        ? str[i - j] - '0'
                        : str[i - j] - 'A' + 10;//区分是数字，还是字符，进行对应转换
                sum += (tmp << (4 * j));//这句很重要，通过这句就可以从16变成10进制了，不过，不知道为什么？是如何得出的呢？而且进行累加之后就能得到最终的结果很神奇
            }
            stack[++top] = sum;//sum的结果是16进制转化10进制的结果，每3个16进制变成10进制，再变8进制
        }
        while (stack[top] == 0) {//排除前导为0的判断
            top--;
        }
        //      for(int i=top;i>=0;i--){//直接输出会丢失前导0，因为此转化成8进制并不是最左边的情况，应该保留0
        //          System.out.print(Integer.toOctalString(stack[i]));//从10进制转化成8进制
        //      }
        for (int i = top; i >= 0; i--) {
            String str1 = Integer.toOctalString(stack[i]);//从10进制转化成8进制
            if (i != top && str1.length() < 4) {
                //不是最左边的一个，就不用去掉前导0,而默认是去掉0的，所以要进行补会
                for (int y = 0; y < 4 - str1.length(); y++) {
                    System.out.print("0");
                }
            }
            System.out.print(str1);
        }
        System.out.println();

    }
}*/

/*//给定n个十六进制正整数，输出它们对应的八进制数。16进制长度小于10000
 * 超时
public class HexConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String hex[] = new String[n];
        for (int i = 0; i < n; i++) {
            hex[i] = sc.nextLine();
        }
        for (String string : hex) {
            String tempO = "";
            int hLen = string.length();
            if (hLen % 3 == 1) {//多一个
                string = "00" + string;
                hLen += 2;
            } else if (hLen % 3 == 2) {//多2个
                string = "0" + string;
                hLen += 1;
            }
            for (int i = 0; i < hLen / 3; i++) {
                int tempH = Integer
                        .parseInt(string.substring(3 * i, 3 * (i + 1)), 16);
                tempO += Integer.toString(tempH, 8);
            }
            tempO = tempO.replace("^0*", "");
            System.out.println(tempO);
        }
    }

}*/

/*给定n个十六进制正整数，输出它们对应的八进制数。16进制长度小于10000
 * 运行超时import java.util.Scanner;
public class HexConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String hex[] = new String[n];
        String bin[] = new String[n];
        String oct[] = new String[n];
        for (int i = 0; i < n; i++) {
            hex[i] = sc.nextLine();
        }
        for (int i = 0; i < n; i++) {
            bin[i] = "";
            oct[i] = "";
            for (int k = 0; k < hex[i].length(); k++) {
                switch (hex[i].charAt(k)) {
                    case '0' :
                        bin[i] += "0000";
                        break;
                    case '1' :
                        bin[i] += "0001";
                        break;
                    case '2' :
                        bin[i] += "0010";
                        break;
                    case '3' :
                        bin[i] += "0011";
                        break;
                    case '4' :
                        bin[i] += "0100";
                        break;
                    case '5' :
                        bin[i] += "0101";
                        break;
                    case '6' :
                        bin[i] += "0110";
                        break;
                    case '7' :
                        bin[i] += "0111";
                        break;
                    case '8' :
                        bin[i] += "1000";
                        break;
                    case '9' :
                        bin[i] += "1001";
                        break;
                    case 'A' :
                        bin[i] += "1010";
                        break;
                    case 'B' :
                        bin[i] += "1011";
                        break;
                    case 'C' :
                        bin[i] += "1100";
                        break;
                    case 'D' :
                        bin[i] += "1101";
                        break;
                    case 'E' :
                        bin[i] += "1110";
                        break;
                    case 'F' :
                        bin[i] += "1111";
                        break;
                    default :
                        break;
                }
            }
            int bLen = bin[i].length();
            if (bLen % 3 == 1) {//多一个
                bin[i] = "00" + bin[i];
                bLen += 2;
            } else if (bLen % 3 == 2) {//多2个
                bin[i] = "0" + bin[i];
                bLen += 1;
            }
            for (int j = 0; j < bLen / 3; j++) {
                String temp = bin[i].substring(j * 3, (j + 1) * 3);
                switch (temp) {
                    case "000" :
                        oct[i] += "0";
                        break;
                    case "001" :
                        oct[i] += "1";
                        break;
                    case "010" :
                        oct[i] += "2";
                        break;
                    case "011" :
                        oct[i] += "3";
                        break;
                    case "100" :
                        oct[i] += "4";
                        break;
                    case "101" :
                        oct[i] += "5";
                        break;
                    case "110" :
                        oct[i] += "6";
                        break;
                    case "111" :
                        oct[i] += "7";
                        break;
                    default :
                        break;
                }
            }
            oct[i] = oct[i].replaceFirst("^0*", "");
            System.out.println(oct[i]);
        }
    }

}*/

/*给定n个十六进制正整数，输出它们对应的八进制数。16进制长度小于10000
 * 运行超时
public class HexConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        BigInteger hex[] = new BigInteger[n];
        for (int i = 0; i < n; i++) {
            hex[i] = new BigInteger(sc.nextLine(), 16);
            System.out.println(hex[i].toString(8));
        }
        for (BigInteger i : hex) {
            System.out.println(i.toString(8));
        }
    }
}*/

/*import java.util.Scanner;
//输入16进制，转10进制
public class HexConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = Long.parseLong(sc.nextLine(), 16);
        System.out.println(Long.toString(n));
    }
}*/
