package leetcode.树.test;

/**
 * @author lzy
 * @create 2022-03-23 22:32
 * 验证:类的启动流程，先执行静态方法，再执行构造方法，先父类再子类
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