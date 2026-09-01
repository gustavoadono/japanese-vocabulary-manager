package com.gustavoadono.vocabulary.ui;

import com.gustavoadono.vocabulary.model.Word;
import com.gustavoadono.vocabulary.service.VocabularyService;

import java.util.List;
import java.util.Scanner;

public class ConsoleApplication {

    private final Scanner scanner;
    private boolean running = true;
    private final VocabularyService vocabulary = new VocabularyService();

    public ConsoleApplication(Scanner scanner) {
        this.scanner = scanner;
    }

    public void runApplication() {

        while (running) {
            displayMenu();

            int choice;
            try {
                String input = scanner.nextLine();
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid option.");
                continue;
            }


            switch (choice) {
                case 1:
                    addWord();
                    break;
                case 2:
                    listWords();
                    break;
                case 3:
                    searchWord();
                    break;
                case 4:
                    removeWord();
                    break;
                case 0:
                    running = false;
                    System.out.println("Good bye!");
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }

        }

    }

    private void removeWord() {
        System.out.println("REMOVE WORD");
        System.out.println("Japanese: ");
        String wordToRemove = scanner.nextLine();

        if (vocabulary.removeWord(wordToRemove)) {
            System.out.println("Word " + wordToRemove + " removed");
        } else {
            System.out.println("Word not found.");
        }
    }

    private void searchWord() {
        System.out.println("SEARCH WORD");
        System.out.println("Search: ");
        String search = scanner.nextLine();
        List<Word> results = vocabulary.searchWord(search);

        if (results.isEmpty()) {
            System.out.println("Word not found.");
        } else {
            for (Word word : results) {
                System.out.println(
                        word.getJapanese() + " - "
                                + word.getRomaji() + " - "
                                + word.getMeaning()
                );
            }
        }
    }


    private void listWords() {
        for (Word word : vocabulary.listAllWords()) {
            System.out.println(
                    word.getJapanese() + " - "
                            + word.getRomaji() + " - "
                            + word.getMeaning()
            );
        }
    }

    private void addWord() {
        System.out.println("ADD WORD");
        System.out.println("Japanese: ");
        String japanese = scanner.nextLine();
        System.out.println("Romaji: ");
        String romaji = scanner.nextLine();
        System.out.println("Meaning: ");
        String meaning = scanner.nextLine();
        VocabularyService.InsertWordResult result =
                vocabulary.insertWord(japanese, romaji, meaning);

        switch (result) {
            case ADDED:
                System.out.println("Word added successfully.");
                break;

            case DUPLICATE:
                System.out.println("This word already exists.");
                break;

            case INVALID:
                System.out.println(
                        "The word must have a Japanese word, romaji, and meaning."
                );
                break;
        }
    }

    private void displayMenu() {

        System.out.println("================================");
        System.out.println("     JAPANESE VOCABULARY");
        System.out.println("================================");


        System.out.println("1. Add word");
        System.out.println("2. List words");
        System.out.println("3. Search word");
        System.out.println("4. Remove word");
        System.out.println("0. Exit");
        System.out.println("Choose an option: ");

    }
}
