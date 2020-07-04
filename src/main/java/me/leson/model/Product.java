package me.leson.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "detail_id", referencedColumnName = "id")
    @JsonProperty("detail")
    private ProdustDetail detail;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "size_id", referencedColumnName = "id")
    @JsonProperty("size")
    private Size size;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sugar_id", referencedColumnName = "id")
    @JsonProperty("sugar")
    private Sugar sugar;

    @JsonProperty("ice")
    private boolean ice;

    @JsonProperty("discount")
    private double discount;

    @JsonProperty("price")
    private double price;
}
