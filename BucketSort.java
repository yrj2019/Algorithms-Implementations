import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {
    public static void main(String[] args) {
        double[] arr = new double[]{0.78, 0.17, 0.39, 0.26, 0.72, 0.94, 0.21, 0.12, 0.23, 0.68};
        System.out.println(bucketSort(arr));
    }

    public static ArrayList<Double> bucketSort(double[] arr){
        int n = arr.length;
        ListNode[] CacheList = new ListNode[n];
        int tmp_ind;
        ListNode tmp_node;
//        ListNode tmp_node;
        for (int i = 0; i < CacheList.length; i++){
            CacheList[i] = null;
        }

        for (int j = 0; j < n; j++){
            tmp_ind = (int)Math.floor(n * arr[j]);
            if (CacheList[tmp_ind] == null){
                CacheList[tmp_ind] = new ListNode(arr[j], null);
            }else{
                tmp_node = CacheList[tmp_ind];
                ListNode pre = tmp_node;

                while(pre != null && pre.val < arr[j]){
                    if (pre.next.val > arr[j]){
                        pre = tmp_node;
                        tmp_node = tmp_node.next;
                        break;
                    }else{
                        pre = tmp_node;
                        tmp_node = tmp_node.next;
                    }
//                    pre = tmp_node;
                }

                if (tmp_node == null){
                    pre.next = new ListNode(arr[j], null);
                }else if (pre == tmp_node){
                    CacheList[tmp_ind] = new ListNode(arr[j], null);
//                    CacheList[tmp_ind].setNext(tmp_node);
                    CacheList[tmp_ind].next = tmp_node;
                }else{
                    ListNode tmp = new ListNode(arr[j], null);
                    pre.next = tmp;
                    tmp.next = tmp_node;
                }
            }

        }

        ArrayList<Double> result = new ArrayList<Double>();
        for(int k = 0; k < CacheList.length; k++){
            if (CacheList[k] != null){
                ListNode pre = CacheList[k];
                while (pre != null){
                    result.add(pre.val);
                    pre = pre.next;
                }
//                result.add(pre.val);
            }
        }

        return result;
    }
}

class ListNode{
    double val;
    ListNode next;
    public ListNode(double val, ListNode next){
        this.val = val;
        this.next = next;
    }

    public void setNext(ListNode next){
        this.next = next;
    }
}