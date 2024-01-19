package edu.hw8.task2;

public class Fibonacci {
    private Fibonacci() {

    }

    public static long countFib(int n) {
        if (n <= 1) {
            return n;
        }
        return countFib(n - 1) + countFib(n - 2);
    }

//    public static void main(String[] args) {
//        System.out.println(countFib(8));
//    }
}
