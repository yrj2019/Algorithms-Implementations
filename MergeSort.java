package Algorithm.Sort;

import java.util.Arrays;

public class mergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 4, 9, 2, 5, 2, 7, 8};
//        System.out.println(arr.length);
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void merge(int[] arr, int p, int q, int r){
        int lenL = q - p + 1;
        int lenR = r - q;
        int[] L = new int[lenL + 1];
        int[] R = new int[lenR + 1];
        for(int i = 0; i < lenL; i++){
            L[i] = arr[i + p];
        }

        for(int i = 0; i < lenR; i++){
            R[i] = arr[i + q + 1];
        }

        L[lenL] = R[lenR] = Integer.MAX_VALUE;
        int indL = 0, indR = 0;
        for(int i = p; i <= r; i++){
            if(L[indL] <= R[indR]){
                arr[i] = L[indL];
                indL += 1;
            }else{
                arr[i] = R[indR];
                indR += 1;
            }
        }

    }

    public static void mergeWithNoFlag(int[] arr, int p, int q, int r){
        int lenL = q - p + 1;
        int lenR = r - q;
        int[] L = new int[lenL];
        int[] R = new int[lenR];

        for(int i = 0; i < lenL; i++){
            L[i] = arr[i + p];
        }

        for(int i = 0; i < lenR; i++){
            R[i] = arr[i + q + 1];
        }


        int indL = 0, indR = 0, ind = p;

        while(indL < lenL && indR < lenR){
            if(L[indL] <= R[indR]){
                arr[ind++] = L[indL++];
            }else{
                arr[ind++] = R[indR++];
            }
        }

//        System.out.println(Arrays.toString(arr));

        while (indL < lenL){
            arr[ind++] = L[indL++];
        }
        while (indR < lenR){
            arr[ind++] = R[indR++];
        }

    }

    public static void mergeSort(int[] arr, int p, int r){
        if(r > p){
            int q = (int)(Math.floor((p + r) / 2));
//            System.out.println(q);
            mergeSort(arr, p, q);
            mergeSort(arr, q + 1, r);
            mergeWithNoFlag(arr, p, q, r);
        }
    }

}
