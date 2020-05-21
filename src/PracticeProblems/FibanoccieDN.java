package PracticeProblems;

public class FibanoccieDN {


    public static void main(String[] args) {
        //System.out.println(findFibonocci(6));
        System.out.println(factorial(4));
    }

    static int findFibonocci(int n){
        if(n < 1)
            throw new RuntimeException("Sorry");
        if(n == 1 )
            return 0;
        if( n == 2 )
            return 1;

        return findFibonocci(n-1) + findFibonocci(n-2);
    }

    static int factorial(int n){
        if ( n <0 )
            throw new RuntimeException("Sorry");
        if(n==0)
            return 1;
        if(n ==1 )
            return 1;
        return n * factorial(n-1);
    }
}
