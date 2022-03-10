package test;

import org.junit.Test;

import java.util.Arrays;


/**
 * @author lzy
 * @create 2021-12-13 23:36
 */
public class FirstTest {
    @Test
    public void test(){
        int[] arr = {1,2,3};
        int[] arr2 = {6,7,3};
        arr = arr2;
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr){
        arr[0] = 4;
    }

    @Test
    public void test2(){
        String str = "asd";
        System.out.println(str.length());

        char[] chars = str.toCharArray();
        System.out.println(chars.length);
    }

    @Test
    public void test3(){
        AbstractProduct pro = new ProductA1();
        pro.create();
        Animal dog = new Dog();
        dog.say();

        Dog dog1 = new Dog();
        dog1.dog();
    }
}
