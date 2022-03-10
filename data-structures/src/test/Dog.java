package test;

/**
 * @author lzy
 * @create 2022-03-05 19:06
 */
public class Dog extends Animal{
    @Override
    void eat() {
        System.out.println("狗吃");
    }

    @Override
    public void say() {
        System.out.println("dog");
    }
    void dog(){
        System.out.println("狗自己的方法");
    }
}
