package Algorithm.Sort;

import java.util.*;

public class invertedPair {
    public static volatile int num_pairs = 0;

    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 3, 2, 1};
//        System.out.println(calPairs(arr));
        merge(arr, 0, arr.length - 1);
        System.out.println(num_pairs);
    }

    public static int calPairs(int[] arr){
        int len = arr.length;
        HashSet<ArrayList<Integer>> pairs = new HashSet<ArrayList<Integer>>();
        for(int i = 0; i < len - 1; i++){
            for (int j = i + 1; j < len; j++){
                if(arr[i] > arr[j]){
                    ArrayList<Integer> tmp = new ArrayList<Integer>();
                    tmp.addAll(Arrays.asList(arr[i], arr[j]));
                    pairs.add(tmp);
                }
            }
        }
        System.out.println(pairs);
        return pairs.size();
    }

    public static void merge(int[] arr, int p, int r) {
        if(r > p) {
            int q = (int)(Math.floor((r + p) / 2));
            merge(arr, p, q);
            merge(arr, q + 1, r);
            mergeAndCalPairs(arr, p, q, r);
        }

    }

    public static void mergeAndCalPairs(int[] arr, int p, int q, int r) {
        int lenL = q - p + 1;
        int lenR = r - q;
        int[] L = new int[lenL + 1];
        int[] R = new int[lenR + 1];

        for (int i = 0; i < lenL; i++)
            L[i] = arr[p + i];

        for (int i = 0; i < lenR; i++)
            R[i] = arr[q + 1 + i];

        L[lenL] = R[lenR] = Integer.MAX_VALUE;

        int indL = 0, indR = 0;
        for (int i = p; i <= r; i++) {
            if (R[indR] < L[indL]) {
                num_pairs += (lenL - indL);
                arr[i] = L[indR];
                indR++;
            } else {
                arr[i] = L[indL];
                indL++;
            }
        }
    }
}




