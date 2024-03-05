package com.example.EsercitazioneDTO.player;

import com.example.EsercitazioneDTO.player.dto.CreatePlayerRequest;
import com.example.EsercitazioneDTO.player.dto.PlayerResponse;
import lombok.*;

import java.time.OffsetDateTime;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlayerModel {

    private Long id;
    private String name;
    private String surname;
    private int number;
    private OffsetDateTime dateOfBirth;


    //rappresenta la conversione dei dati dal formato del database al formato del modello utilizzato nell'applicazione
    public static PlayerModel mapEntityToModel(PlayerEntity playerEntity) {
        return new PlayerModel(
                playerEntity.getId(),
                playerEntity.getName(),
                playerEntity.getSurname(),
                playerEntity.getNumber(),
                playerEntity.getDateOfBirth()
        );
    }

    //rappresenta la conversione dei dati dal formato del modello utilizzato nell'applicazione al formato del database
    public static PlayerEntity mapModelToEntity(PlayerModel playerModel) {
        return new PlayerEntity(
                playerModel.getId(),
                playerModel.getName(),
                playerModel.getSurname(),
                playerModel.getNumber(),
                playerModel.getDateOfBirth()
        );
    }

    //rappresenta la conversione dei dati del giocatore nel formato richiesto per le risposte alle richieste HTTP
    public static PlayerResponse mapModelToResponse(PlayerModel playerModel) {
        return new PlayerResponse(
                playerModel.getId(),
                playerModel.getName(),
                playerModel.getSurname(),
                playerModel.getNumber(),
                playerModel.getDateOfBirth() == null ? "" : playerModel.getDateOfBirth().toString()
        );
    }

    //conversione dati delle richieste HTTP per la creazione di un nuovo giocatore nel formato del modello utilizzato nell'applicazione
    public static PlayerModel mapRequestToModel(CreatePlayerRequest createPlayerRequest) {
        return new PlayerModel(
                null,
                createPlayerRequest.getName(),
                createPlayerRequest.getSurname(),
                createPlayerRequest.getNumber(),
                OffsetDateTime.parse(createPlayerRequest.getDateOfBirth())
        );
    }


}
