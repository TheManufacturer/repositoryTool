package com.example.EsercitazioneDTO.player;

import com.example.EsercitazioneDTO.player.dto.CreatePlayerRequest;
import com.example.EsercitazioneDTO.player.dto.PlayerResponse;
import org.apache.logging.log4j.util.PerformanceSensitive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/v1/player")
public class PlayerController {
    @Autowired
    PlayerService playerService;

    @PostMapping("/create")
    public ResponseEntity<?> createPlayer(@RequestBody CreatePlayerRequest request){
        return playerService.createPlayer(request);
    }

    @GetMapping("/{id}")
    public Optional<PlayerResponse> getSinglePlayer(@PathVariable Long id){
        return playerService.findSinglePlayer(id);
    }

    @GetMapping("/players")
    public List<PlayerResponse> getAllPlayer(){
        return playerService.findAllPlayer();
    }

    @PutMapping(path = "/{id}/update")
    public PlayerResponse updatePlayer(@PathVariable Long id, @RequestBody CreatePlayerRequest createPlayerRequest){
        return playerService.updatePlayer(id, createPlayerRequest);
    }

    @DeleteMapping(path = "/{id}/delete")
    public Boolean deletePlayer(@PathVariable Long id){
        return playerService.deletePlayer(id);
    }

}
