package com.scratchpad.service;

import java.util.Scanner;
// Doesn't work
public class PrimeNumberRecursion {
    public static void main(String[] n1) {
        //Variables declared
        Scanner userInput = new Scanner(System.in);
        int n;
        int div = 2;
        //Program is introduced
        System.out.println(" Prime Number Recursion Program");
        System.out.println("*********************************");
        //User is prompted for a number
        System.out.print("Please enter a number: ");
        n = userInput.nextInt();
        //Conditional statement prints result
        if(isPrime(n,div) == 1){System.out.println(n +" is a prime number");}
        else{System.out.println(n +" is not a prime number");}
    }
    //User input is passed to isPrime recursive method
    public static int isPrime(int n, int div) {
        if(n == 1) {return 1;}
        else if(n % div == 0) {return -1;}
        else if(n == div) {return -1;}
        else{return isPrime(n, ++div);}
    }
}
