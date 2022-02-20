package com.bridgelab;

import java.util.Scanner; // import scanner class

public class Gambler {


    static int TOTAL_AMOUNT_DIFF_IN_MONTH=0;
    static int WON=1;
    static int LOST=0;

    public static void main(String[] args) {
        int maximumWon[]= new int[100];
        int maximumLost[]= new int[100];
        int month =1;
        Scanner sc = new Scanner(System.in);
        boolean label = true;
        while(label) {
            System.out.println(" Month"+month+" gambling starts");
            System.out.println("Enter starting amount of stake ");
            int amountOfStake = sc.nextInt();
            System.out.println("Enter amount to bet ");
            int betAmount = sc.nextInt();
            int totalAmount = 0;
            for (int i = 1; i <= 20; i++) {
                int cashInHand = amountOfStake;
                while(cashInHand > amountOfStake /2 && cashInHand < amountOfStake * 1.5) {
                    int play = (int) Math.floor(Math.random() * 10) % 2;
                    System.out.println("Gamblers play:"+play);
                    switch(play) {
                        case 1:
                            cashInHand = cashInHand + betAmount;
                            System.out.println("Total current cash gambler has "+cashInHand);
                            break;
                        case 0:
                            cashInHand = cashInHand - betAmount;
                            System.out.println("Total current cash gambler has "+cashInHand);
                            break;
                        default:
                            System.out.println("default");
                    }
                }
                if(cashInHand==(amountOfStake / 2) || cashInHand==(amountOfStake * 1.5)) {
                    System.out.println("Player would like to resign for current day"+i);
                }
                if(cashInHand > amountOfStake) {
                    int amountWonPerDay = cashInHand - amountOfStake;
                    System.out.println("Player won day"+i+" RS "+amountWonPerDay);
                }
                else if(cashInHand < amountOfStake){
                    int amountLostPerDay = amountOfStake - cashInHand;
                    System.out.println("Player lost day"+i+" RS "+amountLostPerDay);
                }
                if(cashInHand == (amountOfStake * 1.5)) {
                    maximumWon[i] = cashInHand;
                }
                else if (cashInHand == 50) {
                    maximumLost[i] = cashInHand;
                }
                totalAmount = totalAmount + cashInHand;
            }
            System.out.println("Luckiest days as following as gambler WON maximum amount");
            for(int i = 1; i <= 20; i++) {
                if(maximumWon[i] == (amountOfStake * 1.5))
                    System.out.println("Day"+i+" won "+maximumWon[i]+" $");
            }
            System.out.println("Unluckiest days as following as gambler LOST maximum amount");
            for(int i = 1; i <= 20; i++) {
                if(maximumLost[i]== (amountOfStake / 2))
                    System.out.println("Day"+i+" lost "+maximumLost[i]+" $");
            }
            System.out.println("Total amount player has after 20 days as per day included = "+totalAmount+" $");
            TOTAL_AMOUNT_DIFF_IN_MONTH = totalAmount - amountOfStake * 20;
            if(TOTAL_AMOUNT_DIFF_IN_MONTH > 0) {
                System.out.println("Total cash gambler won in month"+month+"= "+TOTAL_AMOUNT_DIFF_IN_MONTH+" $");
            }
            else if(TOTAL_AMOUNT_DIFF_IN_MONTH < 0) {
                System.out.println("Total cash gambler lost in month"+month+"= "+TOTAL_AMOUNT_DIFF_IN_MONTH+" $");
            }
            else {
                System.out.println("Total cash gambler neither lost or won in month"+month+"= "+TOTAL_AMOUNT_DIFF_IN_MONTH+" $");
            }
            System.out.println();
            if(TOTAL_AMOUNT_DIFF_IN_MONTH > 0) {
                System.out.println("Do you want to continue playing for next month");
                System.out.println("If you want to continue playing type '1'");
                System.out.println("if you want stop gambling type '2'");
                int responseToPlay = sc.nextInt();
                if(responseToPlay == 1) {
                    label = true;
                    month++;
                }
                else {
                    label = false;
                    System.out.println("Thanks for Playing");
                }
            }
            else {
                System.out.println("You are in loss");
                System.out.println("Thanks for Playing");
                break;
            }
        }
    }
}