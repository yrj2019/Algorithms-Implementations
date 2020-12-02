package Sort;

import java.util.Arrays;

public class maxHeapfiy {
    public static int flag = 0;
    public static void main(String[] args) {
        int[] arr = new int[]{16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
        convertHeap(arr, 1);
        System.out.println(Arrays.toString(arr));
    }


    public static void convertHeap(int[] arr, int i){
        int l = getLeft(i);
        int r = getRight(i);
        int largest = i;
        int temp = 0;
        if(l < arr.length && arr[l] > arr[i]){
            largest = l;
        }

        if(r < arr.length && arr[r] > arr[largest]){
            largest = r;
        }

        if(largest != i){
            temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            convertHeap(arr, largest);
        }
    }

    public static int getLeft(int i){
        return i == 0 ? 1: (i << 1) + 1;
    }

    public static int getRight(int i){
        return i == 0 ? 2 : (i << 1) + 2;
    }
}
