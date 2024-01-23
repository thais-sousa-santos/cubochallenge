package com.tsantos.cubochallenge.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private BigDecimal participation;

    public Client (String firstName, String lastName, BigDecimal participation){
        this.firstName = firstName;
        this.lastName = lastName;
        this.participation = participation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client client)) return false;
        return Objects.equals(id, client.id) &&
                Objects.equals(firstName, client.firstName) &&
                Objects.equals(lastName, client.lastName) &&
                Objects.equals(participation, client.participation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, participation);
    }
}
