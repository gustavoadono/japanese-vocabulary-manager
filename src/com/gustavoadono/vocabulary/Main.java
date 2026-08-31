package com.gustavoadono.vocabulary;

import com.gustavoadono.vocabulary.ui.ConsoleApplication;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ConsoleApplication vocab = new ConsoleApplication(new Scanner(System.in));
        while(vocab.runApplication()){

        };
    }
}
