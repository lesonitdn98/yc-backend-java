package me.leson.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    @JsonProperty("account")
    private Account account;

    @JsonProperty("name")
    private String name;

    @JsonProperty("image")
    private String image;

    @JsonProperty("email")
    private String email;

    @JsonProperty("address")
    private String address;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("point")
    private int point;

    @JsonProperty("userStatus")
    private String userStatus;

    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    public User(Account account, String name, String image, String email, String address, String phone, Integer point, String userStatus) {
        this.account = account;
        this.name = name;
        this.image = image;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.point = point;
        this.userStatus = userStatus;
    }

    public static class UserBuilder {
        private Account account;
        private String name;
        private String image;
        private String email;
        private String address;
        private String phone;
        private int point;
        private String userStatus;

        public UserBuilder withAccount(Account account) {
            this.account = account;
            return this;
        }

        public UserBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder withPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public UserBuilder withImage(String image) {
            this.image = image;
            return this;
        }

        public UserBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder withAddress(String address) {
            this.address = address;
            return this;
        }

        public UserBuilder withPoint(int point) {
            this.point = point;
            return this;
        }

        public UserBuilder withStatus(String status) {
            this.userStatus = status;
            return this;
        }

        public User build() {
            return new User(this.account, this.name, this.image, this.email, this.address,
                    this.phone, this.point, this.userStatus);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User member = (User) o;
        return Objects.equals(this.id, member.id) &&
                Objects.equals(this.account, member.account) &&
                Objects.equals(this.name, member.name) &&
                Objects.equals(this.image, member.image) &&
                Objects.equals(this.email, member.email) &&
                Objects.equals(this.address, member.address) &&
                Objects.equals(this.phone, member.phone) &&
                Objects.equals(this.point, member.point) &&
                Objects.equals(this.userStatus, member.userStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, account, name, image, email, address, phone, point, userStatus);
    }
}
