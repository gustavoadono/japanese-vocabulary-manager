package com.gustavoadono.vocabulary.service;

import com.gustavoadono.vocabulary.model.Word;

import java.util.HashSet;
import java.util.Set;

public class VocabularyService {
    Set<Word> wordSet = new HashSet<>();
    Long idCounter;

    public void insertWord(String japanese,String romaji, String meaning){

        if(japanese!= null && romaji!= null && meaning != null){
            wordSet.add(new Word(japanese,romaji,meaning));
        }

    }
    public void removeWord(Word newWord){
        wordSet.remove(newWord);
    }
    public void listAllWords(){
        for (Word word : wordSet){
            System.out.println(word.getJapanese()+" - "+word.getRomaji()+" - "+word.getMeaning());
        }
    }

    public void searchWord(){

    }

}
