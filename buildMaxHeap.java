package Sort;
import Sort.maxHeapfiy;

import java.util.Arrays;

public class buildMaxHeap {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1, 6, 9, 4};
        buildHeap(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Demonstrate why to start from ((arr.length - 1) / 2).floor():
     * the leaf nodes are all maxHeaps or minHeaps, since we need not to start from (arr.length - 1),
     * because it makes no sense when build a maxHeap or minHeap.
     */
    public static void buildHeap(int[] arr){
        int start = (int)((arr.length - 1) / 2);
        for (int i = start; i >= 0; i--){
            maxHeapfiy.convertHeap(arr, i);
        }
    }
}
