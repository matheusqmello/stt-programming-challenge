package com.stt.challenge.question1;

public class DivisibleCounter {

    public void countDivisibles(int limit) {
        for (int i = 0; i <= limit; i++) {

            if (isDivBy3And5(i)) {
                log("C");
                continue;
            }

            if (isDivBy3(i)) {
                log("A");
                continue;
            }

            if (isDivBy5(i)) {
                log("B");
                continue;
            }
        }
    }

    public boolean isDivBy3And5(int num) {
        return isDivBy3(num) && isDivBy5(num);
    }

    public boolean isDivBy3(int num) {
        return isNotZero(num) && num % 3 == 0;
    }

    public boolean isDivBy5(int num) {
        return isNotZero(num) && num % 5 == 0;
    }

    protected boolean isNotZero(int num) {
        return num != 0;
    }

    protected void log(String text) {
        System.out.println(text);
    }
}
