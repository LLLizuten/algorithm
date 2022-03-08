package 双指针;

import java.util.Arrays;

/**
 * @author lzy
 * @create 2022-03-07 15:27
 * 反转字符串中的元音字母
 * 讲字符串s中的原因字母反转并返回
 * 双指针，一个指针从头到尾，一个从尾到头
 * 遍历到元音字母时交换位置
 *
 */
public class ReverseVowels {
    public static void main(String[] args) {
        String str = new ReverseVowels().reverseVowels("leetcode");//leotcede
        System.out.println(str);
    }
    public String reverseVowels(String s) {
        //字符串没有索引，索引转成字符数组
        char[] arr = s.toCharArray();
        int i = 0;
        int j = arr.length - 1;
        while (i < j){
            if (!isVowel(arr[i])){
                i++;
            }
            if (!isVowel(arr[j])){
                j--;
            }
            if (isVowel(arr[i]) && isVowel(arr[j])){
                swap(arr, i, j);
                i++;
                j--;
            }

        }
        return new String(arr);
    }

    /**
     * 判断是否为元音字母
     */
    public boolean isVowel(char ch){
        return "aeiouAEIOU".indexOf(ch) >= 0;
    }

    /**
     * 交换字符数组中两元素位置
     */
    public void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
