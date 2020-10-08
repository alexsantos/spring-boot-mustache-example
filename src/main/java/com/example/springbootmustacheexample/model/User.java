package com.example.springbootmustacheexample.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = {"email"})
@ToString
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    @Column(unique = true)
    private String email;
    @OneToOne
    private ValueSet gender;
    private String phone;
    private String address;

    public User(@NotNull String name, @NotNull String email, ValueSet gender, String phone, String address) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
    }

    public User() {
    }
}