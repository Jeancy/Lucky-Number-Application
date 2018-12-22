package luckynumber;

/**
 *
 * @author Jeancy Tshibemba
 */
public class LuckyNumber {

    public static long countLuckyNumber(long a, long b) {
         int size = (int) (b-a)+1; // the size of the array of the number between the bounderies.
         long []sum = new long[size]; // Array of the sums of the digit of the numbers
         long []sqsum = new long[size]; // Array of the squares of the digits
         long count = 0; // The number of the lucky numbers
         int index = 0;//index of the array
         for(long i = a;i<=b;i++){
             sum[index] = getSum(i);              
             sqsum[index] = sumSquareDigits(i);
             if(isPrime(sum[index]) && isPrime(sqsum[index])) {
                 count++;
             }
             index++;
         }
         System.out.println(count);
         return count;
    }
    // Method to compute if a given number is prime number or not.
    public static boolean isPrime(long n){
        boolean prime = true;
         for (int i = 2; i <= n/2; i++) {
             if(n % i  == 0){
                prime = false;
                break;
             }
        }

        return prime;
    }
    // Computing the sum of the digits of a given number
    public static long getSum(long n){    
        long sum = 0;
        while (n != 0){
             sum = sum + n % 10;
             n = n/10;
        }
        return sum;
    }

    //recursive method;
    public static long sumSquareDigits(long n) {
        if (n < 10){  // for a number less than 10 , sum of square is just the quare of the number.
            return (long) Math.pow(n, 2); //base case;
        }   
        return (long) ((Math.pow((n % 10),2) + sumSquareDigits(n/10)));
           
    }
    
    public static void main(String[] args) {
        LuckyNumber.countLuckyNumber(20, 25);
        LuckyNumber.countLuckyNumber(120, 130);
    }
    
}
