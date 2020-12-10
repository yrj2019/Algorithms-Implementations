package Algorithm.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class PriorityQueue {
    public static void main(String[] args){
        int[] arr = new int[]{13, -3, -25, 20, -3, -16, -23, 18, -7, 12, -5, -22, 15, -4, 7};
        buildMaxHeap(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println(Maximum(arr));

        HashMap<Integer, int[]> res = ExtractMax(arr);
        System.out.println(res.keySet().toArray()[0]);
        arr = res.get(res.keySet().toArray()[0]);
        System.out.println(Arrays.toString(arr));

        IncreaseKey(arr, 12, 24);
        System.out.println(Arrays.toString(arr));

        int[] insArr = insert(arr, 16);
        System.out.println(Arrays.toString(insArr));
    }

    //insert an element in a queue
    public static int[] insert(int[] arr, int x){
        int temp;
        int length = arr.length;
        int[] laterArr = new int[length + 1];
        System.arraycopy(arr, 0, laterArr, 0, length);
        laterArr[length] = x;
        temp = laterArr[0];
        laterArr[0] = laterArr[length];
        laterArr[length] = temp;
        arr = laterArr;
        buildMaxHeap(arr);
        return arr;
    }

    // return the maximum element of a queue
    public static int Maximum(int[] arr){
        return arr[0];
    }

    public static HashMap<Integer, int[]> ExtractMax(int[] arr){
        HashMap<Integer, int[]> res = new HashMap<Integer, int[]>();
        int maxEle = arr[0];
        int length = arr.length;
        int[] newArr = new int[length - 1];
        newArr[0] = arr[length - 1];
        System.arraycopy(arr, 1, newArr, 1, length - 2);
        arr = newArr;
        maxHeapify(arr, 0);
        res.put(maxEle, arr);
        return res;
    }

    // increase the destinated key to a new value
    public static void IncreaseKey(int[] arr, int src, int dest){
        int ind = 0;
        int length = arr.length;
        for(int i = 0; i < length; i++){
            if(arr[i] == src){
                ind = i;
                break;
            }
        }

        if(dest <= src){
            throw new IllegalArgumentException("the destinated key is too small.");
        }else{
            arr[ind] = dest;
        }

        // TODO
        buildMaxHeap(arr);

    }

    public static void buildMaxHeap(int[] arr){
        int length = arr.length;
        int div_point = (int)(Math.floor((length - 1) / 2));
        for(int i = div_point; i >= 0; i--){
            maxHeapify(arr, i);
        }
    }

    public static void maxHeapify(int[] arr, int i){
        int length = arr.length;
        int largest, l, r, temp;
        while(true){
            l = getLeft(i);
            r = getRight(i);
            largest = i;
            if(l < length && arr[l] > arr[largest]){
                largest = l;
            }else{
                largest = i;
            }

            if(r < length && arr[r] > arr[largest]){
                largest = r;
            }

            if(largest == i){
                return;
            }

            temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            i = largest;
        }
    }

    public static int getLeft(int i){
        return i == 0 ? 1: ((i << 1) + 1);
    }

    public static int getRight(int i){
        return i == 0 ? 2: ((i << 1) + 2);
    }
}
