package com.stt.challenge.question2;

import java.util.Scanner;

public class ConsoleApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Type anything: ");
        String userInput = scanner.nextLine();

        CustomStringSorter sorter = new CustomStringSorter();
        sorter.sort(userInput);
    }

}
