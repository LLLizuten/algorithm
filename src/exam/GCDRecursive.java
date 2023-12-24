package exam;

/**
 * @author lzy
 * 2023/12/22 16:03
 * @description 递归计算最大公因数
 */
public class GCDRecursive {
    public int calGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        // 较小的数作为新的a值， 较大的数作为新的b值
        return calGCD(b, a % b);
    }

    /**
     * 辗转相除法
     * @param a
     * @param b
     * @return
     */
    public int calGCD2(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
