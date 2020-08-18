package com.bobbyberu.japanesecards.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    private String kanji;

    private String kana;

    private String traduction;

    public Card removeWhitespaces() {
        kanji = kanji.replaceAll("\\s", "");
        kana = kana.replaceAll("\\s", "");
        return this;
    }
}
