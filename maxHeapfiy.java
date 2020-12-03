package Sort;

import java.util.Arrays;

public class maxHeapfiy {
    public static void main(String[] args) {
        int[] arr = new int[]{16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
        convertHeap(arr, 1);
        System.out.println(Arrays.toString(arr));
    }


    public static void convertHeap(int[] arr, int i) {
        int l, r, largest, temp;
        while (true) {
            l = getLeft(i);
            r = getRight(i);
            largest = i;
            if (l < arr.length && arr[l] > arr[i]) {
                largest = l;
            } else {
                largest = i;
            }

            if (r < arr.length && arr[r] > arr[largest]) {
                largest = r;
            }

            if (largest == i) {
                return;
            }


            temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            i = largest;
            //            convertHeap(arr, largest);
        }
    }
    public static int getLeft(int i){
        return i == 0 ? 1: (i << 1) + 1;
    }

    public static int getRight(int i){
        return i == 0 ? 2 : (i << 1) + 2;
    }
}
