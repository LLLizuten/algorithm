package sparsearray;

import org.junit.Test;

/**
 * @author lzy
 * @create 2021-11-19 16:59
 * 稀疏数组
 */
public class SparseArray {
    public static void main(String[] args) {
        /*
        创建一个原始二维数组  11*11
        0:没有棋子  1:黑子    2:蓝子
        黑子位置:2行3列
        蓝子位置:3行4列
         */
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        //输出原始数组
        System.out.println("原始数组:");
        for (int[] row : chessArr1) {
            for (int anInt : row) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }

        /*
        将二维数组转换为稀疏数组
        1.先遍历,得到有效数据个数sum
        2.创建稀疏数组
        3.将有效数据放入稀疏数组
         */
        int sum = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[0].length; j++) {
                if (chessArr1[i][j] != 0){
                    sum++;
                }
            }
        }

        //创建
        int[][] sparseArray = new int[sum + 1][3];

        //赋值
        sparseArray[0][0] = chessArr1.length;
        sparseArray[0][1] = chessArr1[0].length;
        sparseArray[0][2] = sum;
        //用来计数
        int count = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[0].length; j++) {
                if (chessArr1[i][j] != 0){
                    count++;
                    //依次存入行,列,值
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArr1[i][j];
                }
            }
        }

        System.out.println("稀疏数组:");
        for (int[] row : sparseArray) {
            for (int anInt : row) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }

        /*
        将稀疏数组转为原始数组
        1.获得行列值
        2.遍历稀疏数组,获得值,传入恢复后的原始数组
         */
        int row = sparseArray[0][0];
        int line = sparseArray[0][1];
        int[][] chessArr2 = new int[row][line];
        //遍历
        for (int i = 1; i < sparseArray.length; i++) {
            //需细想
            chessArr2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        System.out.println("恢复后的原始数组:");
        for (int[] i : chessArr2) {
            for (int anInt : i) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }

    }


}
