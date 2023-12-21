package 常见算法.排序算法;

/**
 * @author lzy
 * 2023/12/21 0:13
 * @description 堆排序
 *
 * 堆：一种特殊的树形结构，满足以下两个条件
 * 1.完全二叉树，即除了最后一层外其他层都是满的，且最后一层的元素靠左排列
 * 2.分最大堆和最小堆，前者每个节点的值都≥子节点的值，后者相反
 */
public class HeapSort {
    /**
     * 堆排序思路：
     * 1.将待排序的数组构建成最大堆（最小堆）
     * 2.将堆顶元素与堆底元素交换，并将堆的大小减一
     * 3.对新的堆顶元素进行调整，使其满足堆的定义
     * 4.重复2和3，直到堆的大小为1
     */
    public void sort(int[] arr) {
        // 构建最大堆
        buildHeap(arr);
        // for循环保证每次取出来的都是堆底元素
        for (int i = arr.length - 1; i > 0; i--) {
            // 交换堆顶元素和堆底元素
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            // 每次交换后重新调整堆
            heapify(arr, i, 0);
        }
    }

    /**
     * 构建最大堆
     * @param arr
     */
    public void buildHeap(int[] arr) {
        int n = arr.length;
        // 构建最大堆: 从最后一个非叶子节点开始, 向上建堆
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    /**
     * 自底向上建堆
     * 复杂度O(N)
     * @param n 数组长度
     * @param i 当前节点索引
     *
     * 建堆时需要对堆的每个节点都安排一个索引, 通常采用层序遍历的方式构建索引
     * 因此节点和其子节点的索引关系满足: 左节点为 2i + 1, 右节点为2i + 1
     */
    public void heapify(int[] arr, int n, int i) {
        // 最大值索引, 初始化为当前节点的索引
        int largest = i;
        // 节点与其子节点的索引关系可计算
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        // 找出最大值的索引
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        // 交换
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            // 递归调整交换后的子树
            heapify(arr, n, largest);
        }
    }


}
