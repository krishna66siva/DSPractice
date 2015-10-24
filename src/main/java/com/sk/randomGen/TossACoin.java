package com.sk.randomGen;

/**
 * Created by suppalamethi on 10/19/2015.
 */
public class TossACoin {

    public static void main(String[] args) {
        System.out.println(toss());
        System.out.println(toss());
        System.out.println(toss());
        System.out.println(toss());
        System.out.println(toss());
        System.out.println(toss());
    }

    static int toss() {
        return Math.random() < 0.5 ? 0 : 1;
    }
}

