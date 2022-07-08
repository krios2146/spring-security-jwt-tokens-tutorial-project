package com.example.jwt_tokens.message;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Message {
    @Id
    @SequenceGenerator(
            name = "message_sequence",
            sequenceName = "message_sequence",
            initialValue = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "message_sequence"
    )
    private Long id;
    private String text;
    @OneToMany(fetch = FetchType.EAGER)
    private Long sender;
    @OneToMany(fetch = FetchType.EAGER)
    private Long receiver;

    public Message(String text, Long sender, Long receiver) {
        this.text = text;
        this.sender = sender;
        this.receiver = receiver;
    }
}
