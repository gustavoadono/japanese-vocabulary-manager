package com.gustavoadono.vocabulary.model;

import java.util.Objects;

public class Word {

    String japanese;
    String romaji;
    String meaning;

    public Word(String japanese, String romaji, String meaning) {
        this.japanese = japanese;
        this.romaji = romaji;
        this.meaning = meaning;
    }

    public String getJapanese() {
        return japanese;
    }

    public String getRomaji() {
        return romaji;
    }

    public String getMeaning() {
        return meaning;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return Objects.equals(japanese, word.japanese);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(japanese);
    }

    @Override
    public String toString() {
        return "Word{" +
                "japanese='" + japanese + '\'' +
                ", romaji='" + romaji + '\'' +
                ", meaning='" + meaning + '\'' +
                '}';
    }
}
