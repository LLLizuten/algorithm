package 每日一题;

/**
 * @author lzy
 * @create 2022/3/14
 */
public class Test {
    @org.junit.Test
    public void test1(){


    }
    public String reverseStr(String s, int k) {
        int left = 0;
        int right = s.length();
        char[] arr = s.toCharArray();
        for(int i = 0; i < right; i += (2 * k)) {
            int start = i;
            int end = i + k;
            // 剩余字符少于k个
            if(end > right) {
                // 将剩余字符全部反转
                end = arr.length - 1;
                reverse(arr, start, end);
            } else {
                // 剩余字符大于或等于k个,反转前k个字符即可
                reverse(arr, start, end);
            }

        }
        return new String(arr);
    }

    public static void reverse(char[] arr, int start, int end) {
        char temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
