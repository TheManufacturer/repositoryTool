package com.example.EsercitazioneDTO.player.dto;

import lombok.*;

//Questo DTO lo useremo per chiamate tipo : GET
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlayerResponse {
    private Long id;

    private String name;
    private String surname;
    private int number;
    private String dateOfBirth;
}
