package 双指针;

/**
 * @author lzy
 * @create 2022-03-08 15:09
 * 验证回文字符串
 * 给定一个非空字符串s,最多删除一个字符,判断是否能成为回文字符串
 */
public class ValidPalindrome {
    public boolean validPalindrome(String s) {
        boolean isValid = true;
        char[] arr = s.toCharArray();
        int i  = 0;
        int j = arr.length - 1;
        while (i < j){
            if (arr[i] == arr[j]){
                i++;
                j--;
            }
            //删除一个字符串,看看是否能成为回文
            else {
                if (!isPalindrome(arr, i, j - 1)){
                    isValid = isPalindrome(arr, i + 1, j);
                }else {
                    isValid = isPalindrome(arr, i , j - 1);
                }
                break;
            }
        }

        return isValid;
    }
    public boolean isPalindrome(char[] arr, int i ,int j){
        boolean isValid = true;
        while (i < j){
            if (arr[i] == arr[j]){
                i++;
                j--;
            }else {
                isValid = false;
                break;
            }
        }
        return isValid;
    }
}
