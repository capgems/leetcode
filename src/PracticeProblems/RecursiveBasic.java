package PracticeProblems;

public class RecursiveBasic {
    public static void main(String[] args) {

        // foo(3);
        System.out.println(fibonocciSeries(5));

    }

    static void foo(int n) {
        if (n < 1) {
            System.out.println("Final n value was");
        } else {
            foo(n - 1);
            System.out.println("Foo() invoked with n value is: " + n);
        }
    }

    static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            n = n * factorial(n - 1);
        }
        return n;
    }

    static int fibonocciSeries(int n) {

        if ( n < 1 ) {
            throw new RuntimeException ( "Fool" );
        } else if ( n == 1 || n == 2 ) {
            return n - 1;
        } else {
            return fibonocciSeries ( n - 1 ) + fibonocciSeries ( n - 2 );
        }
    }

}



