package com.gustavoadono.vocabulary.service;

import com.gustavoadono.vocabulary.model.Word;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class VocabularyService {

    private final List<Word> wordList = new ArrayList<>();

    public enum InsertWordResult {
        ADDED,
        DUPLICATE,
        INVALID
    }

    public InsertWordResult insertWord(String japanese, String romaji, String meaning) {

        if (japanese == null || japanese.isBlank()
                || romaji == null || romaji.isBlank()
                || meaning == null || meaning.isBlank()) {
            return InsertWordResult.INVALID;
        }

        Word newWord = new Word(japanese, romaji, meaning);

        if (wordList.contains(newWord)) {
            return InsertWordResult.DUPLICATE;
        }

        wordList.add(newWord);
        return InsertWordResult.ADDED;
    }

    public boolean removeWord(String japanese) {

        if (japanese == null || japanese.isBlank()) {
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

    public List<Word> listAllWords() {
        return new ArrayList<>(wordList);
    }

    public List<Word> searchWord(String wordToSearch) {

        List<Word> wordsFound = new ArrayList<>();

        if (wordToSearch == null || wordToSearch.isBlank()) {
            return wordsFound;
        }

        for (Word word : wordList) {
            if (word.getJapanese().equals(wordToSearch)
                    || word.getRomaji().equals(wordToSearch)
                    || word.getMeaning().equals(wordToSearch)) {
                wordsFound.add(word);
            }
        }

        return wordsFound;
    }
}