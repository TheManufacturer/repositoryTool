package com.example.EsercitazioneDTO.player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerEntity, Long> {
    //Qui potremmo inserire le query relative a "Player"
}
