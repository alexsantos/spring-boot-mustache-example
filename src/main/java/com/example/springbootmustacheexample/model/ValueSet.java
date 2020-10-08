package com.example.springbootmustacheexample.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@ToString
public class ValueSet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String code;
    private String display;
    private String definition;
    @NotNull
    private String system;

    public ValueSet() {
    }

    public ValueSet(@NotNull String code, String display, String definition, @NotNull String system) {
        this.code = code;
        this.display = display;
        this.definition = definition;
        this.system = system;
    }
}
