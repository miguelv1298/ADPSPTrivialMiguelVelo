package org.example.server.games;

import jakarta.persistence.*;
import org.hibernate.annotations.CurrentTimestamp;
import org.hibernate.generator.EventType;

import java.time.LocalDateTime;
@Entity
public class Game {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Player player;
    private int score;
    @CurrentTimestamp (event = EventType.INSERT)
    private LocalDateTime date;

    public Game(Player player, int score, LocalDateTime date) {
        this.player = player;
        this.score = score;
        this.date = date;
    }
}
