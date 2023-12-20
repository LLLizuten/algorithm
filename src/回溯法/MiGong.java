package 回溯法;

/**
 * @author lzy
 * @create 2022-02-27 9:19
 * 迷宫回溯问题
 */
public class MiGong {
    public static void main(String[] args) {
        //用一个二维数组模拟迷宫
        int[][] map = createMap();
        showMap(map);
        setWay(map, 1, 1);
        System.out.println("-------------");
        showMap(map);
    }
    /**
     * 生成地图
     */
    public static int[][] createMap(){
        //创建一个二维数组模拟迷宫
        int[][] map = new int[8][7];
        //使用1表示墙,上下全部置1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //左右置1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //设置挡板
        map[3][1] = 1;
        map[3][2] = 1;
        return map;
    }

    /**
     * 输出地图
     */
    public static void showMap(int[][] map){
        //输出地图
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println("");
        }
    }

    /**
     * 使用递归来给小球寻路
     * @param map 地图
     * @param i 从哪个位置开始找
     * @param j 从哪个位置开始找
     * @return 如果找到通路,就返回true,否则返回false
     * 小球从(1,1)出发,如果能到(6,5)位置,说明通路能找到
     * map[i][j]表示0时,表示该点未走过;为1表示墙,无法通过;2表示通路可以走;3表示该位置已走过,但不通
     * 策略:下->右->上->左,如果该点不通再回溯
     */
    public static boolean setWay(int[][] map, int i, int j){
        //递归终止条件,表示终点已找到
        if (map[6][5] == 2){
            return true;
        }else if (map[i][j] == 0){
            //先假设该点为通路
            map[i][j] = 2;
            //行进策略:下->右->上->左
            if (setWay(map, i + 1, j)){
                return true;
            }else if (setWay(map, i, j + 1)){
                return true;
            }else if (setWay(map, i - 1, j)){
                return true;
            }else if (setWay(map, i, j - 1)){
                return true;
            }
            //上下左右都不通,说明此路为死路
            map[i][j] = 3;
            return false;
        }
        //map[i][j] = 1,2,3 的情况
        return false;
    }
}
