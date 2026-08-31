package com.gustavoadono.vocabulary.ui;

import com.gustavoadono.vocabulary.service.VocabularyService;

import java.util.Scanner;

public class ConsoleApplication {

    Scanner scanner;
    int choice = 0 ;
    String japanese;
    String romaji;
    String meaning;
    VocabularyService vocabulary = new VocabularyService();

    public ConsoleApplication(Scanner scanner) {
        this.scanner = scanner;
    }

    public  boolean runApplication(){

        System.out.println("================================");
        System.out.println("     JAPANESE VOCABULARY");
        System.out.println("================================");


        while (choice >= 0) {
            listOptions();

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:

                    System.out.println("ADD WORD");
                    System.out.println("Japanese: ");
                    japanese = scanner.nextLine();
                    System.out.println("Romaji: ");
                    romaji = scanner.nextLine();
                    System.out.println("Meaning: ");
                    meaning = scanner.nextLine();
                    vocabulary.insertWord(japanese,romaji,meaning);
                    break;
                case 2:
                    vocabulary.listAllWords();
                    break;
                case 3:
                 
                    break;
                case 4:
                    vocabulary.listAllWords();
                    System.out.println("REMOVE WORD");
                    System.out.println("Japanese: ");
                    japanese = scanner.nextLine();
                    if(vocabulary.removeWord(japanese)){
                        System.out.println("word "+japanese+" removed");
                    }
                    else{
                        System.out.println("word not found");
                    }
                    break;
                case 0:
                    choice = -1;

                    break;
                default:
                    break;
            }

            return true;

        }


        return false;

    }

    public void listOptions(){
        System.out.println("1. Add word");
        System.out.println("2. List word");
        System.out.println("3. Search word");
        System.out.println("4. Remove word");
        System.out.println("0. Exit");
        System.out.println("Choose an option: ");
    }
}
