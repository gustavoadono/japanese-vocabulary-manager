package com.gustavoadono.vocabulary.ui;

import com.gustavoadono.vocabulary.model.Word;
import com.gustavoadono.vocabulary.service.VocabularyService;

import java.util.List;
import java.util.Scanner;

public class ConsoleApplication {

    Scanner scanner;
    int choice = 0;
    boolean running = true;
    String menu;
    String japanese;
    String romaji;
    String meaning;
    String search;
    VocabularyService vocabulary = new VocabularyService();

    public ConsoleApplication(Scanner scanner) {
        this.scanner = scanner;
    }

    public void runApplication() {

        while (running) {
            listOptions();

            try {
                menu = scanner.nextLine();
                choice = Integer.parseInt(menu);
            } catch (NumberFormatException e) {
                System.out.println("Invalid option.");
                continue;
            }


            switch (choice) {
                case 1:

                    System.out.println("ADD WORD");
                    System.out.println("Japanese: ");
                    japanese = scanner.nextLine();
                    System.out.println("Romaji: ");
                    romaji = scanner.nextLine();
                    System.out.println("Meaning: ");
                    meaning = scanner.nextLine();
                    vocabulary.insertWord(japanese, romaji, meaning);
                    break;
                case 2:
                    vocabulary.listAllWords();
                    break;
                case 3:
                    System.out.println("SEARCH WORD");
                    System.out.println("Search: ");
                    search = scanner.nextLine();
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

                    break;
                case 4:
                    System.out.println("REMOVE WORD");
                    System.out.println("Japanese: ");
                    japanese = scanner.nextLine();
                    if (vocabulary.removeWord(japanese)) {
                        System.out.println("word " + japanese + " removed");
                    } else {
                        System.out.println("word not found");
                    }
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

    public void listOptions() {

        System.out.println("================================");
        System.out.println("     JAPANESE VOCABULARY");
        System.out.println("================================");


        System.out.println("1. Add word");
        System.out.println("2. List word");
        System.out.println("3. Search word");
        System.out.println("4. Remove word");
        System.out.println("0. Exit");
        System.out.println("Choose an option: ");

    }
}
