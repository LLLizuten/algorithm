package leetcode.双指针;

import java.util.List;

/**
 * @author lzy
 * @create 2022-03-10 16:37
 * 524.通过删除字母匹配到字典里最长单词
 * 最长子序列
 * 给一个字符串s和一个字符串数组dictionary,找出并返回dictionary中最长的字符串,该字符串可以通过删除s中的某些字符得到
 *
 */
public class FindLongestWord {
    public String findLongestWord(String s, List<String> dictionary) {
        String longestWord = "";
        for (String item : dictionary) {
            int len1 = longestWord.length();
            int len2 = item.length();
            //如果当前最长单词的长度>item长度 || 当前最长单词字母顺序 < item,则没有比较的必要,退出当次循环
            if (len1 > len2 || (len1 == len2 && longestWord.compareTo(item) < 0)){
                continue;
            }
            //item长度 > longestWord || 顺序 < longestWord
            //判断item是否为s的字串
            if (isSubString(s, item)){
                longestWord = item;
            }
        }
        return longestWord;
    }

    public boolean isSubString(String s, String item){
        //双指针分别遍历字符串中每个字符
        int i = 0, j = 0;
        while (i < s.length() && j < item.length()){
            //item当前位置的字符与s相等
            if (s.charAt(i) == item.charAt(j)){
                //进入下一个位置字符
                j++;
            }
            //每次比较后i都往后移位
            i++;
        }
        //j与item长度相等,说明item是s的子串
        return j == item.length();
    }
}
