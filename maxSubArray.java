package Algorithm.Sort;

import java.util.Arrays;

public class maxSubArray {
    public static volatile int[] result = new int[3];

    public static void main(String[] args) {
        int[] arr = new int[]{13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        mergeSubArray(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(result));
    }
    
    //function to judge which to choose.Left, Right or Cross max-subarray
    public static void mergeSubArray(int[] arr, int low, int high){
        if(high > low){
            int mid = (int)(Math.floor((low + high) / 2));
            mergeSubArray(arr, low, mid);
            int[] LSub = result;
            mergeSubArray(arr, mid + 1, high);
            int[] RSub = result;
            int[] CrossSub = mergeCrossingSubArray(arr, low, mid, high);

            if(LSub[2] > RSub[2] && LSub[2] > CrossSub[2]){
                result = LSub;
            }else if(RSub[2] > LSub[2] && RSub[2] > CrossSub[2]){
                result = RSub;
            }else{
                result = CrossSub;
            }
        }
    }
    
    //calculate the cross-maxsubarray,return triplet [min_ind, max_ind, maxsubarray_sum]
    public static int[] mergeCrossingSubArray(int[] arr, int low, int mid, int high){
        int SumL = Integer.MIN_VALUE, SumR = Integer.MIN_VALUE;
        int maxIndL = mid, maxIndR = mid + 1;
        int l_sum = 0, r_sum = 0;

        for(int i = mid; i >= low; i--){
            l_sum += arr[i];
            if(l_sum > SumL){
                SumL = l_sum;
                maxIndL = i;
            }
        }

        for(int i = mid + 1; i <= high; i++){
            r_sum += arr[i];
            if(r_sum > SumR){
                SumR = r_sum;
                maxIndR = i;
            }
        }

        result[0] = maxIndL;
        result[1] = maxIndR;
        result[2] = SumL + SumR;

        return result;
    }


}
