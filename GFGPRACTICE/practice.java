package GFGPRACTICE;


import java.net.Inet4Address;
import java.util.*;


public class practice {

    static int [] productArrayPuzzel(int [] arr){
        int newaaarr[] = new int[arr.length];
        
        for(int i=0; i<arr.length; i++){
            int sum = 1;
            for(int j=0; j<arr.length; j++){
                if(i == j) continue;
                else sum *= arr[j];
            }

            newaaarr[i] = sum;
        }
        return newaaarr;

    }

    static int getlongestSubArray(int arr[], int key){
        int len = 0;
        for(int i=0; i<arr.length; i++){
            for(int j=i; j<arr.length; j++){
                int sum = 0;
                for(int k=i ;k<j; k++){
                    sum += arr[k];
                }
                if(sum == key) len = Math.max(len, j-i+1);
            }
        }
        return len;
    }


    static void gernerateSubArray(int arra[]){
        for(int i=0; i<arra.length; i++){
            for(int j=i; j<arra.length; j++){
                for(int k=i; k<j; k++){
                    System.out.print(arra[k] + " ");
                }
                System.out.println();
            }
        }
    }

    static List<List<Integer>> triplet(int arra[] , int key){
        Set<List<Integer>> st = new HashSet<>();
        for(int i=0; i<arra.length; i++){
            for(int j=i+1; j<arra.length; j++){
                for(int k = j+1; k<arra.length; k++){
                    if(arra[i] +arra[j] + arra[k] == key){
                        List<Integer> temp = Arrays.asList(arra[i],arra[j],arra[k]);
                        temp.sort(null);
                        st.add(temp);
                    }
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(st);
        return ans;
    }


    static List<List<Integer>> optimizeTriplet(int arr[]){
        List<List<Integer>> ans = new ArrayList();
        Arrays.sort(arr);
        for(int i=0; i<arr.length; i++){
            if(i != 0 && arr[i] == arr[i-1]) continue;
            int j = i+1;
            int k = arr.length-1;
            while (j<k) {
                int sum = arr[i] + arr[j] + arr[k];
                if(sum < 0){
                    j++;
                }else if(sum > 0){
                    k--;
                }else{
                    List<Integer> temp = Arrays.asList(arr[i],arr[j],arr[k]);
                    ans.add(temp);
                    j++;
                    k--;
                    while(j<k && arr[j] == arr[j-1]) j++;
                    while(j<k && arr[k] == arr[k-1]) k--;
                }
                
            }
        }
        return ans;
    }

    static List<List<Integer>> fourSum(int arra[], int target){
        Set<List<Integer>> set = new HashSet<>();
        for(int i=0; i<arra.length; i++){
            for(int j=i+1; j<arra.length; j++){
                for(int k= j+1; k<arra.length; k++){
                    for(int l= k+1 ; l<arra.length; l++){
                        if(arra[i] + arra[j] + arra[k] + arra[l] == target){
                            List<Integer> temp = Arrays.asList(arra[i],arra[j],arra[k],arra[l]);
                            Collections.sort(temp);
                            set.add(temp);
                        }
                    }
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
        
    }


    static int kadaneAlgo(int arra[]){
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0; i<arra.length; i++){
            sum += arra[i];
            if(sum < 0){
                sum = 0;
            }
            max = Math.max(max, sum);
        }
        return max;
    }


    static int missingNumber(int aar[], int N){
        int sum = (N * (N + 1))/ 2;
        
        int temp = 0;
        for (int i = 0; i < aar.length; i++) {
            temp += aar[i];
        }

        int missingNum = sum - temp;
        return missingNum;
    }


    static long maxSubarraySum(int arr[]){
        long max = Integer.MIN_VALUE;
        long sum = 0;
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
            if(sum > max){
                max = sum;
            }
            if(sum < 0) sum = 0;
        }
        return max;
    }


    static int mmajorityElemnet(int arr[]){
        int count = 0;
        int element = 0;
        for(int i=0; i<arr.length; i++){
            if (count == 0) {
                count = 1;
                element = arr[i];

            }else if(element == arr[i]) count++;
            else count--;
        }
        int counter = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == element) counter++;
        }

        if(counter > arr.length/2){
            return element;
        }
        return -1;
    }


    static int inversionCount(int arr[]){
        // this is the absolute brude froce apporch
        int count =0;
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length; j++){
                if(arr[i]  > arr[j]){
                    count++;
                }
            }
        }
        return count;
    }

    static void leftrotate(int arra[]){
        int temp = arra[0];
        for(int i=0; i<arra.length-1; i++){
            arra[i] = arra[i+1];
        }
        arra[arra.length-1] = temp;
    }

   

    public static void main(String[] args) {
        
        int arr [] = {9, 4, -2, -1, 5, 0, -5, -3, 2};
        System.out.println(kadaneAlgo(arr));

    }




    private static int[] alternativePosneg(int[] arr) {
        // TODO Auto-generated method stub
        ArrayList<Integer> postive = new ArrayList<>();
        ArrayList<Integer> negtive = new ArrayList<>();
        int  result [] = new int[arr.length];
        for (Integer integer : arr) {
            if(integer > 0) postive.add(integer);
            else negtive.add(integer);
        }
        int i = 0 , j = 0;
        boolean flag = true;
        int count = 0;
        while (i<postive.size() && j<negtive.size()) {
            if(flag){
                result[count++] = postive.get(i);
                i++;
                flag = false;
            }else{
                result[count++] = negtive.get(j);
                j++;
                flag = true;
            }
        }
        while (i<postive.size()) {
            result[count++] = postive.get(i);
            i++;
        }
        while (j<negtive.size()) {
            result[count++] = negtive.get(j);
            j++;
        }

        return result;

    }
}
