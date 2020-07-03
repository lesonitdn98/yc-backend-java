package me.leson.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private int id;

    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    @JsonProperty("role")
    private Role role;

    @JsonProperty("enabled")
    private Boolean enabled;

    public Account() {
    }

    public Account(String username, String password, Role role, Boolean enabled) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.enabled = enabled;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public static class AccountBuilder {
        private String username;
        private String password;
        private Role role;
        private Boolean enabled;

        public AccountBuilder accountBuilder(String username, String password) {
            this.username = username;
            this.password = enCodePass(password);
            return this;
        }

        public AccountBuilder withRole(Role role) {
            this.role = role;
            return this;
        }

        public AccountBuilder withEnable(Boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        public Account builder() {
            return new Account(username, password, role, enabled);
        }

        public String enCodePass(String password) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
            return encoder.encode(password);
        }
    }
}
