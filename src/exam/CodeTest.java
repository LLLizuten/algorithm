package exam;

import org.junit.Test;

/**
 * @author lzy
 * 2023/12/22 15:54
 * @description
 */
public class CodeTest {
    @Test
    public void testToBinary() {
        DecimalToBinary toBinary = new DecimalToBinary();
        int num = 2;
        String bianry = toBinary.toBianry(num);
        System.out.println(bianry);
    }

    @Test
    public void testGCD() {
        GCDRecursive gcdRecursive = new GCDRecursive();
        int a = 48, b = 12;
        int gcd = gcdRecursive.calGCD(a, b);
        System.out.println(gcd);
        System.out.println(gcdRecursive.calGCD2(a, b));
    }

    @Test
    public void testFact() {
        int num = 24;
        new FactorsOfNumber().factors(num);
    }
}
