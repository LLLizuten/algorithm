package leetcode.树.test;

/**
 * @author lzy
 * @create 2022-03-23 22:32
 */
public class TreeTest {
    public static void main(String[] args) {
        B b = new B();
    }
}

class A {
    static {
        System.out.print("1");
    }
    public A() {
        System.out.print("2");
    }
}

class B extends A {
    static {
        System.out.print("a");
    }
    public B() {
        System.out.print("b");
    }
}