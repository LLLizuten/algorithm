package leetcode.双指针;

/**
 * @author lzy
 * @create 2022-03-06 15:36
 * 两数平方和
 * 给一个非负整数c,判断是否存在两个整数a和b,使得a^2 + b^2 = c
 */
public class SumOfSquareNumbers {
    public static void main(String[] args) {
        System.out.println(new SumOfSquareNumbers().judgeSquareSum(5));
    }
    public boolean judgeSquareSum(int c) {
        long i = 0;
        long j = (long) Math.sqrt(c);
        while (i <= j){
            long sum = i * i + j * j;
            if (sum == c){
                return true;
            }else if (sum < c){
                i++;
            }else{
                j--;
            }
        }
        return false;
    }
}
