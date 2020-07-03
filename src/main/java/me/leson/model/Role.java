package me.leson.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String role;

    public Role() {
    }

    public Role(String role) {
        this.role = role;
    }
}
