package exam;

/**
 * @author lzy
 * 2023/12/22 15:52
 * @description 十进制转二进制
 */
public class DecimalToBinary {
    public String toBianry(int decimal) {
        StringBuilder builder = new StringBuilder();
        while (decimal > 0) {
            builder.insert(0, decimal % 2);
            decimal /= 2;
        }

        return String.valueOf(builder);
    }
}
