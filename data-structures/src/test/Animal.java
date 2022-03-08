package test;

/**
 * @author lzy
 * @create 2022-03-05 19:04
 */
public abstract class Animal {
    Animal() {
    }
    public void say(){
        System.out.println("你好");
    }
    abstract void eat();
}
