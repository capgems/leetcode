package PracticeProblems;

public class Main {


    public static void main(String[] args) {
        int primeNum =16;
        boolean isPrime=true;
        // 1,0 are not prime numbers
        // also no number cannot be divisible morethan half of its number.
        int remainder = -1;
        for(int i=2;i<primeNum/2;i++){
            remainder=primeNum%i;
            if(remainder ==0){
                isPrime =false;
                System.out.println("its not a prime number");
                break;
            }
        }
        if(isPrime){
            System.out.println("its a prime number");
        }

    }

}
