package Recursion;

public class practice {

    static void printNtime(int n){
        if(n == 0) return ;
        System.out.println("Coding Ninjas");
        printNtime(n-1);
    }

    static void printNto1(int n){
        if(n < 1) return;
        
        System.out.println(n);
        printNto1(n-1);
        
    }

    static int sumOfN(int n){
        if(n == 0) return 0;
        return n + sumOfN(n-1);
    }


    static int factriol(int n){
        if( n <= 0) return 1;
        return n * factriol(n-1);
    }
    
    static void swapArray(int i, int j , int [] arr){
        // this function is use to  reverse the array with recursion
        if(i >= j) return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        swapArray(i+1, j-1, arr);
    }


    static int fibonachi(int n){
        if (n <= 1) return n;
        return fibonachi(n-1) + fibonachi(n-2);
    }

    public static void main(String[] args) {
       System.out.println(fibonachi(10));
    }
}
