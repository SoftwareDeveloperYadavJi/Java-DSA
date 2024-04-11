package GFGPRACTICE;
import java.util.*;

public class ThreeLargestProduct {


    public static int findThreeLargestProduct(int nums[]){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) ->  b-a);

        for(int num : nums){
            if(!maxHeap.contains(num)){
                maxHeap.offer(num);
            }
        }

        if(maxHeap.size() < 3){
            throw new IllegalArgumentException("Array should Have atlest three distint element");

        }
        int largest1 = maxHeap.poll();
        int largest2 = maxHeap.poll();
        int largest3 = maxHeap.poll();
        
        return largest1 * largest2 * largest3;
    }

   

    public static void main(String[] args) {
        int arra[] = {1,2,3,2,1,2};
        System.out.println(findThreeLargestProduct(arra));
    }
}
