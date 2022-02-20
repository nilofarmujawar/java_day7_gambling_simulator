package com.bridgelab;

import java.util.Scanner; // import scanner class

public class Gambler {


    static int AMOUNT_OF_STAKE=100;
    static int TOTAL_AMOUNT_DIFF_IN_MONTH=0;
    static int BET_AMOUNT=1;
    static int WON=1;
    static int LOST=0;
    static int TOTAL_AMOUNT=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Starting amount of stake is "+AMOUNT_OF_STAKE);
        System.out.println("Amount to bet after every play "+BET_AMOUNT);
        for (int i = 1; i <= 20; i++) {
            int cashInHand = AMOUNT_OF_STAKE;
            while(cashInHand > 50 && cashInHand < 150) {
                int play = (int) Math.floor(Math.random() * 10) % 2;
                System.out.println("Gamblers play:"+play);

                switch(play) {
                    case 1:
                        cashInHand = cashInHand + BET_AMOUNT;
                        System.out.println("Total current cash gambler has "+cashInHand);
                        break;
                    case 0:
                        cashInHand = cashInHand - BET_AMOUNT;
                        System.out.println("Total current cash gambler has "+cashInHand);
                        break;
                    default:
                        System.out.println("default");
                }

            }
            if(cashInHand==150 || cashInHand==50) {
                System.out.println("Player would like to resign for current day"+i);
            }
            if(cashInHand > 100) {
                int amountWonPerDay = cashInHand - AMOUNT_OF_STAKE;
                System.out.println("Player won day"+i+" RS "+amountWonPerDay);
            }
            else if(cashInHand < 100){
                int amountLostPerDay = AMOUNT_OF_STAKE - cashInHand;
                System.out.println("Player lost day"+i+" RS "+amountLostPerDay);

            }
            if(cashInHand == 150) {
                System.out.println("Day"+i+" is gamblers Luckiest day as he won maximum amount "+cashInHand+" RS");
            }
            else if (cashInHand == 50) {
                System.out.println("Day"+i+" is gamblers Unluckiest day as he lost maximum amount "+cashInHand+" RS");
            }
            TOTAL_AMOUNT = TOTAL_AMOUNT + cashInHand;
        }
        System.out.println("Total amount player has after 20 days as per day included = "+TOTAL_AMOUNT+" $");
        TOTAL_AMOUNT_DIFF_IN_MONTH = TOTAL_AMOUNT - AMOUNT_OF_STAKE * 20;
        if(TOTAL_AMOUNT_DIFF_IN_MONTH > 0) {
            System.out.println("Total cash gambler won "+TOTAL_AMOUNT_DIFF_IN_MONTH+" $");
        }
        else {
            System.out.println("Total cash gambler lost in that month "+TOTAL_AMOUNT_DIFF_IN_MONTH+" $");
        }
    }
}