package com.gustavoadono.vocabulary.service;

import com.gustavoadono.vocabulary.model.Word;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VocabularyService {
    List<Word> wordList = new ArrayList<>();


    public boolean insertWord(String japanese, String romaji, String meaning) {

        if (japanese == null || japanese.isBlank()
                || romaji == null || romaji.isBlank()
                || meaning == null || meaning.isBlank()) {

            System.out.println("The word must have a Japanese word, romaji, and meaning.");
            return false ;
        }

        Word newWord = new Word(japanese, romaji, meaning);

        if(wordList.contains(newWord)){
            System.out.println("This word already exists!");
            return false;
        }

        wordList.add(newWord);
        System.out.println("Word added successfully.");
        return  true;
    }

    public boolean removeWord(String japanese) {

        if(japanese== null || japanese.isBlank()){
            return false;
        }

        Iterator<Word> wordIterator = wordList.iterator();

        while (wordIterator.hasNext()) {
            if (wordIterator.next().getJapanese().equals(japanese)) {
                wordIterator.remove();
                return true;
            }
        }
        return false;
    }

    public void listAllWords() {
        for (Word word : wordList) {
            System.out.println(word.getJapanese() + " - " + word.getRomaji() + " - " + word.getMeaning());
        }
    }

    public void searchWord() {

    }

}
