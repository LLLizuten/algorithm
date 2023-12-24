package exam;

/**
 * @author lzy
 * 2023/12/22 16:30
 * @description 分解一个数的所有因数
 */
public class FactorsOfNumber {
    public void factors(int num) {
        for (int i = 1; i <= num; i++) {
            if (num % i == 0)
                System.out.println(i);
        }
    }
}
