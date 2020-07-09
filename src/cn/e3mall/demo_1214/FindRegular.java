package cn.e3mall.demo_1214;

import java.util.Objects;

/**
 * @ClassName: FindRegular
 * @Auther: admin
 * @Date: 2020/4/23 15:50
 * @Description:
 */
public class FindRegular {

    public static void main(String[] args) {
        int jieshu = 5;
        int[][] juzhen = new int[jieshu][jieshu];

       xx(juzhen, jieshu, 0, 0, 0);

        int weishu = String.valueOf(jieshu * jieshu).length();
        String format = "%0" + weishu + "d"; //

        StringBuilder sb = new StringBuilder();
        for (int m = 0; m < jieshu; m++) {
            for (int n = 0; n < jieshu; n++) {
                sb.append(String.format(format, juzhen[m][n]) + " ");
            }
            sb.append("\n");
        }



        System.out.println(sb.toString());

    }

    public static int[][] xx(int[][] juzhen, int jieshu, int count, int i, int j) {
        if (jieshu <= 0) {
            return null;
        }

       int a = count;
       int end= jieshu * 2 + (jieshu - 2) * 2 + count;
       if (jieshu == 1) {
           end = end + 1;
       }
        boolean b1 = false; // 第一条边是否有值
        boolean b2 = false; // 第二条边是否有值
       for (;;) {
            if (a == end) {
                break;
            }
           a++;
            if (!b1 && j < jieshu) {
                if (j == jieshu - 1) {
                    b1 = true;
                }
                juzhen[i][j] = a;
                j++;
            } else {
                if (!b2 && i < jieshu - 1) {
                    j = jieshu - 1;
                    i++;
                    if (i == jieshu - 1) {
                        b2 = true;
                    }
                    juzhen[i][j] = a;
                } else {
                    j--;
                    if (j >= 0) {
                        juzhen[i][j] = a;
                    } else {
                        j = 0;
                        i--;
                        if (i >= 0) {
                            juzhen[i][j] = a;
                        }
                    }
                }
            }
       }

       int[][] xx = null;
       int jieshu2 = jieshu - 2;
       if (jieshu2 <= 0) {
           return juzhen;
       } else {
           xx = xx(new int[jieshu2][jieshu2], jieshu2, a, 0, 0);
       }
       if (xx == null) {
           return juzhen;
       } else {
           for (int m = 0; m < jieshu2; m++) {
               for (int n = 0; n < jieshu2; n++) {
                   juzhen[m + 1][n+ 1] = xx[m][n];
               }
           }
       }


        return juzhen;
    }
}
