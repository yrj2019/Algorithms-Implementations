package Sort;
import Sort.PriorityQueue.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class DeleteNode {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(3, 2, 1, 4, -1, 6));
//        int[] arr = new int[]{3, 2, 1, 4, -1, 6};
        PriorityQueue.buildMaxHeap(arr);
        System.out.println(Arrays.toString(arr.toArray()));
        deleteNode(arr, 2);
        System.out.println(Arrays.toString(arr.toArray()));
    }

    public static void deleteNode(ArrayList<Integer> arr, int i){
        int length = arr.size();
        Collections.swap(arr, i, length - 1);
        arr.remove(length - 1);
        PriorityQueue.maxHeapify(arr, i);
    }
}
