package com.example.jwt_tokens.role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @SequenceGenerator(
            name = "role_sequence",
            sequenceName = "role_sequence",
            initialValue = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "role_sequence"
    )
    private Long id;
    private String name;
}
