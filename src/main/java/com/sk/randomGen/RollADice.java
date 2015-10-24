package com.sk.randomGen;

/**
 * Created by suppalamethi on 10/19/2015.
 */
public class RollADice {

    public static void main(String[] args) {
        System.out.println(roll());
        System.out.println(roll());
        System.out.println(roll());
        System.out.println(roll());
        System.out.println(roll());
        System.out.println(roll());
    }

    static long roll() {

        return Math.round(Math.random() * 5 + 1);

    }
}

