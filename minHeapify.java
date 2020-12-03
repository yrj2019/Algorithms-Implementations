package Sort;

import java.util.Arrays;

public class minHeapify {
    public static void main(String[] args) {
        int[] arr = new int[]{16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
        convertHeap(arr, 0);
        System.out.println(Arrays.toString(arr));
    }

    public static void convertHeap(int[] arr, int i){
        int l, r, minimum, temp;
        while(true){
            l = getLeft(i);
            r = getRight(i);
            if(l < arr.length && arr[l] < arr[i]){
                minimum = l;
            }else{
                minimum = i;
            }

            if(r < arr.length && arr[r] < arr[minimum]){
                minimum = r;
            }

            if(minimum == i){
                return;
            }

            temp = arr[i];
            arr[i] = arr[minimum];
            arr[minimum] = temp;
            i = minimum;
        }
    }

    public static int getLeft(int i){
        return i == 0 ? 1: (i << 1) + 1;
    }

    public static int getRight(int i){
        return i == 0 ? 2: (i << 1) + 2;
    }
}
