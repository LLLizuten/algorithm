package exam;

/**
 * @author lzy
 * 2023/12/22 16:36
 * @description 两个罗马数字相加，输出和
 */
import java.util.HashMap;
import java.util.Map;

public class RomanNumberAddition {
    public static void main(String[] args) {
        String roman1 = "XIV";
        String roman2 = "LX";

        int result = addRomanNumbers(roman1, roman2);

        System.out.println("相加结果：" + result);
    }

    public static int addRomanNumbers(String roman1, String roman2) {
        Map<Character, Integer> romanValues = new HashMap<>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);

        int sum = 0;
        int prevValue = 0;

        for (int i = roman1.length() - 1; i >= 0; i--) {
            char c = roman1.charAt(i);
            int value = romanValues.get(c);

            if (value < prevValue) {
                sum -= value;
            } else {
                sum += value;
                prevValue = value;
            }
        }

        for (int i = roman2.length() - 1; i >= 0; i--) {
            char c = roman2.charAt(i);
            int value = romanValues.get(c);

            if (value < prevValue) {
                sum -= value;
            } else {
                sum += value;
                prevValue = value;
            }
        }

        return sum;
    }
}
