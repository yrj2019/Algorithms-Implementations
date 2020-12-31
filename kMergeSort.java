package Sort;

import kotlin.random.Random;

import java.lang.reflect.Array;
import java.util.*;
import java.util.PriorityQueue;

public class kMergeSort {
    public static void main(String[] args) {
        ArrayList<ListNodeList> listNodeLists = new ArrayList<ListNodeList>();
        ArrayList<ListNode> heads = new ArrayList<ListNode>();
        int k = 5;
        for (int i = 0; i < k; i++){
            ArrayList<ListNode> subSeq = generateRandomSequence(2, 15);
            ListNodeList sub = new ListNodeList(subSeq);
            listNodeLists.add(sub);
            heads.add(sub.head);
        }
        System.out.println(heads);
        ArrayList<Integer> res = mergeSort(heads);
        System.out.println(Arrays.toString(res.toArray()));

    }

    public static ArrayList<Integer> mergeSort(ArrayList<ListNode> heads){
        ListNode minNode;
        ArrayList<Integer> res = new ArrayList<Integer>();
        smallPriorityQueue minRootQueue = new smallPriorityQueue(heads);
        minRootQueue.minHeapify(0);
        minNode = minRootQueue.minimum();
        while(minNode.next != null){
            res.add(minNode.value);
            minRootQueue.delete(0);
            minRootQueue.insert(minNode.next);
        }

        return res;
    }

    public static ArrayList<ListNode> generateRandomSequence(int low, int high){
        ArrayList<ListNode> res = new ArrayList<ListNode>();
        int base = low;
        int uncertain = high - low + 1;
        int seqLen = base + (int)(Math.random() * uncertain / 2);
        for(int i = 0; i < seqLen; i++){
            res.add(new ListNode(base + (int)(Math.random() * uncertain)));
            System.out.println(res.get(res.size() - 1).value);
        }

        return res;
    }
}

class ListNode{
    int value;
    ListNode next;
    ListNode pre;

    public ListNode(int value){
        this.value = value;
    }
}

class ListNodeList{
    public ListNode head;
    public ListNodeList(ArrayList<ListNode> arr){
        head = arr.get(0);
        ListNode present = arr.get(0);
        for (int i = 1; i < arr.size(); i++){
            present.next = arr.get(i);
            arr.get(i).pre = present;
            present = present.next;
        }
    }
}

class smallPriorityQueue{
    public ArrayList<ListNode> entry;

    public smallPriorityQueue(ArrayList<ListNode> entry){
        this.entry = entry;
    }

    public void insert(ListNode ele){
        entry.add(ele);
        Collections.swap(entry, entry.size() - 1, 0);
        minHeapify(0);
    }

    public void minHeapify(int ind){
        int minimum, l, r;
        int length = entry.size();
        while(true){
            minimum = ind;
            l = getLeft(minimum);
            r = getRight(minimum);

            if(l < length && entry.get(l).value < entry.get(minimum).value){
                minimum = l;
            }else{
                minimum = ind;
            }

            if(r < length && entry.get(r).value < entry.get(minimum).value){
                minimum = r;
            }

            if(minimum == ind){
                return;
            }

            Collections.swap(entry, ind, minimum);
            ind = minimum;
        }
    }

    public ListNode minimum(){
        return entry.get(0);
    }

    public ListNode extractMin(){
        ListNode res = entry.get(0);
        Collections.swap(entry, 0, entry.size() - 1);
        entry.remove(entry.size() - 1);
        return res;
    }

    public void delete(int ind){
        Collections.swap(entry, ind, entry.size() - 1);
        entry.remove(entry.size() - 1);
        minHeapify(ind);
    }

    public static int getLeft(int i){
        return i == 0 ? 1:((i << 1) + 1);
    }

    public static int getRight(int i){
        return i == 0 ? 2:((i << 1) + 2);
    }
}

