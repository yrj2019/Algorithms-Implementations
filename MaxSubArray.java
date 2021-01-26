import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MaxSubArray {
    public static int[] result = new int[3];
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        Collections.addAll(arr, 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, -7);
        maxSubArray(arr, 0, arr.size() - 1);
        System.out.println(Arrays.toString(result));
    }

    public static void maxSubArray(ArrayList<Integer> arr, int p, int r){
        if(p < r){
            int q = (int)(Math.floor((p + r) / 2));
            maxSubArray(arr, p, q);
            int[] L = result;
            maxSubArray(arr, q + 1, r);
            int[] R = result;
            mergeSub(arr, p, q, r);
            int[] cross = result;

            if (L[2] > R[2] && L[2] > cross[2]){
                result = L;
            }else if (R[2] > L[2] && R[2] > cross[2]){
                result = R;
            }else {
                result = cross;
            }
        }
    }
    public static void mergeSub(ArrayList<Integer> arr, int p, int q, int r){
        int maxSumL = Integer.MIN_VALUE, maxSumR = Integer.MIN_VALUE;
        int sumL = 0, sumR = 0;
        int lMinInd = q, rMaxInd = q + 1;
        int sumAll = 0;

        for (int i = q; i >= p; i--){
            sumL += arr.get(i);
            if (maxSumL < sumL){
                maxSumL = sumL;
                lMinInd = i;
            }
        }

        for (int j = q + 1; j <= r; j++){
            sumR += arr.get(j);
            if (maxSumR < sumR){
                maxSumR = sumR;
                rMaxInd = j;
            }
        }

        for (int k = lMinInd; k <= rMaxInd; k++){
            sumAll += arr.get(k);
        }

        result[0] = lMinInd; result[1] = rMaxInd; result[2] = sumAll;
    }
}
