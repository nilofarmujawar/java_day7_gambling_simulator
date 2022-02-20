package com.bridgelab;

import java.util.Scanner; // import scanner class

public class Gambler {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); // create scanner object

        System.out.println("Enter amount of stake :");

        int amount = sc.nextInt();

        System.out.println("Enter amount to bet after every play :");

        int bet = sc.nextInt();

        System.out.println("Amount of stake is "+amount);
        
        System.out.println("Amount to bet after every game "+bet);

    }

}

