package 每日一题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * @author lzy
 * @create 2022/3/14
 * 给出两个列表，用最少的索引和找出两列表中的共同元素,如果有多个，一起输出
 * 可用哈希表计算索引和
 */
public class FindRestaurant {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        //将第一个列表的值及其索引存入map
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        ArrayList<String> list = new ArrayList<>();
        //初始的索引和需要设一个较大的值
        int sum = Integer.MAX_VALUE;

        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])){
                int j = map.get(list2[i]);
                if (i + j < sum){
                    sum = i + j;
                    //不是相等,则必须把列表之前存放的元素清除
                    list.clear();

                    list.add(list2[i]);
                }else if (i + j == sum){
                    //索引和相等,说明相同元素有多个,一起放进列表
                    list.add(list2[i]);
                }
            }
        }


        return list.toArray(new String[list.size()]);
    }
}
