package 每日一题;

/**
 * @author lzy
 * @create 2022/3/14
 */
public class Test {
    @org.junit.Test
    public void test1(){
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"KFC", "Shogun", "Burger King"};
        FindRestaurant findRestaurant = new FindRestaurant();
        String[] restaurant = findRestaurant.findRestaurant(list1, list2);
        System.out.println(restaurant);

    }
}
