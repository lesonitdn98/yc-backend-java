package me.leson.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "sugar")
public class Sugar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private int id;

    @JsonProperty("sugar")
    private String sugar;

    public Sugar() {
    }

    public Sugar(String sugar) {
        this.sugar = sugar;
    }
}
