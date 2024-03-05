package com.example.EsercitazioneDTO.player.dto;

import lombok.*;
//Questo DTO verrà utilizzato con chiamte tipo: post/put
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreatePlayerRequest {
    //id non presente -> Attenzione Appunti

    private String name;
    private String surname;
    private int number;
    private String dateOfBirth;
}
