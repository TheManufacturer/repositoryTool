package com.example.EsercitazioneDTO.player;

import com.example.EsercitazioneDTO.player.dto.CreatePlayerRequest;
import com.example.EsercitazioneDTO.player.dto.PlayerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.EsercitazioneDTO.player.PlayerModel.*;

@Service
public class PlayerService {
    @Autowired
    PlayerRepository playerRepository;

    //metodoCreazioneDaCreatePlayerRequest
    public ResponseEntity<?> createPlayer(CreatePlayerRequest request) {
        if (convertDate(request.getDateOfBirth()) == null) {
            return ResponseEntity.status(600).body("Date of Birth is wrong");
        } else {
            PlayerModel playerRequestModel = mapRequestToModel(request);
            PlayerEntity playerRequestEntity = mapModelToEntity(playerRequestModel);
            PlayerEntity savedResponseEntity = playerRepository.saveAndFlush(playerRequestEntity);
            PlayerModel playerResponseModel = mapEntityToModel(savedResponseEntity);
            return new ResponseEntity<PlayerResponse>(mapModelToResponse(playerResponseModel), HttpStatus.OK);
        }
    }


    //metodoRitornoGiocatoreSingolo
    public Optional<PlayerResponse> findSinglePlayer(Long id) {
        Optional<PlayerEntity> response = playerRepository.findById(id);
        if (response.isPresent()) {
            return Optional.of(PlayerModel.mapModelToResponse(PlayerModel.mapEntityToModel(response.get())));
        } else {
            return Optional.empty();
        }
    }

    //metodoRitornoTuttiGiocatori
    public List<PlayerResponse> findAllPlayer() {
        List<PlayerEntity> response = playerRepository.findAll();
        List<PlayerResponse> result = new ArrayList<>();
        for (PlayerEntity playerEntity : response) {
            PlayerModel entityToModel = PlayerModel.mapEntityToModel(playerEntity);
            result.add(PlayerModel.mapModelToResponse(entityToModel));
        }
        return result;
    }


    //metodoUpdatePlayer
    public PlayerResponse updatePlayer(Long id, CreatePlayerRequest createPlayerRequest) {
        Optional<PlayerEntity> updatedPlayer = playerRepository.findById(id);
        if (updatedPlayer.isPresent()) {
            updatedPlayer.get().setName(createPlayerRequest.getName());
            updatedPlayer.get().setSurname(createPlayerRequest.getSurname());
            updatedPlayer.get().setNumber(createPlayerRequest.getNumber());
            updatedPlayer.get().setDateOfBirth(convertDate(createPlayerRequest.getDateOfBirth()));
            PlayerModel playerEntityToModel = PlayerModel.mapEntityToModel(playerRepository.saveAndFlush(updatedPlayer.get()));
            return PlayerModel.mapModelToResponse(playerEntityToModel);
        } else {
            return null;
        }
    }


    //metodoElimina
    public Boolean deletePlayer(Long id) {
        try {
            playerRepository.deleteAll();
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }


    //metodoConvertiData
    private OffsetDateTime convertDate(String date) {
        try {

            return OffsetDateTime.parse(date);

        } catch (DateTimeParseException e) {
            return null;
        }
    }

}
