package Sort;

import java.util.Arrays;
import Sort.buildMaxHeap;

public class heapSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 5, 9, 1, 7, 16};
        sortHeap(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sortHeap(int[] arr){
        buildMaxHeap.buildHeap(arr);
        int startPoint = arr.length - 1;
        while (startPoint >= 1){
            int temp;
            temp = arr[startPoint];
            arr[startPoint] = arr[0];
            arr[0] = temp;
            startPoint -= 1;
            maxHeapify(arr, startPoint, 0);
            System.out.println(Arrays.toString(arr));
        }

    }

    public static void maxHeapify(int[] arr, int startPoint, int i){
        int left, right, largest, temp;
        while(true){
            left = getLeft(i);
            right = getRight(i);
            largest = i;
            if(arr[left] > arr[largest] && left < startPoint){
                largest = left;
            }else{
                largest = i;
            }

            if(arr[right] > arr[largest] && right < startPoint){
                largest = right;
            }

            if(largest == i){
                return;
            }

            temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;
            i = largest;
        }
    }

    public static int getLeft(int i){
        return i == 0? 1: (i << 1) + 1;
    }

    public static int getRight(int i){
        return i == 0? 2: (i << 1) + 2;
    }
}
