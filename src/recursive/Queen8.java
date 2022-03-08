package recursive;

/**
 * @author lzy
 * @create 2022-02-27 10:26
 * 八皇后问题
 * 回溯法
 * 在8×8 格的国际象棋上摆放八个皇后，使其不能互相攻击
 * 即：任意两个皇后都不能处于同一行、同一列或同一斜线上，问有多少种摆法(92)
 */
public class Queen8 {
    /**
     * 定义皇后的个数(8)和棋盘大小(8*8)
     */
    static int max = 8;
    static int[] arr = new int[max];
    static int count = 0;
    public static void main(String[] args) {
        check(0);
        System.out.println(count);
    }

    /**
     * 输出皇后摆放的位置
     */
    public static void showQueen(){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    /**
     * 当放置第n个皇后时,需检测该皇后是否和前面的皇后冲突
     * n从0开始
     */
    public static boolean judge(int n){
        for (int i = 0; i < n; i++) {
            //判断是否在同一列
            if (arr[n] == arr[i]){
                return false;
            }
            //同一斜线(横坐标之差和纵坐标之差相等,形成等腰直角三角形)
            if (Math.abs(n - i) == Math.abs(arr[n] - arr[i])){
                return false;
            }
        }
        return true;
    }

    /**
     * 放置第n个皇后
     * n从0开始
     */
    public static void check(int n){
        //递归终止条件,n==8,说明前面8个皇后已放好(注意n从0开始)
        if (n == max){
            count++;
            showQueen();
            return;
        }
        //依次放入皇后,并判断是否冲突
        for (int i = 0; i < max; i++) {
            //从第1列开始放
            arr[n] = i;
            //判断皇后放到第i列时是否冲突
            if (judge(n)) {
                //不冲突,接着放n+1个皇后
                check(n + 1);
            }
            //如果冲突,进行下一轮循环(i+1),皇后进行下一个位置的尝试
        }
    }

}
