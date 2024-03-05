package com.example.EsercitazioneDTO.player;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;

@Table
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PlayerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private int number;
    private OffsetDateTime dateOfBirth;
}