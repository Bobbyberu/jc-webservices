package com.bobbyberu.japanesecards.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Lot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String name;

    Date creationDate;

    ArrayList<Card> cards;
}
