package Maths;
import java.util.*;

public class practice {

    static ArrayList<Integer> print_All_divisor(int n){
        ArrayList<Integer> result = new ArrayList();
        for (int i=1; i*i<=n; i++){
            if(n % i == 0){
                result.add(i);
            }
            if((n/i) != i){
                result.add(n/i);
            }
        }
        Collections.sort(result);
        return result;
        // This the optimize code for checking all the divisor of number
    }

    static int reverse_Number(int num){
        int rev = 0;
        while (num > 0) {
            int rem = num % 10;
            rev = (rev * 10) + rem;
            num = num / 10;
        }
        return rev;
    }

    static boolean isPrime(int n){
        int count = 0;
        for(int i=0; i*i<=n; i++){
            if(n % i == 0){
                count++;
                if((n/i) != i) count++;
            }
            if (count > 2) return false;
        }
        return true;
        // This is the optimize Code for checking the prime number 
    }

    static int gcd(int n , int m){
        int gcd = 1;
        for(int i=1; i<=Math.min(n, m); i++){
            if((n % i == 0) && (m % i == 0)){
                gcd = i;
            }
        }
        return gcd;
    }

    static int gcd2(int n , int m){
        int gcd = 1;
        for(int i = Math.min(n, m); i>=1; i--){
            if((n % i == 0) && (m % i == 0)){
                gcd = i;
                break;
            }
        }
        return gcd;
        // this is optimize code for getting a GCD but not for all the case

    }


   

    static int gdc3(int a , int b){
        while (a > 0 && b > 0) {
            if (a > b) a = a % b;
            else b = b % b;
        }
        if(a == 0) return b;
        return a;
        // This the most optimimize opproch for find the GCD of two number it come for eqaladrian algorithm
        // This is the maths concept 
    }

    static boolean is_Armstrong(int number){
        
        int sum = 0;
        int temp = number;
        while (number > 0) {
            int rem = number % 10;
            sum += rem * rem * rem;
            number = number / 10;
        }
        if (sum == temp) return true;

        return false;
    }

    public static void main(String[] args) {
       
        




    }
}
