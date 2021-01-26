import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MaxHeap {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        Collections.addAll(arr, 16, 4, 10, 14, 7, 9, 3, 2, 8, 1);
//        maxHeapify(arr, 1, arr.size() - 1);
//        buildMaxHeap(arr);
        heapSort(arr);
        System.out.println(arr);
    }

    public static void maxHeapify(ArrayList<Integer> arr, int i, int endpoint){
        int l, r, maxInd;
        while(true){
            l = getLeft(i);
            r = getRight(i);
            maxInd = i;
            if (l <= endpoint && arr.get(l) > arr.get(i)){
                maxInd = l;
            }else{
                maxInd = i;
            }

            if (r <= endpoint && arr.get(r) > arr.get(maxInd)){
                maxInd = r;
            }

            if (maxInd == i){
                return;
            }

            Collections.swap(arr, i, maxInd);
            i = maxInd;
        }
    }

    public static void buildMaxHeap(ArrayList<Integer> arr){
        int start = (int)(Math.floor((arr.size() - 1) / 2));
        for (int i = start; i >= 0; i--){
            maxHeapify(arr, i, arr.size() - 1);
        }
    }
    public static void heapSort(ArrayList<Integer> arr){
        buildMaxHeap(arr);
        int startpoint = arr.size() - 1;
        while (startpoint >= 0){
            Collections.swap(arr, 0, startpoint);
            startpoint -= 1;
            maxHeapify(arr, 0, startpoint);
        }
    }

    public static int getMaximum(ArrayList<Integer> arr){
        return arr.get(0);
    }

    public static int popMaximum(ArrayList<Integer> arr){
        int temp = arr.get(0);
        Collections.swap(arr, 0, arr.size() - 1);
        arr.remove(arr.size() - 1);
        maxHeapify(arr, 0, arr.size() - 1);
        return temp;
    }

    public static void increaseKey(ArrayList<Integer> arr, int i, int key){
        if (key < arr.get(i)){
            new Exception("Key is too small");
        }

        buildMaxHeap(arr);
    }

    public static void insertKey(ArrayList<Integer> arr, int key){
        arr.add(key);
        buildMaxHeap(arr);
    }
    public static int getLeft(int i){
        return i == 0 ? 1: ((i << 1) + 1);
    }

    public static int getRight(int i){
        return i == 0 ? 2: ((i << 1) + 2);
    }
}
